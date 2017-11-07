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
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseMovingQuestionsAndChangingQuestionType extends TestNG_UI_EXTENSIONS {

	public EdgeCaseMovingQuestionsAndChangingQuestionType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	 * 'Description : Verify that system admin or user with appropriate right cannot move questionnaire from a field set to an empty field set.
	 * 'Precondition:
	 * 'Date        : 9-July-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description ="Verify that system admin or user with appropriate right cannot move questionnaire from a field set to an empty field set.")
	public void testEdgeCase164006() throws Exception {

		gstrTCID ="164006";
		gstrTO ="Verify that system admin or user with appropriate right cannot move questionnaire from a field set to an empty field set.";

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
		// ie

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
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
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

				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName)
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName1)
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

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

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

		objFormConfiguration1
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName)
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName1)
				.dragQsnryToOtherFieldSetWithinSameGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strAttributeName1)
				.verifyQsnryNotDisplayed(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName1);
		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		System.out.println("started");
		objFormConfiguration1.clickOnPublishButton();
		System.out.println("ended");
		Thread.sleep(5000);
		driver1.close();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle4 = driver1.getWindowHandle();

		Thread.sleep(50000);

		Set<String> a4 = driver1.getWindowHandles();
		Iterator<String> ite4 = a4.iterator();

		while (ite4.hasNext()) {
			String popupHandle = ite4.next().toString();

			if (!popupHandle.contains(mainWindowHandle4)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objFormConfiguration1
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName)
				.verifyFieldSetUnderGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName1)
				.dragQsnryToOtherFieldSetWithinSameGroup(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName,
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strAttributeName1)
				.verifyQsnryNotDisplayed(
						objFormConfiguration_data.strGroupName,
						objFormConfiguration_data.strAttributeName1,
						objFormConfiguration_data.strLabelName1);
		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		System.out.println("started");
		objFormConfiguration1.clickOnPublishButton();
		System.out.println("ended");
		Thread.sleep(8000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle4);

		objRegionDefault1.selectFrame();

		Thread.sleep(1000);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
