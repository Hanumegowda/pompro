package requirementGroup.CreatingAndManagingUsers;

import java.util.Iterator;
import java.util.Set;

import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewNewFeatureFor3Point15 extends TestNG_UI_EXTENSIONS{

	public NewNewFeatureFor3Point15() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***************************************************************************************
	'Description : Verify that a user can be provided a role with right to activate forms.
	'Date	 	 : 29-June-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	****************************************************************************************/
	@Test(description = "Verify that a user can be provided a role with right to activate forms.")
	public void testHappyDay21520() throws Exception {
		
		gstrTCID = "21520";
		gstrTO = "Verify that a user can be provided a role with right to activate forms.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRoles_data = new Roles_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		FormConfiguration objFormConfiguration1=new FormConfiguration(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRoles_data.strRoleName);
		
		objUsersList.selectFormUserMayActivateAndModifyFormsOption();
		
		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickSaveButton();

		objLogin.clickLogOut();
		
		System.out.println("-----------Precondition ends and test execution starts--------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.deSelectRoleCheckBox(strRoleValue).clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToFormMenu();

		objFormConfiguration1.verifyConfigureFormLinkNotDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/**************************************************************************************
	'Description : Verify that user created selecting the right 'Form - User may create and
	               modify forms' can configure forms.
	'Date	 	 : 30-June-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***************************************************************************************/
	@Test(description = "Verify that user created selecting the right 'Form - User may create and"
			+ " modify forms' can configure forms.")
	public void testHappyDay91752() throws Exception {

		gstrTCID = "91752";
		gstrTO = "Verify that user created selecting the right 'Form - User may create and modify"
				+ " forms' can configure forms.";

		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);

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
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.clickOnNextButton()
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		
		objLogin.clickLogOut();
		
		System.out.println("-----------------Execution started---------------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToFormMenu();

		objFormConfiguration1.verifyConfigureFormLinkIsDisplayed();
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
				.verFormConfigurePage()		
				.verifyEditFormLink(objFormConfiguration_data.strFormName)
				.VerifyQuestionnaireFormLink(
						objFormConfiguration_data.strFormName)						
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName2,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.clickOnNextButton()
				.verifyEditFormLink(objFormConfiguration_data.strFormName2)
				.VerifyQuestionnaireFormLink(
						objFormConfiguration_data.strFormName2)
						
				.clickOnEditFormLink(objFormConfiguration_data.strFormName2)			
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strEditeFormName,
						objFormConfiguration_data.strEditedDiscriptiveName)
                .clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.clickOnNextButton()
				/*.verFormTittle(objFormConfiguration_data.strEditeFormName)
				.verFormDescription(
						objFormConfiguration_data.strEditedDiscriptiveName)*/
				.clickOnAcknowledgeFormInIEBrowser(
						objFormConfiguration_data.strEditeFormName);
		
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();
		
		objFormConfiguration1
				.clickOnAcknowledgeFormInIEBrowser(objFormConfiguration_data.strEditeFormName);

		Thread.sleep(5000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite1 = a2.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.verifyLabelNameInTemplateDesignPage(
						objFormConfiguration_data.strLabelName)
				.clickOnEditQuestionnaireNew(objFormConfiguration_data.strLabelName)
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
	
	/**************************************************************************************
	'Description : Edit a user and select the right "Form - User may create and modify forms"
	               and verify that user can configure forms.
	'Date	 	 : 30-June-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***************************************************************************************/
	@Test(description = "Edit a user and select the right Form - User may create and modify forms"
			+ " and verify that user can configure forms.")
	public void testHappyDay91754() throws Exception {

		gstrTCID = "91754";
		gstrTO = "Edit a user and select the right Form - User may create and modify forms and "
				+ "verify that user can configure forms.";

		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
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
				.clickOnNextButton()
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		
		objLogin.clickLogOut();
		
		System.out.println("-----------------Execution started---------------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToFormMenu();

		objFormConfiguration1.verifyConfigureFormLinkNotDisplayed();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToFormMenu();

		objFormConfiguration1.verifyConfigureFormLinkIsDisplayed();
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
				.verFormConfigurePage()		
				.verifyEditFormLink(objFormConfiguration_data.strFormName)
				.VerifyQuestionnaireFormLink(
						objFormConfiguration_data.strFormName)						
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName2,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.clickOnNextButton()
				.verifyEditFormLink(objFormConfiguration_data.strFormName2)
				.VerifyQuestionnaireFormLink(
						objFormConfiguration_data.strFormName2)
						
				.clickOnEditFormLink(objFormConfiguration_data.strFormName2)			
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strEditeFormName,
						objFormConfiguration_data.strEditedDiscriptiveName)
                .clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.clickOnNextButton()
				/*.verFormTittle(objFormConfiguration_data.strEditeFormName)
				.verFormDescription(
						objFormConfiguration_data.strEditedDiscriptiveName)*/
				.clickOnAcknowledgeFormInIEBrowser(
						objFormConfiguration_data.strEditeFormName);
		
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();
		
		objFormConfiguration1
				.clickOnAcknowledgeFormInIEBrowser(objFormConfiguration_data.strEditeFormName);

		Thread.sleep(5000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite1 = a2.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.verifyLabelNameInTemplateDesignPage(
						objFormConfiguration_data.strLabelName)
				.clickOnEditQuestionnaireNew(objFormConfiguration_data.strLabelName)
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

		objFormConfiguration1
				.clickOnAcknowledgeFormInIEBrowser(objFormConfiguration_data.strEditeFormName);

		Thread.sleep(5000);

		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite2 = a3.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
			}
		}
		
		objFormConfiguration1
				.verTemplateDesignPage()
				.verifyLabelNameInTemplateDesignPage(
						objFormConfiguration_data.strLabelName1);

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
