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

public class HappyDayClonningFormTemplate extends TestNG_UI_EXTENSIONS {

	public HappyDayClonningFormTemplate() throws Exception {
		super();
	}
	/*************************************************************************************
	 * 'Description : Verify that only admin and user with appropriate right can copy form from one region to another.
	 * 'Precondition:
	 * 'Date        : 27-July-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description ="Verify that only admin and user with appropriate right can copy form from one region to another.")
	public void testHappyDay164044() throws Exception {

		gstrTCID ="164044";
		gstrTO ="Verify that only admin and user with appropriate right can copy form from one region to another.";

		Login_data objTest_data = new Login_data();
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		String[] strRegionValue = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton()
				.verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
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

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnCopy(objFormConfiguration_data.strFormName)
				.verCreateNewFormPage()
				.selectRegionToCopyForm(objTest_data.strRegionName1)
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strCloneDiscription)
				.clickOnNextButton().verValidationMsgAfterCopiedTheForm();
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton().verifyUserListPageIsDisplayed();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objNavigationToSubmenus1.clickOnConfigureForm();
		objFormConfiguration1
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strActiveStatusNo)
				.clickOnEditFormLink(objFormConfiguration_data.strCloneFormName)
				.selectActiveFormCheckBox()
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.clickOnNextButton()
				.clickOnNextButton()
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strActiveStatusYes);

		objLogin1.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnCopy(objFormConfiguration_data.strCloneFormName)
				.verCreateNewFormPage()
				.selectRegionToCopyForm(objTest_data.strRegionName)
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strCloneFormName1,
						objFormConfiguration_data.strCloneDiscription)
				.clickOnNextButton().verValidationMsgAfterCopiedTheForm();
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		System.out.println(objFormConfiguration_data.strCloneFormName);
		System.out.println(objFormConfiguration_data.strCloneFormName1);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();
		objFormConfiguration1
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName1,
						objFormConfiguration_data.strActiveStatusNo)
				.clickOnEditFormLink(
						objFormConfiguration_data.strCloneFormName1)
				.selectActiveFormCheckBox()
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.clickOnNextButton()
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName1,
						objFormConfiguration_data.strActiveStatusYes);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
	 * 'Description : Verify that admin can copy the form template to the same region
	 * 'Date        : 28-July-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date:                                        Modified By : 
	 **************************************************************************************/
	@Test(description ="Verify that admin can copy the form template to the same region")
	public void testHappyDay164149() throws Exception {

		gstrTCID ="164149";
		gstrTO ="Verify that admin can copy the form template to the same region";

		Login_data objTest_data = new Login_data();
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
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
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton().verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
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

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnCopy(objFormConfiguration_data.strFormName)
				.verCreateNewFormPage()
				.selectRegionToCopyForm(objTest_data.strRegionName)
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strCloneDiscription)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();
		
		System.out.println(objFormConfiguration_data.strCloneFormName);
		

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();
		objFormConfiguration1.verActiveColumnStatus(
				objFormConfiguration_data.strCloneFormName,
				objFormConfiguration_data.strActiveStatusYes);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description : Verify that user can copy the form template to the same region 
	 * 'Date : 28-July-2015  
	 * 'Author : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date: Modified By :
	 **************************************************************************************/
	@Test(description = "Verify that user can copy the form template to the same region")
	public void testHappyDay164237() throws Exception {

		gstrTCID = "164237";
		gstrTO = "Verify that user can copy the form template to the same region";

		Login_data objTest_data = new Login_data();
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
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
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
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
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnCopy(objFormConfiguration_data.strFormName)
				.verCreateNewFormPage()
				.selectRegionToCopyForm(objTest_data.strRegionName)
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strCloneFormName1,
						objFormConfiguration_data.strCloneDiscription)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton();

		System.out.println(objFormConfiguration_data.strCloneFormName);
		System.out.println(objFormConfiguration_data.strCloneFormName1);

		objNavigationToSubmenus1.clickOnConfigureForm();
		objFormConfiguration1.verActiveColumnStatus(
				objFormConfiguration_data.strCloneFormName1,
				objFormConfiguration_data.strActiveStatusYes);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
	 * 'Description : Verify that user can edit the form template which is copied to other region 
	 * 'Date        : 30-July-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description ="Verify that user can edit the form template which is copied to other region")
	public void testHappyDay164150() throws Exception {

		gstrTCID ="164150";
		gstrTO ="Verify that user can edit the form template which is copied to other region";

		Login_data objTest_data = new Login_data();
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		String[] strRegionValue = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton()
				.verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
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

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnCopy(objFormConfiguration_data.strFormName)
				.verCreateNewFormPage()
				.selectRegionToCopyForm(objTest_data.strRegionName1)
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strCloneDiscription)
				.clickOnNextButton().verValidationMsgAfterCopiedTheForm();
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objNavigationToSubmenus1.clickOnConfigureForm();
		objFormConfiguration1
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strActiveStatusNo)
				.clickOnEditFormLink(objFormConfiguration_data.strCloneFormName)
				.selectActiveFormCheckBox()
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.clickOnNextButton()
				.clickOnNextButton()
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strActiveStatusYes);

		System.out.println(objFormConfiguration_data.strCloneFormName);

		objLogin1.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strCloneFormName)
				.verCreateNewFormPage()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strEditeFormName,
						objFormConfiguration_data.strEditedDiscriptiveName)
				.selectActiveFormCheckBox()
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.clickOnNextButton()
				.clickOnNextButton()
				.verActiveColumnStatus(
						objFormConfiguration_data.strEditeFormName,
						objFormConfiguration_data.strActiveStatusYes)
				//.verFormTittle(objFormConfiguration_data.strEditeFormName)
				.verFormDescription(
						objFormConfiguration_data.strEditedDiscriptiveName);

		System.out.println(objFormConfiguration_data.strEditeFormName);

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strEditeFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle1);

			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName1)

				// edit Qsnry

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnDoneButton()
				.clickOnSaveButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.enterLabelName(objFormConfiguration_data.strLabelName3)
				.selectQuestionType(objFormConfiguration_data.strDateTime)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration1
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName1)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName2)
				.verifyQsnryUnderFiledSet(
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName3);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description : Verify that admin / user can copy form template containing locked 'Questionnaire'.
	 * 'Date        : 31-July-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description ="Verify that admin / user can copy form template containing locked 'Questionnaire'.")
	public void testHappyDay164415() throws Exception {

		gstrTCID ="164415";
		gstrTO ="Verify that admin / user can copy form template containing locked 'Questionnaire'.";

		Login_data objTest_data = new Login_data();
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		String[] strRegionValue = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strFlowridaReg2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strFlowridaReg2);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton()
				.verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strFlowridaReg2);

		objRegionDefault1.selectFrame();
	
		objNavigationToSubmenus1.clickOnConfigureForm();
		        
		objFormConfiguration1.clkOnCopyOfFormTempContainingLockedQsrny()
				.verCreateNewFormPage()
				.selectRegionToCopyForm(objTest_data.strRegionName1)
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strCloneDiscription)
				.clickOnNextButton().verValidationMsgAfterCopiedTheForm();
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objNavigationToSubmenus1.clickOnConfigureForm();
		objFormConfiguration1
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strActiveStatusNo)
				.clickOnEditFormLink(objFormConfiguration_data.strCloneFormName)
				.selectActiveFormCheckBox()
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.clickOnNextButton()
				.clickOnNextButton()
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strActiveStatusYes);

		System.out.println(objFormConfiguration_data.strCloneFormName);

		objLogin1.clickLogOut();

		// Log in as user 1
		
				objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

				objRegionDefault1.selectFrame();
				
				objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strFlowridaReg2);
				
				objRegionDefault1.switchToDefaultFrame().selectFrame();
				
				objNavigationToSubmenus1.clickOnConfigureForm();

				objFormConfiguration1
				        .clkOnCopyOfFormTempContainingLockedQsrny()
						.verCreateNewFormPage()
						.selectRegionToCopyForm(objTest_data.strRegionName1)
						.entireTittleName_DescriptionName(
								objFormConfiguration_data.strCloneFormName1,
								objFormConfiguration_data.strCloneDiscription)
						.clickOnNextButton().verValidationMsgAfterCopiedTheForm();
				objSelectRegionpage1
						.selectRegionAndNavigate(objLogindata.strRegionName1);

				System.out.println(objFormConfiguration_data.strCloneFormName);
				System.out.println(objFormConfiguration_data.strCloneFormName1);

				objRegionDefault1.switchToDefaultFrame().selectFrame();

				objNavigationToSubmenus1.clickOnConfigureForm();
				objFormConfiguration1
						.verActiveColumnStatus(
								objFormConfiguration_data.strCloneFormName1,
								objFormConfiguration_data.strActiveStatusNo)
						.clickOnEditFormLink(
								objFormConfiguration_data.strCloneFormName1)
						.selectActiveFormCheckBox()
						.clickOnNextButton()
						.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
						.clickOnNextButton()
						.clickOnNextButton()
						.verActiveColumnStatus(
								objFormConfiguration_data.strCloneFormName1,
								objFormConfiguration_data.strActiveStatusYes);
				
		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strCloneFormName1);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle1);

			}
		}

		objFormConfiguration1
				.verTemplateDesignPage();
				Thread.sleep(50000);
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
	 * 'Description : Verify that user with appropriate right can copy form from one region to another in which he has configure forms right.
	 * 'Precondition:
	 * 'Date        : 27-Nov-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description ="Verify that user with appropriate right can copy form from one region to another in which he has configure forms right.")
	public void testHappyDay164045() throws Exception {

		gstrTCID ="164045";
		gstrTO ="Verify that user with appropriate right can copy form from one region to another in which he has configure forms right.";

		Login_data objTest_data = new Login_data();
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		String[] strRegionValue = new String[4];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[1]);

		strRegionValue[2] = objRegions_page
				.getRegionValue(objTest_data.strRegionName2);

		strRegionValue[3] = objRegions_page
				.getRegionValue(objTest_data.strRegionName8);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2])
				.selectRegion(strRegionValue[3]).clickSaveButton()
				.verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
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
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();
		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnCopy(objFormConfiguration_data.strFormName)
				.verCreateNewFormPage()
				.verRegIsNotDispdUnderRegDropDownWhileCloningTheForm(
						objTest_data.strRegionName2)
				.verRegIsNotDispdUnderRegDropDownWhileCloningTheForm(
						objTest_data.strRegionName8)
				.verRegISDispdUnderRegDropDownWhileCloningTheForm(
						objTest_data.strRegionName)
				.verRegISDispdUnderRegDropDownWhileCloningTheForm(
						objTest_data.strRegionName1)
				.selectRegionToCopyForm(objTest_data.strRegionName1)
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strCloneDiscription)
				.clickOnNextButton().verValidationMsgAfterCopiedTheForm();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();
		objFormConfiguration1
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strActiveStatusNo)
				.clickOnEditFormLink(objFormConfiguration_data.strCloneFormName)
				.selectActiveFormCheckBox()
				.clickOnNextButton()
				.clickOnNextButton()
				.clickOnNextButton()
				.verActiveColumnStatus(
						objFormConfiguration_data.strCloneFormName,
						objFormConfiguration_data.strActiveStatusYes);

		objFormConfiguration1
				.clickOnCopy(objFormConfiguration_data.strCloneFormName)
				.verCreateNewFormPage()
				.verRegIsNotDispdUnderRegDropDownWhileCloningTheForm(
						objTest_data.strRegionName2)
				.verRegIsNotDispdUnderRegDropDownWhileCloningTheForm(
						objTest_data.strRegionName8)
				.verRegISDispdUnderRegDropDownWhileCloningTheForm(
						objTest_data.strRegionName)
				.verRegISDispdUnderRegDropDownWhileCloningTheForm(
						objTest_data.strRegionName1)
				.selectRegionToCopyForm(objTest_data.strRegionName)
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strCloneFormName1,
						objFormConfiguration_data.strCloneDiscription)
				.clickOnNextButton().verValidationMsgAfterCopiedTheForm();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
