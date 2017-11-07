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
import static org.testng.Assert.*;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayCreateV3FormQuestionnaire extends TestNG_UI_EXTENSIONS {

	public HappyDayCreateV3FormQuestionnaire() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that 'Numeric' question can be added to the V3 form. 
	'Precondition:
	'Date	 	 : 15-Dec-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that 'Numeric' question can be added to the V3 form. ")
	public void testHappyDay151176() throws Exception {

		gstrTCID = "151176";
		gstrTO = "Verify that 'Numeric' question can be added to the V3 form. ";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
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

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName)
				.clickOnActivateForm();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
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
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName,objBlankFormData.strNumericAnswer)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName1,
						 	objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strNumericAnswer + "";
		
		String strMsg = objRegionDefault1.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
				objLogindata.strRegionName, objFormConfiguration_data.strLabelName, 
				objBlankFormData.strNumericAnswer);
		
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
				objBlankFormData.strNumericAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strLabelValue);

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
	 * 'Description : 	Verify that 'Date' question can be added to the V3 form. 
	 * 'Precondition : None
	 * 'Date : 21-Oct-2014 
	 * 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description = "Verify that 'Date' question can be added to the V3 form.")
	public void testHappyDay151177() throws Exception {

		gstrTCID = "151177";
		gstrTO = "Verify that 'Date' question can be added to the V3 form.";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
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

		objFormConfiguration.verTemplateDesignPage();

		objFormConfiguration.clickOnInsert();

		objFormConfiguration.clickOnGroupLink();

		objFormConfiguration.verifyEditGroupOrTable();

		objFormConfiguration
				.enterNewGroupName(objFormConfiguration_data.strGroupName);

		objFormConfiguration.clickOnGroupDoneButton();

		objFormConfiguration
				.clickOnAddButton(objFormConfiguration_data.strGroupName);

		objFormConfiguration
				.clickOnFieldSet(objFormConfiguration_data.strGroupName);

		objFormConfiguration.verifyEditFieldSetWindow();

		objFormConfiguration
				.enterAttributesLabelName(objFormConfiguration_data.strAttributeName);

		objFormConfiguration.clickOnEditFieldDoneButton();

		objFormConfiguration
				.clickOnInsertElement(objFormConfiguration_data.strAttributeName);

		objFormConfiguration.verifyEditQuestionWindow();

		objFormConfiguration
				.selectQuestionType(objFormConfiguration_data.strDateQuestion);

		objFormConfiguration
				.enterLabelName(objFormConfiguration_data.strLabelName);

		objFormConfiguration.clickOnAddToSummary();

		objFormConfiguration.clickOnDoneButton();

		objFormConfiguration.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.switchToDefaultFrame().selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(2000);
		
		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
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
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInDateField(objBlankFormData.strCurrentDate);
					Thread.sleep(5000);	
		objBlankForm.clickOnSave();
		
		Thread.sleep(10000);
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strCurrentDate + "";
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strCurrentDate);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
						strMsg).clickAcknowledgeAllForms()
				.selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
	
		 
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strCurrentDate);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
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
	'Description : Verify that 'Text' question can be added to the V3 form.  
	'Precondition:
	'Date	 	 : 15-Dec-2014
	'Author		 : Deepa
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that 'Text' question can be added to the V3 form. ")
	public void testHappyDay151174() throws Exception {

		gstrTCID = "151174";
		gstrTO = "Verify that 'Text' question can be added to the V3 form. ";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
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

		Thread.sleep(10000);
		
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
							.selectQuestionType(objFormConfiguration_data.strText)
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
					.enterAnswerInTextField(objBlankFormData.strTextAnswer)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName1,
						 			objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strTextAnswer + "";
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
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
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
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
	'Description : Verify that 'Checkbox' question can be added to the V3 form. 
	'Precondition:
	'Date	 	 : 16-Dec-2014
	'Author		 : Deepa
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that 'Checkbox' question can be added to the V3 form. ")
	public void testHappyDay151178() throws Exception {

		gstrTCID = "151178";
		gstrTO = "Verify that 'Checkbox' question can be added to the V3 form. ";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId).selectFirstRole()
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();
		
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

		Thread.sleep(10000);
		
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
					        .clickOnAddToSummary()
					        .addChoices(objFormConfiguration_data.strChoice)
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

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
						 .selUserToFillOutForm(objUserdata.strNewUserName)
						 .clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

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
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInChkBox(objFormConfiguration_data.strChoice)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objFormConfiguration_data.strChoice + "";
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
						strMsg).clickAcknowledgeAllForms()
				.selectFrame();

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
	
	/*************************************************************************************
    'Description   : Verify that 'Text Area' question can be added to the V3 form. 
    'Precondition  :
    'Date          : 16-Dec-2014
    'Author        : Pallavi
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name       
    **************************************************************************************/
    @Test(description = "Verify that 'Text Area' question can be added to the V3 form.")
    public void testHappyDay151175() throws Exception {

       gstrTCID = "151175";
       gstrTO = "Verify that 'Text Area' question can be added to the V3 form.";

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

       Thread.sleep(80000);
       
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
       					   .selectQuestionType(objFormConfiguration_data.strTextArea)
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

       objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
                    objUserdata.strNewPassword);

       objRegionDefault1.selectFrame();

       objNavigationToSubmenus1.navigateToActivateForm();

       objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
                    .selUserToFillOutForm(objUserdata.strNewUserName)
                    .clickOnActivateForm();

       objLogin1.clickLogOut();

       objLogin1.loginAsNewUser(objUserdata.strNewUserName,
                    objUserdata.strNewPassword);

       objRegionDefault1.selectFrame();

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
                           .enterAnswerInTextAreaField(objBlankFormData.strTextAreaAnswer)
                           .clickOnSave();
       Thread.sleep(5000);
       objBlankForm.clickOnComplete();
       
       objDispatchForm.selUserToReceiveCompletedForm(
                                                objUserdata.strNewUserName1)
                              .clickOnDispatchForm();

       driver1.switchTo().window(mainWindowHandle1);

       objRegionDefault1.selectFrame();

       objLogin1.clickLogOut();

       objLogin1.loginToApplication(objUserdata.strNewUserName1,
                    objUserdata.strNewPassword);

//       String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//                    + objFormConfiguration_data.strLabelName + ": "
//                    + objBlankFormData.strTextAreaAnswer + "";
   
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAreaAnswer);
		
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
                    objFormConfiguration_data.strLabelName,
                    objBlankFormData.strTextAreaAnswer);

       String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
                    objUserdata.strFullName, objLogindata.strRegionName,
                    objFormConfiguration_data.strLabelName,
                    objBlankFormData.strTextAreaAnswer);

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
	'Description : Verify that 'Single Select' question can be added to the V3 form. 
	'Precondition:
	'Date	 	 : 16-Dec-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that 'Single Select' question can be added to the V3 form.")
	public void testHappyDay151181() throws Exception {

		gstrTCID = "151181";
		gstrTO = "Verify that 'Single Select' question can be added to the V3 form.";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton().verifyUserListPageIsDisplayed();
		
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
		
		Thread.sleep(10000);

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage();

		objFormConfiguration.clickOnInsert();

		objFormConfiguration.clickOnGroupLink();

		objFormConfiguration.verifyEditGroupOrTable();

		objFormConfiguration
				.enterNewGroupName(objFormConfiguration_data.strGroupName);

		objFormConfiguration.clickOnGroupDoneButton();

		objFormConfiguration
				.clickOnAddButton(objFormConfiguration_data.strGroupName);

		objFormConfiguration
				.clickOnFieldSet(objFormConfiguration_data.strGroupName);

		objFormConfiguration.verifyEditFieldSetWindow();

		objFormConfiguration
				.enterAttributesLabelName(objFormConfiguration_data.strAttributeName);

		objFormConfiguration.clickOnEditFieldDoneButton();

		objFormConfiguration
				.clickOnInsertElement(objFormConfiguration_data.strAttributeName);

		objFormConfiguration.verifyEditQuestionWindow();

		objFormConfiguration
				.selectQuestionType(objFormConfiguration_data.strSingleSelect);

		objFormConfiguration
				.enterLabelName(objFormConfiguration_data.strLabelName);

		objFormConfiguration.clickOnAddToSummary();

		objFormConfiguration.addChoices(objFormConfiguration_data.strChoice);
	
		objFormConfiguration.addNthChoice(objFormConfiguration_data.strSecChoice,
										  objFormConfiguration_data.strChoice1);

		objFormConfiguration.clickOnDoneButton();

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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
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

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objFormConfiguration_data.strChoice + "";
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
						strMsg)
				.clickReviewForm();
		
		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> b = driver1.getWindowHandles();
		Iterator<String> ite2 = b.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		
		objBlankForm.verFormTitleInReviewForm(objFormConfiguration_data.strFormName)
		.verifyEnteredValueIsDisplayed(objFormConfiguration_data.strLabelName,objFormConfiguration_data.strChoice);
		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);
			objRegionDefault1.selectFrame()
			.verWebNotificationframe()
			.clickAcknowledgeAllForms()
			.selectFrame();
			
//		objLogin1.clickLogOut();
			
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

	 /*************************************************************************************
		'Description :  Verify that 'Multi-Select' question can be added to the V3 form. 
		'Precondition:
		'Date	 	 : 17-Dec-2014
		'Author		 : Deepa
		'---------------------------------------------------------------
		'Modified Date			                        	Modified By
		'Date					                            Name
		**************************************************************************************/
		@Test(description = "Verify that 'Multi-Select' question can be added to the V3 form. ")
		public void testHappyDay151182() throws Exception {

			gstrTCID = "151182";
			gstrTO = " Verify that 'Multi-Select' question can be added to the V3 form. ";

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
					.selectFormUserMayActivateFormsOption().clickSaveButton()
					.verifyUserListPageIsDisplayed();
			
			objUsersList
			.clickCreateNewUserButton()
			.enterAllUserDetails(objUserdata.strNewUserName2,
					objUserdata.strNewPassword, objUserdata.strFullName2,
					objUserdata.strFirstName, objUserdata.strMiddleName,
					objUserdata.strLastName, objUserdata.strOrganization,
					objUserdata.strPhone, objUserdata.strPrimaryMailId,
					objUserdata.strPrimaryMailId,
					objUserdata.strPrimaryMailId).selectFirstRole()
			.clickSaveButton().verifyUserListPageIsDisplayed();
			
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
			
			Thread.sleep(10000);

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
						        .selectQuestionType(objFormConfiguration_data.strMultiSelect)
						        .enterLabelName(objFormConfiguration_data.strLabelName)
						        .clickOnAddToSummary()
						        .addChoices(objFormConfiguration_data.strChoice)
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

			objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
							 .selUserToFillOutForm(objUserdata.strNewUserName)
							 .clickOnActivateForm();

			objLogin1.clickLogOut();

			objLogin1.loginAsNewUser(objUserdata.strNewUserName,
					objUserdata.strNewPassword);

			objRegionDefault1.selectFrame();

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
						.verFieldSetName(objFormConfiguration_data.strAttributeName)
						.enterAnswerInMultiSelectBox(objFormConfiguration_data.strChoice)
						.clickOnSave();
			
			objBlankForm.clickOnComplete();
			
			objDispatchForm.selUserToReceiveCompletedForm(
					objUserdata.strNewUserName2).clickOnDispatchForm();

			driver1.switchTo().window(mainWindowHandle1);

			objRegionDefault1.selectFrame();

			objLogin1.clickLogOut();

			objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
					objUserdata.strNewPassword);

//			String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//					+ objFormConfiguration_data.strLabelName + ": "
//					+ objFormConfiguration_data.strChoice + "";
			
			String strMsg = objRegionDefault1
					.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
							objLogindata.strRegionName,
							objFormConfiguration_data.strLabelName,
							objFormConfiguration_data.strChoice);
			
			objRegionDefault1
					.selectFrame()
					.verWebNotificationframe()
					.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
							strMsg).clickAcknowledgeAllForms()
					.selectFrame();

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
		
	 /*************************************************************************************
       'Description : Verify that 'Radio button' question can be added to the V3 form. 
       'Precondition:
       'Date        : 16-Dec-2014
       'Author      : Pallavi
       '---------------------------------------------------------------
       'Modified Date                                               Modified By
       'Date                                                         Name
	    **************************************************************************************/
	   @Test(description = "Verify that 'Radio button' question can be added to the V3 form.")
	   public void testHappyDay151180() throws Exception {
	
	        gstrTCID = "151180";
	        gstrTO = "Verify that 'Radio button' question can be added to the V3 form.";
	
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
	
	        objLogin.loginToApplication(objLogindata.strAdminUser,
	                     objLogindata.strAdminUserPwd);
	
	        objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);
	
	        objRegionDefault.selectFrame();
	
	        objNavigationToSubmenus.navigateToUsers();
	        
		    objUsersList.clickCreateNewUserButton()
                        .enterAllUserDetails(objUserdata.strNewUserName,
                                     objUserdata.strNewPassword, objUserdata.strFullName,
                                     objUserdata.strFirstName, objUserdata.strMiddleName,
                                     objUserdata.strLastName, objUserdata.strOrganization,
                                     objUserdata.strPhone, objUserdata.strPrimaryMailId,
                                     objUserdata.strPrimaryMailId,
                                     objUserdata.strPrimaryMailId)
                        .selectFirstRole()
                        .clickSaveButton().verifyUserListPageIsDisplayed();
	 
	        objUsersList.clickCreateNewUserButton()
                        .enterAllUserDetails(objUserdata.strNewUserName1,
                                     objUserdata.strNewPassword, objUserdata.strFullName1,
                                     objUserdata.strFirstName, objUserdata.strMiddleName,
                                     objUserdata.strLastName, objUserdata.strOrganization,
                                     objUserdata.strPhone, objUserdata.strPrimaryMailId,
                                     objUserdata.strPrimaryMailId,
                                     objUserdata.strPrimaryMailId).selectFirstRole()
                        .clickAdvancedOptionAndExpand()
                        .selectFormUserMayActivateFormsOption()
                        .clickSaveButton().verifyUserListPageIsDisplayed();
	          
	        objUsersList.clickCreateNewUserButton()
			            .enterAllUserDetails(objUserdata.strNewUserName2,
			                       objUserdata.strNewPassword, objUserdata.strFullName2,
			                       objUserdata.strFirstName, objUserdata.strMiddleName,
			                       objUserdata.strLastName, objUserdata.strOrganization,
			                       objUserdata.strPhone, objUserdata.strPrimaryMailId,
			                       objUserdata.strPrimaryMailId,
			                       objUserdata.strPrimaryMailId)
			            .clickSaveButton().verifyUserListPageIsDisplayed();
	
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
	        
	        Thread.sleep(10000);
	
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
                                .selectQuestionType(objFormConfiguration_data.strRadio)
                                .enterLabelName(objFormConfiguration_data.strLabelName)
                                .clickOnAddToSummary()
                                .addChoices(objFormConfiguration_data.strChoice)
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
	
	        objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
	                         .selUserToFillOutForm(objUserdata.strNewUserName)
	                         .clickOnActivateForm();
	
	        objLogin1.clickLogOut();
	
	        objLogin1.loginAsNewUser(objUserdata.strNewUserName,
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
            Thread.sleep(5000);
	          
            objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
	                              .verGroupName(objFormConfiguration_data.strGroupName)
	                              .verFieldSetName(objFormConfiguration_data.strAttributeName)
	                              .enterAnswerInRadioBtn(objFormConfiguration_data.strChoice)
	                              .clickOnSave();
	          
	        objBlankForm.clickOnComplete();
	          
	        objDispatchForm.selUserToReceiveCompletedForm(
	                                       objUserdata.strNewUserName2)
	                       .clickOnDispatchForm();
	
	        driver1.switchTo().window(mainWindowHandle1);
	
            objRegionDefault1.selectFrame();
	
	        objLogin1.clickLogOut();
	
	        objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
	                       objUserdata.strNewPassword);
	
//	        String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//	                       + objFormConfiguration_data.strLabelName + ": "
//	                       + objFormConfiguration_data.strChoice + "";
	          
			String strMsg = objRegionDefault1
					.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
							objLogindata.strRegionName,
							objFormConfiguration_data.strLabelName,
							objFormConfiguration_data.strChoice);
			
	        Thread.sleep(5000);
	          
	        objRegionDefault1
	                       .selectFrame()
	                       .verWebNotificationframe()
	                       .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
	                                     strMsg)
	                       .clickReviewForm();
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
	          
	        objBlankForm.verFormTitleInReviewForm(objFormConfiguration_data.strFormName)
	                              .verifyEnteredValueIsDisplayed(objFormConfiguration_data.strLabelName,
							objFormConfiguration_data.strChoice);
	        driver1.close();
	          
	        driver1.switchTo().window(mainWindowHandle2);
	          
	        objRegionDefault1.selectFrame()
	                         .verWebNotificationframe()
	                         .clickAcknowledgeAllForms()
	                         .selectFrame();
	          
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
	   
		/*************************************************************************************
       'Description : Verify that 'Table' question can be added to the V3 form. 
       'Precondition:
       'Date        : 18-Dec-2014
       'Author      : Pallavi
       '---------------------------------------------------------------
       'Modified Date                                               Modified By
       'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Verify that 'Table' question can be added to the V3 form.")
   public void testHappyDay151183() throws Exception {

        gstrTCID = "151183";
        gstrTO = "Verify that 'Table' question can be added to the V3 form.";

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
        MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
                     this.driver1);

        objLogin.loginToApplication(objLogindata.strAdminUser,
                     objLogindata.strAdminUserPwd);

        objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

        objRegionDefault.selectFrame();

        objNavigationToSubmenus.navigateToUsers();
        
	    objUsersList.clickCreateNewUserButton()
                    .enterAllUserDetails(objUserdata.strNewUserName,
                                 objUserdata.strNewPassword, objUserdata.strFullName,
                                 objUserdata.strFirstName, objUserdata.strMiddleName,
                                 objUserdata.strLastName, objUserdata.strOrganization,
                                 objUserdata.strPhone, objUserdata.strPrimaryMailId,
                                 objUserdata.strPrimaryMailId,
                                 objUserdata.strPrimaryMailId)
                    .selectFirstRole()
                    .clickSaveButton().verifyUserListPageIsDisplayed();
 
        objUsersList.clickCreateNewUserButton()
                    .enterAllUserDetails(objUserdata.strNewUserName1,
                                 objUserdata.strNewPassword, objUserdata.strFullName1,
                                 objUserdata.strFirstName, objUserdata.strMiddleName,
                                 objUserdata.strLastName, objUserdata.strOrganization,
                                 objUserdata.strPhone, objUserdata.strPrimaryMailId,
                                 objUserdata.strPrimaryMailId,
                                 objUserdata.strPrimaryMailId).selectFirstRole()
                    .clickAdvancedOptionAndExpand()
                    .selectFormUserMayActivateFormsOption()
                    .clickSaveButton().verifyUserListPageIsDisplayed();
          
        objUsersList.clickCreateNewUserButton()
		            .enterAllUserDetails(objUserdata.strNewUserName2,
		                       objUserdata.strNewPassword, objUserdata.strFullName2,
		                       objUserdata.strFirstName, objUserdata.strMiddleName,
		                       objUserdata.strLastName, objUserdata.strOrganization,
		                       objUserdata.strPhone, objUserdata.strPrimaryMailId,
		                       objUserdata.strPrimaryMailId,
		                       objUserdata.strPrimaryMailId)
		            .clickSaveButton().verifyUserListPageIsDisplayed();

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
        Thread.sleep(10000);

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
                            .enterThirdRowLabel(objFormConfiguration_data.strRow3,
                            					objFormConfiguration_data.strRow2)
                            .addFirstTableColumn(objFormConfiguration_data.strColumnName1,
                            					objFormConfiguration_data.strText)
                            .addNthTableColumn(objFormConfiguration_data.strColumnName2,
                            				  objFormConfiguration_data.strTextArea)
       					    .clickOnEditFieldDoneButton();
                          //  .clickOnSaveButton();

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

        objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
                         .selUserToFillOutForm(objUserdata.strNewUserName)
                         .clickOnActivateForm();

        objLogin1.clickLogOut();

        objLogin1.loginAsNewUser(objUserdata.strNewUserName,
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
          
        objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
        			.verRowDetails(objFormConfiguration_data.strRow1,
        						   objFormConfiguration_data.strText)
        			.verRowDetails(objFormConfiguration_data.strRow2,
        						   objFormConfiguration_data.strText)
        			.verRowDetails(objFormConfiguration_data.strRow3,
        						   objFormConfiguration_data.strText)
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
                    .clickOnSave();
          
        objBlankForm.clickOnComplete();
          
        objDispatchForm.selUserToReceiveCompletedForm(
                                       objUserdata.strNewUserName2)
                       .clickOnDispatchForm();

        driver1.switchTo().window(mainWindowHandle1);

        objRegionDefault1.selectFrame();

        objLogin1.clickLogOut();

        objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
                       objUserdata.strNewPassword);

//        String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//                       + objFormConfiguration_data.strRow1 + ":" + objFormConfiguration_data.strColumnName1 + ": "
//                       + objBlankFormData.strTextAnswer + "| " + objFormConfiguration_data.strRow1 + ":"
//                       + objFormConfiguration_data.strColumnName2 + ": " + objBlankFormData.strTextAreaAnswer + "| "
//                       + objFormConfiguration_data.strRow2 + ":" + objFormConfiguration_data.strColumnName1 + ": "
//                       + objBlankFormData.strTextAnswer1 + "| " + objFormConfiguration_data.strRow2 + ":"
//                       + objFormConfiguration_data.strColumnName2 + ": " + objBlankFormData.strTextAreaAnswer1 + "| "
//                       + objFormConfiguration_data.strRow3 + ":" + objFormConfiguration_data.strColumnName1 + ": "
//                       + objBlankFormData.strTextAnswer2 + "| " + objFormConfiguration_data.strRow3 + ":"
//                       + objFormConfiguration_data.strColumnName2 + ": " + objBlankFormData.strTextAreaAnswer2;
          
		String strMsg = objRegionDefault1.getWebNotificationForTable(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strColumnName1,
				objBlankFormData.strTextAnswer,
				objFormConfiguration_data.strColumnName2,
				objBlankFormData.strTextAreaAnswer,
				objFormConfiguration_data.strRow2,
				objBlankFormData.strTextAnswer1,
				objBlankFormData.strTextAreaAnswer1,
				objFormConfiguration_data.strRow3,
				objBlankFormData.strTextAnswer2,
				objBlankFormData.strTextAreaAnswer2);
		
        Thread.sleep(5000);

        objRegionDefault1
                       .selectFrame()
                       .verWebNotificationframe()
                       .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                                     strMsg)
                       .clickReviewForm();
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
          
		objBlankForm
				.verFormTitleInReviewForm(objFormConfiguration_data.strFormName)
				.ver2ColTableInReviewWind(objFormConfiguration_data.str1sTRow,
						objBlankFormData.strTextAnswer,
						objBlankFormData.strTextAreaAnswer)
				.ver2ColTableInReviewWind(objFormConfiguration_data.str2ndRow,
						objBlankFormData.strTextAnswer1,
						objBlankFormData.strTextAreaAnswer1)
				.ver2ColTableInReviewWind(objFormConfiguration_data.str3rdRow,
						objBlankFormData.strTextAnswer2,
						objBlankFormData.strTextAreaAnswer2);

        driver1.close();
          
        driver1.switchTo().window(mainWindowHandle2);
          
        objRegionDefault1.selectFrame()
                         .verWebNotificationframe()
                         .clickAcknowledgeAllForms()
                         .selectFrame();
          
        objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
                                                  objUserdata.strPrimaryPwsd);

        String strMsgBody = objMailVerificationFunctions.getFormMailBodyForTable(objUserdata.strFullName,
	        													objLogindata.strRegionName, objFormConfiguration_data.strRow1,
	        													objFormConfiguration_data.strRow2,
	        													objFormConfiguration_data.strRow3,
	        													objFormConfiguration_data.strColumnName1,
	        													objFormConfiguration_data.strColumnName2,
	        													objBlankFormData.strTextAnswer,
	        													objBlankFormData.strTextAnswer1,
	        													objBlankFormData.strTextAnswer2,
	        													objBlankFormData.strTextAreaAnswer,
	        													objBlankFormData.strTextAreaAnswer1,
	        													objBlankFormData.strTextAreaAnswer2);

        String strMsgBody1 = objMailVerificationFunctions.getFormPagerBodyForTable(objUserdata.strFullName,
																objLogindata.strRegionName,
																objFormConfiguration_data.strRow1,
																objFormConfiguration_data.strRow2,
																objFormConfiguration_data.strRow3,
																objFormConfiguration_data.strColumnName1,
																objFormConfiguration_data.strColumnName2,
																objBlankFormData.strTextAnswer,
																objBlankFormData.strTextAnswer1,
																objBlankFormData.strTextAnswer2,
																objBlankFormData.strTextAreaAnswer,
																objBlankFormData.strTextAreaAnswer1,
																objBlankFormData.strTextAreaAnswer2);

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
	 * 'Description : 	 	Verify that new 'Instructions' can be added to the V3 form  
	 * 'Precondition : None
	 * 'Date : 21-Oct-2014 
	 * 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description = "Verify that new 'Instructions' can be added to the V3 form ")
	public void testHappyDay152084() throws Exception {

		gstrTCID = "152084";
		gstrTO = " 	Verify that new 'Instructions' can be added to the V3 form ";

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
						objUserdata.strPrimaryMailId)
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
						objUserdata.strPrimaryMailId).selectFirstRole()
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
		Thread.sleep(10000);
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();
		String strPopUp1 = "";
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			strPopUp1 =popupHandle;
			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);
				driver.manage().window().maximize();
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

							.clickOnInsert()
						    .clickOnInstructionLink()
						    .selectInstructionFrame()
						    .enterInstructions(objFormConfiguration_data.strInstructionData);
		driver.switchTo().window(strPopUp1);
		objFormConfiguration.clickOnDoneButton()
		
							.clickOnAddButton(objFormConfiguration_data.strGroupName)
						    .clickOnInstructionInGroup(objFormConfiguration_data.strGroupName)
						    .selectInstructionFrame()
						    .enterInstructions(objFormConfiguration_data.strInstructionData1);
		driver.switchTo().window(strPopUp1);
		objFormConfiguration.clickOnDoneButton()
		
							.clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()   
						    .selectQuestionType(objFormConfiguration_data.strInstructions)
						    .selectInstructionFrame()
						    .enterInstructions(objFormConfiguration_data.strInstructionData2);
		driver.switchTo().window(strPopUp1);
		objFormConfiguration.clickOnDoneButton()
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
					.verifyEnteredInstructionIsRetained(objFormConfiguration_data.strInstructionData)
					.verifyEnteredInstructionIsRetained(objFormConfiguration_data.strInstructionData1)
					.verifyEnteredInstructionIsRetained(objFormConfiguration_data.strInstructionData2)
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
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
	
	/*********************************************************************************
    'Description : Verify that 'Table' can be added inside a group to a V3 form. 
    'Date        : 18-Dec-2014
    'Author      : Pallavi
    '---------------------------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    ******************************************************************************/
	@Test(description = "Verify that 'Table' can be added inside a group to a V3 form.")
	public void testHappyDay152221() throws Exception {

		gstrTCID = "152221";
		gstrTO = "Verify that 'Table' can be added inside a group to a V3 form.";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton().verifyUserListPageIsDisplayed();
       
		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).clickSaveButton()
						.verifyUserListPageIsDisplayed();

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
		Thread.sleep(8000);
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage();
		objFormConfiguration.clickOnInsert()
							.clickOnGroupLink()
							.verifyEditGroupOrTable()
							.enterNewGroupName(objFormConfiguration_data.strGroupName)
							.clickOnGroupDoneButton()
							.clickOnAddButton(objFormConfiguration_data.strGroupName)
							.clickOnTableLinkUnderGroup(
									objFormConfiguration_data.strGroupName)
							.verifyEditFieldSetWindow()
							.enterFirstRowLabel(objFormConfiguration_data.strRow1)
							.enterSecondRowLabel(objFormConfiguration_data.strRow2)
							.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
									objFormConfiguration_data.strText)
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
		
		System.out.println("-------precondition ends and test execution starts-------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
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
			    .enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow1,
			        						   objBlankFormData.strTextAreaAnswer)
			    .enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow2,
			        						   objBlankFormData.strTextAreaAnswer1)
				.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName1 + ": "
//				+ objBlankFormData.strTextAnswer ;

		String strMsg = objRegionDefault1.getWebNotificationForTable(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strColumnName1,
				objBlankFormData.strTextAnswer,
				objFormConfiguration_data.strColumnName2,
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
	            .clickAcknowledgeAllForms()
	            .switchToDefaultFrame()
	            .selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBodyForTable(objUserdata.strFullName,
				objLogindata.strRegionName, objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strRow2,
				objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2,
				objBlankFormData.strTextAnswer,
				objBlankFormData.strTextAnswer1,
				objBlankFormData.strTextAreaAnswer,
				objBlankFormData.strTextAreaAnswer1);

		String strMsgBody1 = objMailVerificationFunctions
				.getFormPagerBodyForTable(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strColumnName2,
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

	/****************************************************************************************************
	'Description : Verify that 'Required' check box for check box questionnaire is not available when only 
					one choice is added to it.
	'Date	 	 : 10-Feb-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that 'Required' check box for check box questionnaire is not available when only one choice is added to it.")
	public void testHappyDay153311() throws Exception {

		gstrTCID = "153311";
		gstrTO = "Verify that 'Required' check box for check box questionnaire is not available when only one choice is added to it.";

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
	
	/********************************************************************************************
	'Description : Verify that user can add 'Boolean'questionnaire to a form while configuring it
	'Date	 	 : 15-Dec-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------
	'Modified Date			                        	          Modified By
	'Date					                                      Name
	*********************************************************************************************/
	@Test(description = "Verify that user can add 'Boolean'questionnaire to a form while configuring it.")
	public void testHappyDay155254() throws Exception {

		gstrTCID = "155254";
		gstrTO = "Verify that user can add 'Boolean'questionnaire to a form while configuring it.";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
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
						    .selectQuestionType(objFormConfiguration_data.strBoolean)
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
		
		System.out.println("----------Precondition ends and test execution starts---------");

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
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInFieldForBoolean(objFormConfiguration_data.strLabelName)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedFormNew(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName1,
						 	objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strBooleanAnswer + "";
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strBooleanAnswer);
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
						strMsg).clickAcknowledgeAllForms()
				.selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
	
		 
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strBooleanAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strBooleanAnswer);

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

	
	/********************************************************************************************
	'Description : Verify that user can set boolean as 'No' while completing the form 
	'Date	 	 : 02-Mar-2014
	'Author		 : Anil
	'--------------------------------------------------------------------------------------------
	'Modified Date			                        	          Modified By
	'Date					                                      Name
	*********************************************************************************************/
	@Test(description = "Verify that user can set boolean as 'No' while completing the form ")
	public void testHappyDay155256() throws Exception {

		gstrTCID = "155256";
		gstrTO = "Verify that user can set boolean as 'No' while completing the form ";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
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
						    .selectQuestionType(objFormConfiguration_data.strBoolean)
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
		
		System.out.println("----------Precondition ends and test execution starts---------");

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

		/*String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}*/
		String mainWindowHandle1 = driver1.getWindowHandle();
		objBlankForm.switchToNewWin();
		
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.deselectAnswerInFieldForBoolean(objFormConfiguration_data.strLabelName)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedFormNew(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName1,
						 	objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strBooleanNoAnswer + "";
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strBooleanNoAnswer);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
						strMsg).clickAcknowledgeAllForms()
				.selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
	
		 
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strBooleanNoAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strBooleanNoAnswer);

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
	
	/**********************************************************************************
	'Description : Verify that user can set boolean as 'Yes' while completing the form
	'Date	 	 : 02-March-2014
	'Author		 : Anitha
	'----------------------------------------------------------------------------------
	'Modified Date			                        	          Modified By
	'Date					                                      Name
	***********************************************************************************/
	@Test(description = "Verify that user can set boolean as 'Yes' while completing the form")
	public void testHappyDay155255() throws Exception {

		gstrTCID = "155255";
		gstrTO = "Verify that user can set boolean as 'Yes' while completing the form";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton().verifyUserListPageIsDisplayed();

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
						    .selectQuestionType(objFormConfiguration_data.strBoolean)
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
		
		System.out.println("----------Precondition ends and test execution starts---------");

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
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInFieldForBoolean(objFormConfiguration_data.strLabelName)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedFormNew(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName1,
						 	objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strBooleanAnswer + "";
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strBooleanAnswer);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
						strMsg).clickAcknowledgeAllForms()
				.selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
	
		 
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strBooleanAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strBooleanAnswer);

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
}
		
