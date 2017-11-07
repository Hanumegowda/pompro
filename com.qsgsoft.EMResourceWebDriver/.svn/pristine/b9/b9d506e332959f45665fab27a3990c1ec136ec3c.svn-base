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
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class FormNotification extends TestNG_UI_EXTENSIONS {
	
	public FormNotification() throws Exception {
		super();
	}

	/*************************************************************************************
	'Description : Verify that questions for which 'Add to Summary' check box is not selected
				   are not displayed in email notification 
	'Precondition:
	'Date	 	 : 22-Dec-2014
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that questions for which 'Add to Summary' check box is not selected are not displayed in email notification")
	public void testHappyDay151549() throws Exception {

		gstrTCID = "151549";
		gstrTO = "Verify that questions for which 'Add to Summary' check box is not selected are not displayed in email notification";

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

		Thread.sleep(80000);
		
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		Thread.sleep(10000);

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
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strDateQuestion)
						    .enterLabelName(objFormConfiguration_data.strLabelName2)
						    .deselectAddToSummary()
						    .clickOnDoneButton()
						    .clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.switchToDefaultFrame().selectFrame();

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle1 = driver1.getWindowHandle();
		
		Thread.sleep(80000);
		
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
					.enterAnswerInDateField(objBlankFormData.strCurrentDate);
		
		Thread.sleep(5000);
		
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
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strNumericAnswer + "| "
//				+ objFormConfiguration_data.strLabelName1 + ": "
//				+ objBlankFormData.strTextAnswer;
		
		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
				
		String strMsgNotPresent = "| " + objFormConfiguration_data.strLabelName2 
								  + ": " + objBlankFormData.strCurrentDate;

		Thread.sleep(5000);
		
		objRegionDefault1.selectFrame()
		               	 .verWebNotificationframe()
		                 .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
		                             						strMsg)
		                 .verWebNotificationMsgDoesNotContainGivenMsg(objFormConfiguration_data.strFormName,
		                		 							strMsgNotPresent)
						.clickAcknowledgeAllForms()
						.selectFrame();
		
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
												objUserdata.strPrimaryPwsd);
		
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
								objUserdata.strFullName, objLogindata.strRegionName,
								objFormConfiguration_data.strLabelName,
								objBlankFormData.strNumericAnswer,objFormConfiguration_data.strLabelName1,
								objBlankFormData.strTextAnswer);
		
		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
								objUserdata.strFullName, objLogindata.strRegionName,
								objFormConfiguration_data.strLabelName,
								objFormConfiguration_data.strLabelValue,objFormConfiguration_data.strLabelName1,
								objBlankFormData.strTextAnswer),
								
			  strMsgBodyNotPresent = objFormConfiguration_data.strLabelName2 + ": " + objBlankFormData.strCurrentDate,
			  
			  strMsgBodyNotPresent1 = "| " + strMsgBodyNotPresent;
		
		String strSubject = objFormConfiguration_data.strFormName;
		
		objMailVerificationFunctions.NavToInbox(strSubject);
		
		boolean blnMsg1 = false, blnMsg2 = false,
			    blnMsg3 = false, blnMsg4 = false,
			    blnMsg5 = false, blnMsg6 = false;
		
		for (int intCount = 0; intCount < 3; intCount++) {
		
			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
				blnMsg4 = objMailVerificationFunctions
						.verMailDoesNotContainGivenMsg(strMsgBodyNotPresent);
			} else if (blnMsg3 == false && blnMsg1 == true && blnMsg4 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
				blnMsg5 = objMailVerificationFunctions 
						.verMailDoesNotContainGivenMsg(strMsgBodyNotPresent);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
				blnMsg6 = objMailVerificationFunctions
						.verMailDoesNotContainGivenMsg(strMsgBodyNotPresent1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3 && blnMsg4 && blnMsg5 && blnMsg6);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that all questions that are added by selecting 'Add to Summary'
				   check box are displayed in email notification 
	'Precondition:
	'Date	 	 : 23-Dec-2014
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that all questions that are added by selecting 'Add to Summary' check box are displayed in email notification")
	public void testHappyDay151548() throws Exception {

		gstrTCID = "151548";
		gstrTO = "Verify that all questions that are added by selecting 'Add to Summary' check box are displayed in email notification";

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

		Thread.sleep(80000);
		
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		Thread.sleep(10000);

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
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
       					    .verifyEditQuestionWindow()
       					    .selectQuestionType(objFormConfiguration_data.strTextArea)
       					    .enterLabelName(objFormConfiguration_data.strLabelName1)
       					    .clickOnAddToSummary()
       					    .clickOnDoneButton()
       					    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName2)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strDateQuestion)
						    .enterLabelName(objFormConfiguration_data.strLabelName3)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
					        .verifyEditQuestionWindow()
					        .selectQuestionType(objFormConfiguration_data.strCheckBox)
					        .enterLabelName(objFormConfiguration_data.strLabelName4)
					        .clickOnAddToSummary()
					        .addChoices(objFormConfiguration_data.strChoice)
					        .clickOnDoneButton()
					        .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
                            .verifyEditQuestionWindow()
                            .selectQuestionType(objFormConfiguration_data.strRadio)
                            .enterLabelName(objFormConfiguration_data.strLabelName5)
                            .clickOnAddToSummary()
                            .addChoices(objFormConfiguration_data.strChoice1)
                            .clickOnDoneButton()
					        .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
					        .verifyEditQuestionWindow()
					        .selectQuestionType(objFormConfiguration_data.strSingleSelect)
					        .enterLabelName(objFormConfiguration_data.strLabelName6)
					        .clickOnAddToSummary()
					        .addChoices(objFormConfiguration_data.strChoice2)
					        .addNthChoice(objFormConfiguration_data.strSecChoice,objFormConfiguration_data.strChoice3)
					        .clickOnDoneButton()
					        .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
					        .verifyEditQuestionWindow()
					        .selectQuestionType(objFormConfiguration_data.strMultiSelect)
					        .enterLabelName(objFormConfiguration_data.strLabelName7)
					        .clickOnAddToSummary()
					        .addChoices(objFormConfiguration_data.strChoice4)
					        .addNthChoice(objFormConfiguration_data.strSecChoice,objFormConfiguration_data.strChoice5)
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
		
		Thread.sleep(80000);
		
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
										objBlankFormData.strTextAnswer)
					.enterAnswerInTextAreaField(objBlankFormData.strTextAreaAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName2,
										objBlankFormData.strNumericAnswer)
					.enterAnswerInChkBox(objFormConfiguration_data.strChoice)
					.enterAnswerInRadioBtn(objFormConfiguration_data.strChoice1)
					.selectSingleOption(objFormConfiguration_data.strChoice2)
					.enterAnswerInMultiSelectBox(objFormConfiguration_data.strChoice4)
					.enterAnswerInDateField(objBlankFormData.strCurrentDate)
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
		
//		String strWebNotificationMsg = "Submitted by "+objUserdata.strFullName +
//										"\nSummary: | "
//										+ objFormConfiguration_data.strLabelName + ": "+ objBlankFormData.strTextAnswer + "| "
//										+ objFormConfiguration_data.strLabelName1 + ": "+ objBlankFormData.strTextAreaAnswer + "| "
//										+ objFormConfiguration_data.strLabelName2 + ": "+ objBlankFormData.strNumericAnswer + "| "
//										+ objFormConfiguration_data.strLabelName3 + ": "+ objBlankFormData.strCurrentDate + "| "
//										+ objFormConfiguration_data.strLabelName4 + ": "+ objFormConfiguration_data.strChoice + "| "
//										+ objFormConfiguration_data.strLabelName5 + ": "+ objFormConfiguration_data.strChoice1 + "| "
//										+ objFormConfiguration_data.strLabelName6 + ": "+ objFormConfiguration_data.strChoice2 + "| "
//										+ objFormConfiguration_data.strLabelName7 + ": "+ objFormConfiguration_data.strChoice4;
		
		String strWebNotificationMsg = objRegionDefault1
				.getWebNotificationForEightQuestionnaire(
						objUserdata.strFullName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAreaAnswer,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName3,
						objBlankFormData.strCurrentDate,
						objFormConfiguration_data.strLabelName4,
						objFormConfiguration_data.strChoice,
						objFormConfiguration_data.strLabelName5,
						objFormConfiguration_data.strChoice1,
						objFormConfiguration_data.strLabelName6,
						objFormConfiguration_data.strChoice2,
						objFormConfiguration_data.strLabelName7,
						objFormConfiguration_data.strChoice4);
		
		Thread.sleep(5000);
        
        objRegionDefault1.selectFrame()
                       	 .verWebNotificationframe()
                         .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                        		 						strWebNotificationMsg)
                         .clickAcknowledgeAllForms()
                         .selectFrame();

        objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
        										objUserdata.strPrimaryPwsd);
        
        String strMsgBody = "Form submitted by "+objUserdata.strFullName + "\n\n"
							+ objFormConfiguration_data.strLabelName + ": "+ objBlankFormData.strTextAnswer + "\n"
							+ objFormConfiguration_data.strLabelName1 + ": "+ objBlankFormData.strTextAreaAnswer + "\n"
							+ objFormConfiguration_data.strLabelName2 + ": "+ objBlankFormData.strNumericAnswer + "\n"
							+ objFormConfiguration_data.strLabelName3 + ": "+ objBlankFormData.strCurrentDate + "\n"
							+ objFormConfiguration_data.strLabelName4 + ": "+ objFormConfiguration_data.strChoice + "\n"
							+ objFormConfiguration_data.strLabelName5 + ": "+ objFormConfiguration_data.strChoice1 + "\n"
							+ objFormConfiguration_data.strLabelName6 + ": "+ objFormConfiguration_data.strChoice2 + "\n"
							+ objFormConfiguration_data.strLabelName7 + ": "+ objFormConfiguration_data.strChoice4 + "\n\n"
							+ "Region: " + objLogindata.strRegionName,
				
				strPagerBody = "Form submitted by "+objUserdata.strFullName +
						"\n| "
						+ objFormConfiguration_data.strLabelName + ": "+ objBlankFormData.strTextAnswer + "| "
						+ objFormConfiguration_data.strLabelName1 + ": "+ objBlankFormData.strTextAreaAnswer + "| "
						+ objFormConfiguration_data.strLabelName2 + ": "+ objBlankFormData.strNumericAnswer + "| "
						+ objFormConfiguration_data.strLabelName3 + ": "+ objBlankFormData.strCurrentDate + "| "
						+ objFormConfiguration_data.strLabelName4 + ": "+ objFormConfiguration_data.strChoice + "| "
						+ objFormConfiguration_data.strLabelName5 + ": "+ objFormConfiguration_data.strChoice1 + "| "
						+ objFormConfiguration_data.strLabelName6 + ": "+ objFormConfiguration_data.strChoice2 + "| "
						+ objFormConfiguration_data.strLabelName7 + ": "+ objFormConfiguration_data.strChoice4 + "\n"
						+ "Region: " + objLogindata.strRegionName;
        
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
						.verifyMailBody(strPagerBody);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
}
	
