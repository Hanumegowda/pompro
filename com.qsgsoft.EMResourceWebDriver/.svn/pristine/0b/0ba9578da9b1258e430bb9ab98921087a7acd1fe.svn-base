package requirementGroup.CreatingAndManagingForms;

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
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayMovingQuestionsAndChangingQuestionType extends TestNG_UI_EXTENSIONS   {

	public HappyDayMovingQuestionsAndChangingQuestionType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	 * 'Description : Verify that field set can be moved from one group to another group on 'Template Designer' page
	 * 'Precondition:
	 * 'Date        : 8-July-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description ="Verify that field set can be moved from one group to another group on 'Template Designer' page")
	public void testHappyDay163970() throws Exception {

		gstrTCID ="163970";
		gstrTO ="Verify that field set can be moved from one group to another group on 'Template Designer' page";

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
		// ie

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName)
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
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(50000);

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration

				// Group1
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
				.clickOnDoneButton()

				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName1)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName1)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnDoneButton()
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName)
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName1)
				// Group2

				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName1)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName1)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName1)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName2)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName2)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName3)
				.clickOnDoneButton()
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strAttributeName2)
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

		// login as admin

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(50000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		Thread.sleep(50000);
		objFormConfiguration1
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName)
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName1)
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strAttributeName2)
				.dragAndDropFieldSetToOtherGroupe(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strAttributeName2)
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		System.out.println("started");
		objFormConfiguration1.clickOnPublishButton();
		System.out.println("ended");
		Thread.sleep(8000);

		objFormConfiguration1.clickOnPreviewButton();

		String mainWindowHandle2 = driver1.getWindowHandle();

		Thread.sleep(8000);

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.verifyFieldSetUnderGroupInPreviewPageAndFilloutPage(
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strAttributeName);

		driver1.close();

		Thread.sleep(5000);
		driver1.switchTo().window(mainWindowHandle2);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

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

		String mainWindowHandle3 = driver1.getWindowHandle();

		Thread.sleep(10000);
		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName)
				.verGroupName(objFormConfiguration_data.strGroupName1);

		objFormConfiguration1
				.verifyFieldSetUnderGroupInPreviewPageAndFilloutPage(
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strAttributeName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// login as user1 2nd time

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle4 = driver1.getWindowHandle();

		Thread.sleep(5000);

		Set<String> a4 = driver1.getWindowHandles();
		Iterator<String> ite4 = a4.iterator();

		while (ite4.hasNext()) {
			String popupHandle = ite4.next().toString();

			if (!popupHandle.contains(mainWindowHandle4)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objFormConfiguration1.dragAndDropFieldSetToOtherGroupe(
				objFormConfiguration_data.strGroupName1,
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strGroupName,
				objFormConfiguration_data.strAttributeName1)
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		System.out.println("started");
		objFormConfiguration1.clickOnPublishButton();
		System.out.println("ended");
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle4);

		objRegionDefault1.selectFrame();

		Thread.sleep(1000);

		objNavigationToSubmenus1.navigateToActivateForm();
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2 2nd time
		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle5 = driver1.getWindowHandle();
		Thread.sleep(5000);
		Set<String> a5 = driver1.getWindowHandles();
		Iterator<String> ite5 = a5.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();

			if (!popupHandle.contains(mainWindowHandle5)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName1);

		objFormConfiguration1
				.verifyFieldSetUnderGroupInPreviewPageAndFilloutPage(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName);
		objBlankForm.enterAnswerInField(
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strNumericAnswer3);
		objBlankForm.enterAnswerInField(
				objFormConfiguration_data.strLabelName2,
				objBlankFormData.strNumericAnswer4);
		objBlankForm.enterAnswerInField(
				objFormConfiguration_data.strLabelName3,
				objBlankFormData.strNumericAnswer3);

		objBlankForm.clickOnSave();
		objBlankForm.clickOnComplete();

		objDispatchForm1
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName2);
		objDispatchForm1.clickOnDispatchForm();

		driver1.close();

		driver1.switchTo().window(mainWindowHandle5);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
	 * 'Description : Verify that table can be moved from one group to another group on 'Template Designer' page
	 * 'Precondition:
	 * 'Date        : 21-July-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description ="Verify that table can be moved from one group to another group on 'Template Designer' page")
	public void testHappyDay163971() throws Exception {

		gstrTCID ="163971";
		gstrTO ="Verify that table can be moved from one group to another group on 'Template Designer' page";

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
		// ie

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName)
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
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(50000);

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration

				// Group1
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnTableLinkUnderGroup(
						objFormConfiguration_data.strGroupName)

				// table1
				.enterFirstRowLabel(objFormConfiguration_data.strRow1)
				.enterThirdRowLabel(objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strRow2)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strNumeric)
				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strCheckBox)
				.clickOnEditFieldDoneButton()
				// table2
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnTableLinkUnderGroup(
						objFormConfiguration_data.strGroupName)
				.enterFirstRowLabel(objFormConfiguration_data.strRow4)
				.enterThirdRowLabel(objFormConfiguration_data.strRow6,
						objFormConfiguration_data.strRow5)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName3,
						objFormConfiguration_data.strNumeric)
				.addNthTableColumn(objFormConfiguration_data.strColumnName4,
						objFormConfiguration_data.strCheckBox)
				.clickOnEditFieldDoneButton()
				// Group2
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName1)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName1)
				.clickOnTableLinkUnderGroup(
						objFormConfiguration_data.strGroupName1)

				// table3
				.enterFirstRowLabel(objFormConfiguration_data.strRow7)
				.enterThirdRowLabel(objFormConfiguration_data.strRow9,
						objFormConfiguration_data.strRow8)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strNumeric)
				.addNthTableColumn(objFormConfiguration_data.strColumnName6,
						objFormConfiguration_data.strCheckBox)
				.clickOnEditFieldDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);
	
		//objRegionDefault.switchToDefaultFrame();
		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		// login as admin

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(60000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1

				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strColumnName2)
				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName3,
						objFormConfiguration_data.strColumnName4)
				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strColumnName6)

				.dragAndDropTableToOtherGroupe(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strColumnName5)

				.dragAndDropTableToOtherGroupe(
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strColumnName6,
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName3)

				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strColumnName6)

				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strColumnName2);

		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		System.out.println("started");
		objFormConfiguration1.clickOnPublishButton();
		System.out.println("ended");
		Thread.sleep(8000);

		objFormConfiguration1.clickOnPreviewButton();

		String mainWindowHandle2 = driver1.getWindowHandle();

		Thread.sleep(8000);

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1.verifyTableUnderGroup(
				objFormConfiguration_data.strGroupName,
				objFormConfiguration_data.strColumnName5,
				objFormConfiguration_data.strColumnName6)

		.verifyTableUnderGroup(objFormConfiguration_data.strGroupName1,
				objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2);
		driver1.close();

		Thread.sleep(5000);
		driver1.switchTo().window(mainWindowHandle2);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

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

		String mainWindowHandle3 = driver1.getWindowHandle();

		Thread.sleep(10000);
		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName)
				.verGroupName(objFormConfiguration_data.strGroupName1);

		objFormConfiguration1.verifyTableUnderGroup(
				objFormConfiguration_data.strGroupName,
				objFormConfiguration_data.strColumnName5,
				objFormConfiguration_data.strColumnName6)

		.verifyTableUnderGroup(objFormConfiguration_data.strGroupName1,
				objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2);
		driver1.close();

		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// login as user1 2nd time

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle4 = driver1.getWindowHandle();

		Thread.sleep(5000);

		Set<String> a4 = driver1.getWindowHandles();
		Iterator<String> ite4 = a4.iterator();

		while (ite4.hasNext()) {
			String popupHandle = ite4.next().toString();

			if (!popupHandle.contains(mainWindowHandle4)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strColumnName6)

				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strColumnName2)

				.dragAndDropTableToOtherGroupe(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strColumnName1)

				.dragAndDropTableToOtherGroupe(
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName3)

				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strColumnName2)
				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName3,
						objFormConfiguration_data.strColumnName4)
				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strColumnName6);

		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		System.out.println("started");
		objFormConfiguration1.clickOnPublishButton();
		System.out.println("ended");
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle4);

		objRegionDefault1.selectFrame();

		Thread.sleep(1000);

		objNavigationToSubmenus1.navigateToActivateForm();
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2 2nd time
		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle5 = driver1.getWindowHandle();
		Thread.sleep(5000);
		Set<String> a5 = driver1.getWindowHandles();
		Iterator<String> ite5 = a5.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();

			if (!popupHandle.contains(mainWindowHandle5)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName1);

		objFormConfiguration1
				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strColumnName2)
				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strColumnName3,
						objFormConfiguration_data.strColumnName4)
				.verifyTableUnderGroup(objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strColumnName6);


		driver1.close();

		driver1.switchTo().window(mainWindowHandle5);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
	 * 'Description : Verify that reordered (moving questionnaire from one field set to other) questionnaires are updated while filling the form
	 * 'Precondition:
	 * 'Date        : 22-July-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description ="Verify that reordered (moving questionnaire from one field set to other) questionnaires are updated while filling the form")
	public void testHappyDay163973() throws Exception {

		gstrTCID ="163973";
		gstrTO =" Verify that reordered (moving questionnaire from one field set to other) questionnaires are updated while filling the form";

		
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
			// ie

			Login objLogin1 = new Login(this.driver1);
			BlankForm objBlankForm = new BlankForm(this.driver1);
			RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
			SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
			ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
			DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);
			FormConfiguration objFormConfiguration1 = new FormConfiguration(
					this.driver1);
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
					.selectFormUserMayActivateFormsOption()
					.selectFormUserMayActivateAndModifyFormsOption()
					.clickSaveButton();

			objUsersList
					.clickCreateNewUserButton()
					.enterUserDetails(objUserdata.strNewUserName1,
							objUserdata.strNewPassword, objUserdata.strFullName)
					.selectFirstRole().clickSaveButton();

			objUsersList
					.clickCreateNewUserButton()
					.enterUserDetails(objUserdata.strNewUserName2,
							objUserdata.strNewPassword, objUserdata.strFullName)
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
					.clickOnNextButton()
					.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
					.clickOnNextButton().clickOnNextButton()
					.selectActivateFormChkBox(objUserdata.strNewUserName)
					.clickOnSaveOfFormSecuritySetting();

			System.out.println(objFormConfiguration_data.strFormName);

			objFormConfiguration
					.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

			String mainWindowHandle = driver.getWindowHandle();

			Thread.sleep(50000);

			Set<String> a = driver.getWindowHandles();
			Iterator<String> ite = a.iterator();

			while (ite.hasNext()) {
				String popupHandle = ite.next().toString();

				if (!popupHandle.contains(mainWindowHandle)) {
					driver.switchTo().window(popupHandle);

				}
			}

		objFormConfiguration

				// Group1
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
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnDoneButton()

				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName1)
				.clickOnEditFieldDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName1)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strTextArea)
				.enterLabelName(objFormConfiguration_data.strLabelName3)
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName1)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName4)
				.clickOnDoneButton()

				// Group2

				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName1)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName1)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName1)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName2)
				.clickOnEditFieldDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName2)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName5)
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName2)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName6)
				.clickOnDoneButton()

				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName)

				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName1)

				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName1,
						objFormConfiguration_data.strAttributeName2)

				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName1)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName2)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName3)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName4)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName2,
						objFormConfiguration_data.strLabelName5)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName2,
						objFormConfiguration_data.strLabelName6)

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

			// login as admin

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(50000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName1)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName2)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName3)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName4)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName2,
						objFormConfiguration_data.strLabelName5)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName2,
						objFormConfiguration_data.strLabelName6)

				.dragAndDropQsnryToOtherFieledsetGroupe(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strAttributeName2,
						objFormConfiguration_data.strLabelName6)

				.dragAndDropQsnryToOtherFieledsetGroupe(
						objFormConfiguration_data.strAttributeName2,
						objFormConfiguration_data.strLabelName5,
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName2)

				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName2,
						objFormConfiguration_data.strLabelName1)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName5);

		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		System.out.println("started");
		objFormConfiguration1.clickOnPublishButton();
		System.out.println("ended");
		Thread.sleep(8000);

		objFormConfiguration1.clickOnPreviewButton();

		String mainWindowHandle2 = driver1.getWindowHandle();

		Thread.sleep(8000);

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1.verQuestionTypesInPreviewPage(
				objFormConfiguration_data.strAttributeName2,
				objFormConfiguration_data.strLabelName1)
				.verQuestionTypesInPreviewPage(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName5);

		driver1.close();

		Thread.sleep(5000);
		driver1.switchTo().window(mainWindowHandle2);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

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

		String mainWindowHandle3 = driver1.getWindowHandle();

		Thread.sleep(10000);
		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName)
				.verGroupName(objFormConfiguration_data.strGroupName1);

		objFormConfiguration1.verQuestionTypesInPreviewPage(
				objFormConfiguration_data.strAttributeName2,
				objFormConfiguration_data.strLabelName1)
				.verQuestionTypesInPreviewPage(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName5);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// login as user1 2nd time

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle4 = driver1.getWindowHandle();

		Thread.sleep(5000);

		Set<String> a4 = driver1.getWindowHandles();
		Iterator<String> ite4 = a4.iterator();

		while (ite4.hasNext()) {
			String popupHandle = ite4.next().toString();

			if (!popupHandle.contains(mainWindowHandle4)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1.verifyQsnryUnderFiledSet(
				objFormConfiguration_data.strAttributeName2,
				objFormConfiguration_data.strLabelName1)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName5);

		objFormConfiguration1
				.dragAndDropQsnryToOtherFieledsetGroupe(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName2,
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName3)

				.dragAndDropQsnryToOtherFieledsetGroupe(
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName3,
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName5)

				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName2)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName3);

		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		System.out.println("started");
		objFormConfiguration1.clickOnPublishButton();
		System.out.println("ended");
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle4);

		objRegionDefault1.selectFrame();

		Thread.sleep(1000);

		objNavigationToSubmenus1.navigateToActivateForm();
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2 2nd time
		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle5 = driver1.getWindowHandle();
		Thread.sleep(5000);
		Set<String> a5 = driver1.getWindowHandles();
		Iterator<String> ite5 = a5.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();

			if (!popupHandle.contains(mainWindowHandle5)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName1);

		objFormConfiguration1
				.verQuestionTypesInPreviewPage(
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName2)
				.verQuestionTypesInPreviewPage(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName3)

				.verQuestionTypesInPreviewPage(
						objFormConfiguration_data.strAttributeName2,
						objFormConfiguration_data.strLabelName1)
				.verQuestionTypesInPreviewPage(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName5);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle5);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}

