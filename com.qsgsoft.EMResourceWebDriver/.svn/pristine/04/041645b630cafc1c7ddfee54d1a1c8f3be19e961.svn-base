package requirementGroup.Forms;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import lib.dataObject.BlankFormData;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.AutoIT;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.EventManagement;
import lib.page.FormConfiguration;
import lib.page.FormList;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseReceiveBlankForm extends TestNG_UI_EXTENSIONS {

	public EdgeCaseReceiveBlankForm() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/****************************************************************************************************
	'Description : Send a blank form to a resource RS, where a user 'u1' has both 'Associated with' and 
	                Update right on the resource and verify that user 'U1' receives only one form.
	'Date	 	 : 25-Feb-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------------
	'Modified Date			                        	                             Modified By
	'Date					                                                         Name
	*****************************************************************************************************/
	@Test(description = "Send a blank form to a resource RS, where a user 'u1' has both 'Associated with' "
			+ "and Update right on the resource and verify that user 'U1' receives only one form.")
	public void testEdgaCase152317() throws Exception {

		gstrTCID = "152317";
		gstrTO = "Send a blank form to a resource RS, where a user 'u1' has both 'Associated with' and "
				+ "Update right on the resource and verify that user 'U1' receives only one form.";

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

		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

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
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						"", "","", "","", objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
						.selectViewResourceCheckBox(objResource_data.strResourceName)
						.selectAssociateWithOfResource(objResource_data.strResourceName)
						.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						"", "","", "","", objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
						.selectViewResourceCheckBox(objResource_data.strResourceName)
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
				.selectFormActivation(objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selectCompletedFormDelivery(objFormConfiguration_data.strUserToIndividualResources)
				.clickOnNextButton()
				.deselectAllResources()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
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
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		Thread.sleep(3000);
		objDispatchForm.selectResourcesInDispatch(
				objResource_data.strResourceName).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1 + " for "
				+ objResource_data.strResourceName + "\nSummary: | "
				+ objFormConfiguration_data.strLabelName + ": "
				+ objBlankFormData.strNumericAnswer + "| "
				+ objFormConfiguration_data.strLabelName1 + ": "
				+ objBlankFormData.strTextAnswer;*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWith2Quest(
						objUserdata.strFullName1,
						objResource_data.strResourceName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

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

		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strLabelValue,
				objFormConfiguration_data.strLabelName1,
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

		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresentNew(strSubject);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/***************************************************************************
	'Description : Send a blank form to a single user (user A) and verify that:
					1. The form pops up for User A.
					2. User A receives the blank form in pending forms list.
					3. User A can submit the form. 
	'Date	 	 : 26-Feb-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------
	'Modified Date			                        	  Modified By
	'Date					                              Name
	****************************************************************************/
	@Test(description = "Send a blank form to a single user (user A) and verify that:"+
						"1. The form pops up for User A."+
						"2. User A receives the blank form in pending forms list."+
						"3. User A can submit the form. ")
	public void testEdgeCase152622() throws Exception {

		gstrTCID = "152622";
		gstrTO = "Send a blank form to a single user (user A) and verify that:"+
				"1. The form pops up for User A."+
				"2. User A receives the blank form in pending forms list."+
				"3. User A can submit the form. ";

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
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		FormList objFormList1 = new FormList(this.driver1);
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
						"", "","", "","", objUserdata.strPrimaryMailId,
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
		
		System.out.println("-------precondition ends and test execution starts-------");
		
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
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		
		Thread.sleep(2000);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToFormList();
		
		objFormList1.verFormListedUnderPendingForms(objFormConfiguration_data.strFormName);
        
		//once again fill the form
        objActivateForms1.clickOnFillOut(objFormConfiguration_data.strFormName);
		
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
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
		.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer + "| "
				+ objFormConfiguration_data.strLabelName1 + ": "
				+ objBlankFormData.strTextAnswer;*/

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
				.clickAcknowledgeAllForms()
				.switchToDefaultFrame()
				.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	
	/***************************************************************************
	'Description : Send a mandatory form to be filled by a user and verify that only ‘Fill Out’ option is present in the Pending forms screen for that particular form 
	'Date	 	 : 30-Mar-2015
	'Author		 : Anil
	'---------------------------------------------------------------------------
	'Modified Date			                        	  Modified By
	'Date					                              Name
	****************************************************************************/
	@Test(description = "Send a mandatory form to be filled by a user and verify that only ‘Fill Out’ option is present in the Pending forms screen for that particular form ")
	public void testEdgeCase152628() throws Exception {

		gstrTCID = "152628";
		gstrTO = "Send a mandatory form to be filled by a user and verify that only ‘Fill Out’ option is present in the Pending forms screen for that particular form ";


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
						.selectFirstRole()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
						.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2)
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
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.clickOnMandatoryCheckbox()
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
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
		
		Thread.sleep(3000);

		Thread.sleep(5000);
		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

				driver1.close();

				driver1.switchTo().window(mainWindowHandle1);

				objRegionDefault1.selectFrame();
				
			}
		}
		
		objNavigationToSubmenus1.navigateToFormList();

		objActivateForms1.verifyFillFormOption(objFormConfiguration_data.strFormName);
		
		objActivateForms1.verifyDeleteOptionIsNotDisplayed(objFormConfiguration_data.strFormName);
		
		objActivateForms1.clickOnFillOut(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
				
			}
		}
		
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer)
					.clickOnComplete();
		
		Thread.sleep(5000);
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	'Description :  Send a blank form to a single resource RS, where a single user (user A) has 
	                'Update status' right on the resource and verify that:
						1. The form pops up for User A.
						2. User A receives the blank form in pending forms list.
						3. User A can submit the form.
	'Date	 	 : 30-Mar-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------------------
	'Modified Date			                        	                     Modified By
	'Date					                                                 Name
	*******************************************************************************************/
	@Test(description = "Send a blank form to a single resource RS, where a single user (user A) has"
			+ " 'Update status' right on the resource and verify that:"+
							"1. The form pops up for User A."+
							"2. User A receives the blank form in pending forms list."+
							"3. User A can submit the form. ")
	public void testEdgeCase152623() throws Exception {

		gstrTCID = "152623";
		gstrTO = "Send a blank form to a single resource RS, where a single user (user A) has"
				+ " 'Update status' right on the resource and verify that:"+
				"1. The form pops up for User A."+
				"2. User A receives the blank form in pending forms list."+
				"3. User A can submit the form. ";

		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		String strStatusTypeValues [] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue    [] = new String[1];
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormList objFormList1 = new FormList(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);

		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		
		objLogin.loginToApplication(objLogindata.strAdminUser,objLogindata.strAdminUserPwd);

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
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
						.selectFirstRole()
						.selectViewResourceCheckBox(objResource_data.strResourceName)
						.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
						.selectViewResourceCheckBox(objResource_data.strResourceName)
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
				.selectFormActivation(objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selectCompletedFormDelivery(objFormConfiguration_data.strUserToIndividualResources)
				.clickOnNextButton()
				.deselectAllResources()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
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
						    .clickOnDoneButton();					    

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
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		
		Thread.sleep(2000);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToFormList();
		
		objFormList1.verifyFormIsListedUnderMyInProgressForm(objFormConfiguration_data.strFormName);
        
		//once again fill the form
        objActivateForms1.clickOnFillOut(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle2 = driver1.getWindowHandle();
		
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();
		
		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();
			
			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);				
			}
		}
		
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		Thread.sleep(3000);
		objDispatchForm.selectResourcesInDispatch(
				objResource_data.strResourceName).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1 + " for "
				+ objResource_data.strResourceName + "\nSummary: | "
				+ objFormConfiguration_data.strLabelName + ": "
				+ objBlankFormData.strNumericAnswer;*/
		
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
				.clickAcknowledgeAllForms()
				.switchToDefaultFrame()
				.selectFrame();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Send a blank form to a user (User A) and a resource (RS), where another user (User B) has 'Update status'
     				 right on the resource RS and verify that:
						1. The form pops up for User A.
						2. User A receives the blank forms in pending forms list.
						3. User A can submit the form.
						4. The form pops up for User B.
						5. User B receives the blank forms in pending forms list.
						6. User B can submit the form. 
    'Precondition  : None
    'Date          : 30-Mar-2015
    'Author        : Pallavi
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name       
    **************************************************************************************/
    @Test(description = "Send a blank form to a user (User A) and a resource (RS), where another user (User B) has 'Update status' right on the resource RS and verify that:"
				    		+ "1. The form pops up for User A."
				    		+ "2. User A receives the blank forms in pending forms list."
				    		+ "3. User A can submit the form."
				    		+ "4. The form pops up for User B."
				    		+ "5. User B receives the blank forms in pending forms list."
				    		+ "6. User B can submit the form.")
    public void testEdgeCase152625() throws Exception {

       gstrTCID = "152625";
       gstrTO = "Send a blank form to a user (User A) and a resource (RS), where another user (User B) has 'Update status' right on the resource RS and verify that:"
		    		+ "1. The form pops up for User A."
		    		+ "2. User A receives the blank forms in pending forms list."
		    		+ "3. User A can submit the form."
		    		+ "4. The form pops up for User B."
		    		+ "5. User B receives the blank forms in pending forms list."
		    		+ "6. User B can submit the form.";

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

       StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

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

       objUsersList.clickCreateNewUserButton()
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
       
       objUsersList.clickCreateNewUserButton()
				   .enterUserDetails(objUserdata.strNewUserName2,
		               objUserdata.strNewPassword, objUserdata.strFullName2)
			       .selectFirstRole()
			       .clickSaveButton();
       
       objUsersList.clickCreateNewUserButton()
				   .enterUserDetails(objUserdata.strNewUserName3,
		               objUserdata.strNewPassword, objUserdata.strFullName3)
			       .selectFirstRole()
			       .selectUpdateStatusOfResource(objResource_data.strResourceName)
			       .clickSaveButton();

       System.out.println(objUserdata.strNewUserName);
       System.out.println(objUserdata.strNewUserName1);
       System.out.println(objUserdata.strNewUserName2);
       System.out.println(objUserdata.strNewUserName3);

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
                    .selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
                    .clickOnNextButton()
                    .selectResources(objResource_data.strResourceName)
                    .clickOnNextButton()
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

       objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
                    objUserdata.strNewPassword);

       objRegionDefault1.selectFrame();

       objNavigationToSubmenus1.navigateToActivateForm();

       objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
	                    .selUserToFillOutForm(objUserdata.strNewUserName2)
	                    .selResourceToFillOutForm(strResourceValue[0])
	                    .clickOnActivateForm();

       objLogin1.clickLogOut();

       objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
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
                   .enterAnswerForMultiLineText(objFormConfiguration_data.strLabelName,
	            		   objBlankFormData.strTextAreaAnswer)
                   .enterAnswerInField(objFormConfiguration_data.strLabelName1,
                		   objBlankFormData.strTextAnswer)
                   .clickOnSave();
       Thread.sleep(5000);
       objBlankForm.clickOnComplete();
       
       objDispatchForm.selUserToReceiveCompletedForm(objUserdata.strNewUserName)
                      .clickOnDispatchForm();

       driver1.switchTo().window(mainWindowHandle1);

       objRegionDefault1.selectFrame();

       objLogin1.clickLogOut();

       objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
               objUserdata.strNewPassword);

       objRegionDefault1.selectFrame();
	
	   String mainWindowHandle2 = driver1.getWindowHandle();
	  
	   Thread.sleep(5000);
	   Set<String> a2 = driver1.getWindowHandles();
	   Iterator<String> ite2 = a2.iterator();
	
		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
			}
		}
	
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerForMultiLineText(
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAreaAnswer1)
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer1).clickOnSave();
		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
	  
	   objDispatchForm.selUserToReceiveCompletedForm(objUserdata.strNewUserName)
	                  .clickOnDispatchForm();
	 
	   driver1.switchTo().window(mainWindowHandle2);
	
	   objRegionDefault1.selectFrame();
	
	   objLogin1.clickLogOut();
  
       objLogin1.loginAsNewUser(objUserdata.strNewUserName,
                    objUserdata.strNewPassword);

      /* String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
	                    + objFormConfiguration_data.strLabelName + ": "
	                    + objBlankFormData.strTextAreaAnswer + "| "
	                    + objFormConfiguration_data.strLabelName1 + ": "
	                    + objBlankFormData.strTextAnswer;

       String strMsg1 = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
		               + objFormConfiguration_data.strLabelName + ": "
		               + objBlankFormData.strTextAreaAnswer1 + "| "
		               + objFormConfiguration_data.strLabelName1 + ": "
		               + objBlankFormData.strTextAnswer1;*/

		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(
						objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAreaAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
		
		String strMsg1 = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(
						objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAreaAnswer1,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer1);


       objRegionDefault1
                    .selectFrame()
                    .verWebNotificationframe()
                    .verWebNotificationMultipleMsgformsForms(objFormConfiguration_data.strFormName,
                                  strMsg)
                    .verWebNotificationMultipleMsgformsForms(objFormConfiguration_data.strFormName,
                                  strMsg1)
                    .clickAcknowledgeAllForms()
                    .selectFrame().switchToDefaultFrame().selectFrame();
       
       objLogin1.clickLogOut();
       
       gstrResult = "PASS";
    }
    
    /*************************************************************************************
	'Description : Verify that water mark is not displayed for 'Numeric'questionnaire on a blank form  
	'Precondition:
	'Date	 	 : 30-Mar-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that water mark is not displayed for 'Numeric'questionnaire on a blank form")
	public void testEdgeCase155268() throws Exception {

		gstrTCID = "155268";
		gstrTO = "Verify that water mark is not displayed for 'Numeric'questionnaire on a blank form";

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
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.verNumericWaterMarkWhileAddingQues(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strNumericNumWaterMark)
				.verNumericWaterMarkWhileAddingQues(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strNumericPrecWaterMark)
				.verNumericWaterMarkWhileAddingQues(
						objFormConfiguration_data.strLabelName2,
						objFormConfiguration_data.strNumericCurrencyWaterMark)
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
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.verNoWaterMarkFoundInNumericType(
						objFormConfiguration_data.strLabelName)
				.verNoWaterMarkFoundInNumericType(
						objFormConfiguration_data.strLabelName1)
				.verNoWaterMarkFoundInNumericType(
						objFormConfiguration_data.strLabelName2)
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

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	'Description :  Send a form to be filled out by a user who already has a pending form and verify that
					1. The count of forms in the “Pending Forms” alert is incremented by one."
					2. Both the forms are present in the Pending Forms page
	'Date	 	 : 01-Apr-2015
	'Author		 : Anil
	'------------------------------------------------------------------------------------------
	'Modified Date			                        	                     Modified By
	'Date					                                                 Name
	*******************************************************************************************/
	@Test(description = "Send a form to be filled out by a user who already has a pending form and verify that"
				+"1. The count of forms in the “Pending Forms” alert is incremented by one."
				+"2. Both the forms are present in the Pending Forms page")
	public void testEdgeCase152627() throws Exception {

		gstrTCID = "152627";
		gstrTO = "Send a form to be filled out by a user who already has a pending form and verify that"
				+"1. The count of forms in the “Pending Forms” alert is incremented by one."
				+"2. Both the forms are present in the Pending Forms page";

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
		ActivateForms objActivateForms = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm1 = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		FormList objFormList1 = new FormList(this.driver1);


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
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);


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

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault.selectFrame();
		
//		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);
//
//		objRegionDefault.selectFrame();
	
		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName1,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName1);


		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName1);

		Thread.sleep(2000);
		String mainWindowHandle2 = driver.getWindowHandle();

		Set<String> a2 = driver.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver.switchTo().window(popupHandle);

			}
		}

		Thread.sleep(5000);
		objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnGroupLink()
						    .verifyEditGroupOrTable()
						    .enterNewGroupName(objFormConfiguration_data.strGroupName1)
						    .clickOnGroupDoneButton()
						    .clickOnAddButton(objFormConfiguration_data.strGroupName1)
						    .clickOnFieldSet(objFormConfiguration_data.strGroupName1)
						    .verifyEditFieldSetWindow()
						    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName1)
						    .clickOnEditFieldDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName1)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName2)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName1)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strText)
						    .enterLabelName(objFormConfiguration_data.strLabelName3)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()				    
						    .clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle2);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToActivateForm();

		objActivateForms.clickOnSendForm(objFormConfiguration_data.strFormName)
						 .selUserToFillOutForm(objUserdata.strNewUserName)
						 .clickOnActivateForm();
		
		objLogin.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
						 objUserdata.strNewPassword);

		Thread.sleep(2000);
		objRegionDefault.selectFrame();

		String mainWindowHandle1 = driver.getWindowHandle();
		Set<String> a1 = driver.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		
		driver.close();
		
		driver.switchTo().window(mainWindowHandle1);
		
		objRegionDefault.selectFrame();

		objActivateForms.verifyPendingForms("1");
		
		objLogin.clickLogOut();
		
		objLogin.loginToApplication(objUserdata.strNewUserName,
				 objUserdata.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName1)
						 .selUserToFillOutForm(objUserdata.strNewUserName)
						 .clickOnActivateForm();
		
		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName,
						 objUserdata.strNewPassword);

		Thread.sleep(2000);
		objRegionDefault1.selectFrame();

		String mainWindowHandle3 = driver1.getWindowHandle();
		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm1.verFormTitle(objFormConfiguration_data.strFormName1);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle3);
		
		objRegionDefault1.selectFrame();

		objActivateForms1.verifyPendingForms("2");
		
		objNavigationToSubmenus1.navigateToFormList();
		
		objFormList1.verifyFormIsListedUnderMyInProgressForm(objFormConfiguration_data.strFormName);
        
		objFormList1.verifyFormIsListedUnderMyInProgressForm(objFormConfiguration_data.strFormName1);
		
		//once again fill the form
        objActivateForms1.clickOnFillOut(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle4 = driver1.getWindowHandle();
		
		Set<String> a4 = driver1.getWindowHandles();
		Iterator<String> ite4 = a4.iterator();
		
		while (ite4.hasNext()) {
			String popupHandle = ite4.next().toString();
			
			if (!popupHandle.contains(mainWindowHandle4)) {
				driver1.switchTo().window(popupHandle);				
			}
		}
		
		objBlankForm1.verFormTitle(objFormConfiguration_data.strFormName)
		.verGroupName(objFormConfiguration_data.strGroupName)
		.verFieldSetName(objFormConfiguration_data.strAttributeName)
		.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
		.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer);

		objBlankForm1.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName2)
				   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle4);

		Thread.sleep(10000);
		
		objRegionDefault1.selectFrame();

		//once again fill the form
        objActivateForms1.clickOnFillOut(objFormConfiguration_data.strFormName1);
		
        Thread.sleep(8000);
        
		String mainWindowHandle5 = driver1.getWindowHandle();
		
		Set<String> a5 = driver1.getWindowHandles();
		Iterator<String> ite5 = a5.iterator();
		
		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			
			if (!popupHandle.contains(mainWindowHandle5)) {
				driver1.switchTo().window(popupHandle);				
			}
		}
		
		objBlankForm1.verFormTitle(objFormConfiguration_data.strFormName1)
		.verGroupName(objFormConfiguration_data.strGroupName1)
		.verFieldSetName(objFormConfiguration_data.strAttributeName1)
		.enterAnswerInField(objFormConfiguration_data.strLabelName2, objBlankFormData.strNumericAnswer3)
		.enterAnswerInField(objFormConfiguration_data.strLabelName3,objBlankFormData.strTextAnswer1);

		objBlankForm1.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName2)
				   .clickOnDispatchForm();


		driver1.switchTo().window(mainWindowHandle5);

		objRegionDefault1.selectFrame();
	
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*********************************************************************************
	'Description : Send a completed form (NEW form) to a single resource RS, where a
	 			   single user (user A) has 'Run Report' right on the resource and verify 
	 			   that User A receives completed form via web, email and pager.
	'Precondition:
	'Date	 	 : 05-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Send a completed form (NEW form) to a single resource RS, where a single user (user A) has "
			+ "'Run Report' right on the resource and verify that User A receives completed form via web, email and pager.")
	public void testEdgeCase34001() throws Exception {
		
		gstrTCID = "34001";
		gstrTO = "Send a completed form (NEW form) to a single resource RS, where a single user (user A) has 'Run Report' "
				+ "right on the resource and verify that User A receives completed form via web, email and pager.";
		
        Login objLogin = new Login(this.driver1);
        Login_data objLogindata = new Login_data();
        FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
        User_data objUserdata = new User_data();
        BlankFormData objBlankFormData = new BlankFormData();
        ResourceType_data objResourceType_data = new ResourceType_data();
        StatusTypes_data objStatusTypes_data = new StatusTypes_data();
        Resource_data objResource_data = new Resource_data();

        SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
        UsersList objUsersList = new UsersList(this.driver1);
        RegionDefault objRegionDefault = new RegionDefault(this.driver1);
        NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
                     this.driver1);
        FormConfiguration objFormConfiguration = new FormConfiguration(
                     this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
        
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		
		System.out.println("-----Precondtion execution starts------");

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
        
		objUsersList.clickCreateNewUserButton()
					.enterUserDetails(objUserdata.strNewUserName,
							objUserdata.strNewPassword, objUserdata.strFullName)
					.selectFirstRole()
					.clickSaveButton();
 
        objUsersList.clickCreateNewUserButton()
                    .enterUserDetails(objUserdata.strNewUserName1,
                                 objUserdata.strNewPassword, objUserdata.strFullName1)
                    .selectFirstRole()
                    .clickAdvancedOptionAndExpand()
                    .selectFormUserMayActivateFormsOption()
                    .clickSaveButton();
          
        objUsersList.clickCreateNewUserButton()
					.enterAllUserDetails(objUserdata.strNewUserName2,
								objUserdata.strNewPassword, objUserdata.strFullName2,
	                            objUserdata.strFirstName, objUserdata.strMiddleName,
	                            objUserdata.strLastName, objUserdata.strOrganization,
	                            objUserdata.strPhone, objUserdata.strPrimaryMailId,
	                            objUserdata.strPrimaryMailId,
	                            objUserdata.strPrimaryMailId)
					.selectFirstRole()
		            .selectViewResourceCheckBox(objResource_data.strResourceName)
		            .selectRunReportRight(objResource_data.strResourceName)
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
                       .selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
                       .selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
                       .clickOnNextButton()
                       .selUserInUsersToFillOutForm(objUserdata.strNewUserName)
                       .clickOnNextButton()
                       .clickOnNextButton()
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

        Thread.sleep(5000);
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
        Thread.sleep(5000);
        objBlankForm.clickOnComplete();
          
        Thread.sleep(7000);
		objDispatchForm.selectResourcesInDispatch(
							objResource_data.strResourceName)
					   .clickOnDispatchForm();

        driver1.switchTo().window(mainWindowHandle1);

        objRegionDefault1.selectFrame();

        objLogin1.clickLogOut();

        objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
                       objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName + " for "
						+ objResource_data.strResourceName + "\nSummary: | "
						+ objFormConfiguration_data.strLabelName + ": "
						+ objBlankFormData.strNumericAnswer + "| "
						+ objFormConfiguration_data.strLabelName1 + ": "
						+ objBlankFormData.strTextAnswer;*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWith2Quest(
						objUserdata.strFullName,
						objResource_data.strResourceName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
 
          
        Thread.sleep(5000);
          
        objRegionDefault1
                       .selectFrame()
                       .verWebNotificationframe()
                       .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                                     strMsg)
                         .clickAcknowledgeAllForms()
                         .selectFrame();
        
        objRegionDefault1.switchToDefaultFrame()
        				 .selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		 
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
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

	/*********************************************************************************
	'Description : Send a completed form (NEW form) to single resource RS where multiple users 
	               (User A and user B) have 'Update status' right on the resource and verify that:
                   1. User A receives completed form via web, email and pager.
                   2. User B receives completed form via web, email and pager. 
	'Precondition:
	'Date	 	 : 06-May-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Send a completed form (NEW form) to single resource RS where multiple users"
			+ " (User A and user B) have 'Update status' right on the resource and verify that:"
			+ "1. User A receives completed form via web, email and pager."
			+ "2. User B receives completed form via web, email and pager.")
	public void testEdgeCase34004() throws Exception {

		gstrTCID = "34004";
		gstrTO = "Send a completed form (NEW form) to single resource RS where multiple users (User A and user B)"
				+ "have 'Update status' right on the resource and verify that:"
				+ "1. User A receives completed form via web, email and pager."
				+ "2. User B receives completed form via web, email and pager.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		System.out.println("-----Precondtion execution starts------");

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
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

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
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickSaveButton();
		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);
		System.out.println(objUserdata.strNewUserName3);

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
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
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

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);
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
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer).clickOnSave();
		Thread.sleep(5000);
		objBlankForm.clickOnComplete();

		Thread.sleep(7000);
		objDispatchForm.selectResourcesInDispatch(
				objResource_data.strResourceName).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName + " for "
				+ objResource_data.strResourceName + "\nSummary: | "
				+ objFormConfiguration_data.strLabelName + ": "
				+ objBlankFormData.strNumericAnswer + "| "
				+ objFormConfiguration_data.strLabelName1 + ": "
				+ objBlankFormData.strTextAnswer;*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWith2Quest(
						objUserdata.strFullName,
						objResource_data.strResourceName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);

		/*String strMsg1 = "Submitted by " + objUserdata.strFullName + " for "
				+ objResource_data.strResourceName + "\nSummary: | "
				+ objFormConfiguration_data.strLabelName + ": "
				+ objBlankFormData.strNumericAnswer + "| "
				+ objFormConfiguration_data.strLabelName1 + ": "
				+ objBlankFormData.strTextAnswer;*/
		
		String strMsg1 = objRegionDefault1
				.getWebNotificationForResourceWith2Quest(
						objUserdata.strFullName,
						objResource_data.strResourceName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);


		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg1)
				.clickAcknowledgeAllForms().selectFrame();

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		int intCount1 = 0;
		int intCount2 = 0;

		for (int intCount = 0; intCount < 6; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);
			int intValue = 0;
			intValue = objMailVerificationFunctions
					.verifyMailBodyWithValue(strMsgBody);
			intCount1 = intCount1 + intValue;
			intValue = 0;
			intValue = objMailVerificationFunctions
					.verifyMailBodyWithValue(strMsgBody1);
			intCount2 = intCount2 + intValue;
			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(intCount1 == 4 && intCount2 == 2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}

	/*********************************************************************************
	'Description : Send a completed form (NEW form) to a single resource RS, where a 
				   single user (user A) has 'Update status' right on the resource and
				    verify that User A receives completed form via web, email and pager.
	'Precondition:
	'Date	 	 : 06-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Send a completed form (NEW form) to a single resource RS, where a single user (user A) has "
			+ "'Update status' right on the resource and verify that User A receives completed form via web, email and pager.")
	public void testEdgeCase33998() throws Exception {
		
		gstrTCID = "33998";
		gstrTO = "Send a completed form (NEW form) to a single resource RS, where a single user (user A) has 'Update status' "
				+ "right on the resource and verify that User A receives completed form via web, email and pager.";
		
        Login objLogin = new Login(this.driver1);
        Login_data objLogindata = new Login_data();
        FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
        User_data objUserdata = new User_data();
        BlankFormData objBlankFormData = new BlankFormData();
        ResourceType_data objResourceType_data = new ResourceType_data();
        StatusTypes_data objStatusTypes_data = new StatusTypes_data();
        Resource_data objResource_data = new Resource_data();

        SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
        UsersList objUsersList = new UsersList(this.driver1);
        RegionDefault objRegionDefault = new RegionDefault(this.driver1);
        NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
                     this.driver1);
        FormConfiguration objFormConfiguration = new FormConfiguration(
                     this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
        
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		
		System.out.println("-----Precondtion execution starts------");

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
        
		objUsersList.clickCreateNewUserButton()
					.enterUserDetails(objUserdata.strNewUserName,
							objUserdata.strNewPassword, objUserdata.strFullName)
					.selectFirstRole()
					.clickSaveButton();
 
        objUsersList.clickCreateNewUserButton()
                    .enterUserDetails(objUserdata.strNewUserName1,
                                 objUserdata.strNewPassword, objUserdata.strFullName1)
                    .selectFirstRole()
                    .clickAdvancedOptionAndExpand()
                    .selectFormUserMayActivateFormsOption()
                    .clickSaveButton();
          
        objUsersList.clickCreateNewUserButton()
					.enterAllUserDetails(objUserdata.strNewUserName2,
								objUserdata.strNewPassword, objUserdata.strFullName2,
	                            objUserdata.strFirstName, objUserdata.strMiddleName,
	                            objUserdata.strLastName, objUserdata.strOrganization,
	                            objUserdata.strPhone, objUserdata.strPrimaryMailId,
	                            objUserdata.strPrimaryMailId,
	                            objUserdata.strPrimaryMailId)
					.selectFirstRole()
		            .selectViewResourceCheckBox(objResource_data.strResourceName)
		            .selectUpdateStatusOfResource(objResource_data.strResourceName)
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
                       .selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
                       .selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
                       .clickOnNextButton()
                       .selUserInUsersToFillOutForm(objUserdata.strNewUserName)
                       .clickOnNextButton()
                       .clickOnNextButton()
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

        Thread.sleep(5000);
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
        Thread.sleep(5000);
        objBlankForm.clickOnComplete();
          
        Thread.sleep(7000);
		objDispatchForm.selectResourcesInDispatch(
							objResource_data.strResourceName)
					   .clickOnDispatchForm();

        driver1.switchTo().window(mainWindowHandle1);

        objRegionDefault1.selectFrame();

        objLogin1.clickLogOut();

        objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
                       objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName + " for "
						+ objResource_data.strResourceName + "\nSummary: | "
						+ objFormConfiguration_data.strLabelName + ": "
						+ objBlankFormData.strNumericAnswer + "| "
						+ objFormConfiguration_data.strLabelName1 + ": "
						+ objBlankFormData.strTextAnswer;*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWith2Quest(
						objUserdata.strFullName,
						objResource_data.strResourceName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
 
        Thread.sleep(5000);
          
        objRegionDefault1
                       .selectFrame()
                       .verWebNotificationframe()
                       .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                                     strMsg)
                         .clickAcknowledgeAllForms()
                         .selectFrame();
        
        objRegionDefault1.switchToDefaultFrame()
        				 .selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		 
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
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
	'Description : Configure a form (NEW form) to be activated on a status change of multi status type and verify that the form can be filled out by a user with 'Associated with' right on the resource
	'Precondition:
	'Date	 	 : 07-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Configure a form (NEW form) to be activated on a status change of multi status type and verify that the form can be filled out by a user with 'Associated with' right on the resource")
	public void testEdgeCase33812() throws Exception {

		gstrTCID = "33812";
		gstrTO = "Configure a form (NEW form) to be activated on a status change of multi status type and verify that the form can be filled out by a user with 'Associated with' right on the resource";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

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
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.navigateToStatusTypeListNew();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
//		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

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
				.selectAssosciateResourceRight(objResource_data.strResourceName)
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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectFormDoNotParticipateInFormsForResourcesOption()
				.selectReportformDetail().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.selectFormActivation(
						objFormConfiguration_data.strAsCertainStatusChanges)
				.clickOnNextButton()
				.selectStatusTypes(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnSelectStatusTypeButton()
				.selectMSTStatusesOption(strStatusesValues[0],
						strStatusesValues[1])
				.clickOnSaveConfiguration()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectRunReportInSecurityPageForAsCertainStatsChangs(
						objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		String strApplicationDate = objEventManagement
				.getApplicationTimeWithCSTCDT();
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

		objnNavigationToSubMenus1.clickOnViewMenu();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.selectMSTUpdateValue(strStatusTypeValues[0],
				strStatusesValues[0]);

		UpdateStatus_page1.clickOnSaveButton();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.selectMSTUpdateValue(strStatusTypeValues[0],
				strStatusesValues[1]);

		UpdateStatus_page1.clickOnSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		strApplicationDate = objEventManagement1.getApplicationTimeWithCSTCDT();
		String[] strDateInApplication = strApplicationDate.split(" ");
		String strActivationDate = "";
		int intDateInApplication = Integer.parseInt(strDateInApplication[0]);
		if (intDateInApplication == intCurrentDate) {
			strActivationDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDateInApplication < intCurrentDate) {
				strActivationDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strActivationDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		strDate = strApplicationDate.split(" ");

		String strActivationTime = strDate[2];
		System.out.println("Activation Date: " + strActivationDate
				+ "\nActivationTime: " + strActivationTime);

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
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		Thread.sleep(3000);
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();

		Thread.sleep(1000);

		String strApplicationDate1 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String[] strDate1 = strApplicationDate1.split(" ");
		String strEndDate = "";
		int intDate1 = Integer.parseInt(strDate1[0]);
		if (intDate1 == intCurrentDate) {
			strEndDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate1 < intCurrentDate) {
				strEndDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strEndDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String strCompletedTime = strDate1[2];
		System.out.println("Completed Time: " + strCompletedTime);
		Thread.sleep(5000);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer + "| "
				+ objFormConfiguration_data.strLabelName1 + ": "
				+ objBlankFormData.strTextAnswer;*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();
		Thread.sleep(3000);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objnNavigationToSubMenus1.navigateToFormReport();

		System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.clickOnGenerateReportBtn();

		Thread.sleep(5000);

		String[] strQuestions = { objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strLabelName1 };

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strHtmlHeaderContents, strQuestions);

		String strCompletedByName = objUserdata.strFullName + " at "
				+ objResource_data.strResourceName;

		String[] strAnswers = { strActivationDate, strActivationTime,
				objUserdata.strNewUserName1, objUserdata.strFullName1,
				strEndDate, strCompletedTime, objUserdata.strNewUserName,
				strCompletedByName, objBlankFormData.strNumericAnswer,
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

		objReport1
				.verifyFormNameStartDateAndEndDate(
						objFormConfiguration_data.strFormName, strStartDate,
						strEndDate).verHTMLFormHeadersAndAnswers(
						strHeaderNames, strAnswers);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToFormReport();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.selectXlsxRadioBtn().clickOnGenerateReportBtn();
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

		String[] arrForm = { "Form", objFormConfiguration_data.strFormName };
		String[] arrStartDate = { "Start Date", strStartDate };
		String[] arrEndDate = { "End Date", strEndDate };

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

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions
				.getFormMailBodyWithResource(objUserdata.strFullName,
						objLogindata.strRegionName,
						objResource_data.strResourceName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions
				.getFormPagerBodyWithResource(objUserdata.strFullName,
						objLogindata.strRegionName,
						objResource_data.strResourceName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strLabelValue,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

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
	'Description : Configure a form (NEW form) to be activated on a status change of saturation score status type and verify that the form can be filled out by a user with 'Associated with' right on the resource 
	'Precondition:
	'Date	 	 : 08-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Configure a form (NEW form) to be activated on a status change of saturation score status type and verify that the form can be filled out by a user with 'Associated with' right on the resource ")
	public void testEdgeCase33813() throws Exception {

		gstrTCID = "33813";
		gstrTO = "Configure a form (NEW form) to be activated on a status change of saturation score status type and verify that the form can be filled out by a user with 'Associated with' right on the resource ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

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

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

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
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strSSTStatusTypeName);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strSSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

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
				.selectAssosciateResourceRight(objResource_data.strResourceName)
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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectFormDoNotParticipateInFormsForResourcesOption()
				.selectReportformDetail().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.selectFormActivation(
						objFormConfiguration_data.strAsCertainStatusChanges)
				.clickOnNextButton()
				.selectStatusTypes(objStatusTypes_data.strSSTStatusTypeName)
				.clickOnSelectStatusTypeButton()
				.selectWhenToSendOption(
						objFormConfiguration_data.strWheneverStatusIsAbove)
				.enterStatusTypeValue(
						objFormConfiguration_data.strStatusTypeValue)
				.clickOnSaveConfiguration()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectRunReportInSecurityPageForAsCertainStatsChangs(
						objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		String strApplicationDate = objEventManagement
				.getApplicationTimeWithCSTCDT();
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

		objnNavigationToSubMenus1.clickOnViewMenu();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValues[0],
				objView_data.strValueForSST);

		UpdateStatus_page1.clickOnSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		strApplicationDate = objEventManagement1.getApplicationTimeWithCSTCDT();
		String[] strDateInApplication = strApplicationDate.split(" ");
		String strActivationDate = "";
		int intDateInApplication = Integer.parseInt(strDateInApplication[0]);
		if (intDateInApplication == intCurrentDate) {
			strActivationDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDateInApplication < intCurrentDate) {
				strActivationDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strActivationDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		strDate = strApplicationDate.split(" ");

		String strActivationTime = strDate[2];
		System.out.println("Activation Date: " + strActivationDate
				+ "\nActivationTime: " + strActivationTime);

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
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		Thread.sleep(3000);
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();

		Thread.sleep(1000);

		String strApplicationDate1 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String[] strDate1 = strApplicationDate1.split(" ");
		String strEndDate = "";
		int intDate1 = Integer.parseInt(strDate1[0]);
		if (intDate1 == intCurrentDate) {
			strEndDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate1 < intCurrentDate) {
				strEndDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strEndDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String strCompletedTime = strDate1[2];
		System.out.println("Completed Time: " + strCompletedTime);
		Thread.sleep(5000);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer + "| "
				+ objFormConfiguration_data.strLabelName1 + ": "
				+ objBlankFormData.strTextAnswer;
*/
		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();
		Thread.sleep(3000);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objnNavigationToSubMenus1.navigateToFormReport();

		System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.clickOnGenerateReportBtn();

		Thread.sleep(5000);

		String[] strQuestions = { objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strLabelName1 };

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strHtmlHeaderContents, strQuestions);

		String strCompletedByName = objUserdata.strFullName + " at "
				+ objResource_data.strResourceName;

		String[] strAnswers = { strActivationDate, strActivationTime,
				objUserdata.strNewUserName1, objUserdata.strFullName1,
				strEndDate, strCompletedTime, objUserdata.strNewUserName,
				strCompletedByName, objBlankFormData.strNumericAnswer,
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

		objReport1
				.verifyFormNameStartDateAndEndDate(
						objFormConfiguration_data.strFormName, strStartDate,
						strEndDate).verHTMLFormHeadersAndAnswers(
						strHeaderNames, strAnswers);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToFormReport();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.selectXlsxRadioBtn().clickOnGenerateReportBtn();
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

		String[] arrForm = { "Form", objFormConfiguration_data.strFormName };
		String[] arrStartDate = { "Start Date", strStartDate };
		String[] arrEndDate = { "End Date", strEndDate };

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

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions
				.getFormMailBodyWithResource(objUserdata.strFullName,
						objLogindata.strRegionName,
						objResource_data.strResourceName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions
				.getFormPagerBodyWithResource(objUserdata.strFullName,
						objLogindata.strRegionName,
						objResource_data.strResourceName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strLabelValue,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

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
	'Description : Configure a form (NEW form) to be activated on a status change of number
	 				status type and verify that the form can be filled out by a user with 
	 				'Associated with' right on the resource
	'Precondition:
	'Date	 	 : 08-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Configure a form (NEW form) to be activated on a status change of number status type and verify that "
			+ "the form can be filled out by a user with 'Associated with' right on the resource")
	public void testEdgeCase33814() throws Exception {

		gstrTCID = "33814";
		gstrTO = "Configure a form (NEW form) to be activated on a status change of number status type and verify that the "
				+ "form can be filled out by a user with 'Associated with' right on the resource";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		
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
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

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
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);
//		objViewsList.clickCreateNewViewButton()
//					.enterViewName(objView_data.strViewName)
//					.enterViewDesc(objView_data.strViewDesc);
//		
//		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName);
//		
//		objViewsList.selectResource(objResource_data.strResourceName)
//		.clickOnSaveOfCreateNewView();
		
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
				.selectAssosciateResourceRight(objResource_data.strResourceName)
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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectFormDoNotParticipateInFormsForResourcesOption()
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
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.selectFormActivation(objFormConfiguration_data.strAsCertainStatusChanges)
				.clickOnNextButton()
				.selectStatusTypes(objStatusTypes_data.strNSTStatusTypeName)
				.clickOnSelectStatusTypeButton()
				.selectWhenToSendOption(objFormConfiguration_data.strWheneverStatusIsAbove)
				.enterStatusTypeValue(objFormConfiguration_data.strStatusTypeValue)
				.clickOnSaveConfiguration()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectRunReportInSecurityPageForAsCertainStatsChangs(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		
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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnViewMenu()
								 .navigateToParticularViewUnderViewMenu(
										objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(
				objResource_data.strResourceName);
				
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objFormConfiguration_data.strValueForUpdate2)
						  .clickOnSaveButton();
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
					 	objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
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
		
		Thread.sleep(3000);
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

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName1,
						 	objUserdata.strNewPassword);
/*
		String strMsg = "Submitted by " + objUserdata.strFullName
						+ "\nSummary: | " + objFormConfiguration_data.strLabelName
						+ ": " + objBlankFormData.strNumericAnswer + "| "
						+ objFormConfiguration_data.strLabelName1 + ": "
						+ objBlankFormData.strTextAnswer;
		*/
		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);


		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
						strMsg)
				.clickAcknowledgeAllForms()
				.selectFrame();
		Thread.sleep(3000);
		
		objRegionDefault1.switchToDefaultFrame()
						 .selectFrame();
		
		objnNavigationToSubMenus1.navigateToFormReport();

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
		
		String strCompletedByName = objUserdata.strFullName + " at " + objResource_data.strResourceName;
		
		String[] strAnswers = {strActivationDate,
				strActivationTime,
				objUserdata.strNewUserName1,
				objUserdata.strFullName1,
				strEndDate,
				strCompletedTime,
				objUserdata.strNewUserName,
				strCompletedByName,
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

		objnNavigationToSubMenus1.navigateToFormReport();

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
		
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		
		String strMsgBody = objMailVerificationFunctions.getFormMailBodyWithResource(
				objUserdata.strFullName, objLogindata.strRegionName, objResource_data.strResourceName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBodyWithResource(
				objUserdata.strFullName, objLogindata.strRegionName, objResource_data.strResourceName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strLabelValue,objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

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
	'Description : Configure a form (NEW form) to be activated on shift time, select resource
	 				RS for filling out the form and verify that the form can be filled out by
	 				 a user with 'Associated with' right on the resource
	'Precondition:
	'Date	 	 : 11-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Configure a form (NEW form) to be activated on shift time, select resource RS for filling out the "
			+ "form and verify that the form can be filled out by a user with 'Associated with' right on the resource")
	public void testEdgeCase33811() throws Exception {

		gstrTCID = "33811";
		gstrTO = "Configure a form (NEW form) to be activated on shift time, select resource RS for filling out the form "
				+ "and verify that the form can be filled out by a user with 'Associated with' right on the resource";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
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

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		
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
		
		String strStatusTypeValues[] = new String[2];
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

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
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
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.deselectAssosciatedWithRight()
				.selectViewResourceCheckBox(
						objResource_data.strResourceName)
				.selectAssosciateResourceRight(
						objResource_data.strResourceName)
				.selectRunReportRight(
						objResource_data.strResourceName)
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
						objFormConfiguration_data.strPredifinedShifts)
				.verCompletedFormDeliveryIsDisabled(
						objFormConfiguration_data.strTemplateDefine)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton();
				
		String strAppTime = objFormConfiguration.getApplicationTime();
		
		System.out.println(strAppTime);
		
		objFormConfiguration.selectShift(objFormConfiguration_data.strShift1);
		
		String strActivationShiftTime = objFormConfiguration.selectTimeByAddingFourMins(strAppTime,
															objFormConfiguration_data.strShift1);
		
		System.out.println(strActivationShiftTime);
		
		objFormConfiguration.clickOnNextButton()
							.clickOnNextButton()
							.selectResources(
									objResource_data.strResourceName)
							.clickOnNextButton()
							.selUserToRcvCompltdForm(
									objUserdata.strNewUserName1)
							.clickOnNextButton()
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
		Thread.sleep(10000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		System.out.println("3 mins wait");
		TimeUnit.MINUTES.sleep(3);
		System.out.println("3 mins wait ended.");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						 objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();

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
		
		System.out.println("Activatio Date: " + strActivationDate);

		Thread.sleep(5000);

		String mainWindowHandle1 = driver1.getWindowHandle();
		
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();
		
		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
		
			}
		}
		objBlankForm.switchToFormFrame()
					.enterAnswerInField(objFormConfiguration_data.strLabelName, 
							objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,
							objBlankFormData.strTextAnswer)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		Thread.sleep(3000);
	
		driver1.close();
		
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

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
						 	objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName + " for "
						+ objResource_data.strResourceName + "\nSummary: | "
						+ objFormConfiguration_data.strLabelName + ": "
						+ objBlankFormData.strNumericAnswer + "| "
						+ objFormConfiguration_data.strLabelName1 + ": "
						+ objBlankFormData.strTextAnswer;*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWith2Quest(
						objUserdata.strFullName,
						objResource_data.strResourceName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame()
						 .verWebNotificationframe()
						 .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
										strMsg);					
	
		Thread.sleep(5000);
		objRegionDefault1.selectFrame();
		Thread.sleep(3000);
		
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

		String[] strQuestions = { objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strLabelName1 };

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strHtmlHeaderContents, strQuestions);
		
		String[] strAnswers = {strActivationDate,
				strActivationShiftTime,
				"system",
				objUserdata.strFullName1,
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
}
