package requirementGroup.CreatingAndManagingForms;

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
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayFormNotification extends TestNG_UI_EXTENSIONS{

	public HappyDayFormNotification() throws Exception {
		super();
	}
	
	/*******************************************************************************************
	 * 'Description : Verify that region name is displayed in ‘Read recipient’ web notification. 
	 * 'Precondition:
	 * 'Date        : 27-Jan-2016 
	 * 'Author      : Sowmya
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description ="Verify that region name is displayed in ‘Read recipient’ web notification. ")
	public void testHappyDay175847() throws Exception {

		gstrTCID ="175847";
		gstrTO ="Verify that region name is displayed in ‘Read recipient’ web notification. ";

		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		
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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton()
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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selReadReceipt().clickOnNextButton()
				.deSelectAllUsersCheckBox()

				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()

				.selectActivateFormChkBox(objUserdata.strNewUserName)
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
		Thread.sleep(5000);

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

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nRegion: " + objLogindata.strRegionName + "\nSummary: | "
				+ objFormConfiguration_data.strLabelName1 + ": "
				+ objFormConfiguration_data.strChoice1 + "| "
				+ objFormConfiguration_data.strLabelName2 + ": "
				+ objFormConfiguration_data.strChoice3 + "| "
				+ objFormConfiguration_data.strLabelName3 + ": "
				+ objFormConfiguration_data.strChoice4 + "| "
				+ objFormConfiguration_data.strLabelName4 + ": "
				+ objFormConfiguration_data.strChoice6;

		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame().switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		String strMsg2 = "Acknowledged by " + objUserdata.strFullName
				+ "\nSummary: | "
				+ objFormConfiguration_data.strLabelName1 + ": "
				+ objFormConfiguration_data.strChoice1 + "| "
				+ objFormConfiguration_data.strLabelName2 + ": "
				+ objFormConfiguration_data.strChoice3 + "| "
				+ objFormConfiguration_data.strLabelName3 + ": "
				+ objFormConfiguration_data.strChoice4 + "| "
				+ objFormConfiguration_data.strLabelName4 + ": "
				+ objFormConfiguration_data.strChoice6;

		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg2)
				.clickAcknowledgeButton().selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
		
	/****************************************************************************************************
	'Description : Verify that completed form web notification received by the user with multi regions access displays
	               the region name in which the form is activated even if user is logged into region other than the form 
	               activated region.
	'Date	 	 : 27-Jan-2016
	'Author		 : Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that completed form web notification received by the user with multi regions access "
			+ "displays the region name in which the form is activated even if user is logged into region other than the form activated region.")
	public void testHappyDay175848() throws Exception {

		gstrTCID ="175848";
		gstrTO = "Verify that completed form web notification received by the user with multi regions access displays "
				+ "the region name in which the form is activated even if user is logged into region other than the form activated region.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		BlankForm objBlankForm1 = new BlankForm(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		String strRegionValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName1);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton()
.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName2,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName2)
				.selectRegion(strRegionValue[0])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName2);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(80000);
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
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm1.clickOnComplete();

		objDispatchForm1.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1 + "\n"
				+ "Region: " + objLogindata.strRegionName + "\nSummary: | "
				+ objFormConfiguration_data.strLabelName + ": "
				+ objBlankFormData.strNumericAnswer + "";
		*/
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);

		System.out.println(strMsg);
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms();

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		Thread.sleep(5000);
		objLogin1.clickLogOut();

		gstrResult = "PASS";	
	}
	
	/*****************************************************************************
	 * 'Description : Verify that when a form is copied from region ‘RG1’ to ‘RG2’ , the region in which the
	 *                 form is activated is displayed in the web notification received. 
	 * 'Date        :28-Jan-2016
	 * 'Author      :Sangappa K
	 *****************************************************************************/

	@Test(description ="Verify that when a form is copied from region ‘RG1’ to ‘RG2’ , the region in which"
			          + "the form is activated is displayed in the web notification received.")
	public void testHappyDay175846() throws Exception {
		
		gstrTCID ="175846";
		gstrTO ="Verify that when a form is copied from region ‘RG1’ to ‘RG2’ , the region in which the"
				+ " form is activated is displayed in the web notification received.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
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
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);
		

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
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
				.clickOnNextButton().clickOnNextButton()
				.clickOnSaveOfFormSecuritySetting();

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
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();
		objFormConfiguration.clickOnCopy(objFormConfiguration_data.strFormName)
		
		.selectRegionToCopyForm(objLogindata.strRegionName1)
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strCloneDiscription)
				.clickOnNextButton().verValidationMsgAfterCopiedTheForm();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();
		
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
			    .clickSaveButton().verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName1);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objNavigationToSubmenus.clickOnConfigureForm();
		
		objFormConfiguration
		                   .clickOnEditFormLink(objFormConfiguration_data.strCloneFormName)
		                       .selectOptionInFormActivationDropDown(
				objFormConfiguration_data.strFormActivatnUIOTFO)
		                       .selCompletedFormDelivery(
				objFormConfiguration_data.strComptdFormDelvry)
		                      .selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
		                      .selectActiveFormCheckBox()
		                      .clickOnNextButton()
		.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
		.clickOnNextButton().clickOnNextButton()
		.clickOnSecurityLinkOfForm(objFormConfiguration_data.strCloneFormName)
		.verFormSecurityPage(objFormConfiguration_data.strCloneFormName)
		.selectActivateFormChkBox(objUserdata.strNewUserName2)
		.clickOnSaveOfFormSecuritySetting();
		
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strCloneFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(80000);
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
				.verFormTitle(objFormConfiguration_data.strCloneFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strSinglelineTextAnswer).clickOnSave();

		objBlankForm1.clickOnComplete();

		objDispatchForm1.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1 + "\n"
				+ "Region: " + objLogindata.strRegionName1 + "\nSummary: | "
				+ objFormConfiguration_data.strLabelName + ": "
				+ objBlankFormData.strSinglelineTextAnswer + "";
		*/
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName1,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strSinglelineTextAnswer);

		System.out.println(strMsg);
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strCloneFormName, strMsg)
				.clickAcknowledgeAllForms();

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		Thread.sleep(5000);
		objLogin1.clickLogOut();
		gstrResult = "PASS";	

	}
	

	
}