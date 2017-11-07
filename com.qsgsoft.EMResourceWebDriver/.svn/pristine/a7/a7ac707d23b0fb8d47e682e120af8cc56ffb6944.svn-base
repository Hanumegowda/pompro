package requirementGroup.Forms;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import lib.dataObject.BlankFormData;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.EventManagement;
import lib.page.FormConfiguration;
import lib.page.FormList;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayForms extends TestNG_UI_EXTENSIONS {
	
	public HappyDayForms() throws Exception {
		super();
	}

	/*************************************************************************************
	'Description : Verify that 'Review' and 'Acknowledgements' links are available for all forms irrespective of 'Read Receipt' setting. 
	'Precondition:
	'Date	 	 : 11-Mar-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that 'Review' and 'Acknowledgements' links are available for all forms irrespective of 'Read Receipt' setting. ")
	public void testHappyDay162673() throws Exception {

		gstrTCID = "162673";
		gstrTO = "Verify that 'Review' and 'Acknowledgements' links are available for all forms irrespective of 'Read Receipt' setting. ";

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
						objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1).selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2).selectFirstRole()
		.clickSaveButton().verifyUserListPageIsDisplayed();
		
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
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
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

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.clickOnConfigureForm();
		
		objFormConfiguration
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName1,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selReadReceipt()
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName1);

		String mainWindowHandle1 = driver.getWindowHandle();

		Thread.sleep(5000);
		
		Set<String> a1 = driver.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver.switchTo().window(popupHandle);

			}
		}

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

		driver.switchTo().window(mainWindowHandle1);

		objRegionDefault.selectFrame();
		
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
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
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objRegionDefault1.clickOnHomeButton();
		
		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName1)
				.selUserToFillOutForm(objUserdata.strNewUserName)
				.clickOnActivateForm();

		objNavigationToSubmenus1.navigateToFormList();
		
		objBlankForm.verifyReviewAndAcknowledgeLink(objFormConfiguration_data.strFormName);
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
						 objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);
		String mainWindowHandle3 = driver1.getWindowHandle();
		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName1)
					.verGroupName(objFormConfiguration_data.strGroupName1)
					.verFieldSetName(objFormConfiguration_data.strAttributeName1)
					.enterAnswerInField(objFormConfiguration_data.strLabelName2, objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName3,objBlankFormData.strTextAnswer)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		Thread.sleep(5000);
		
		objDispatchForm.selUserToReceiveCompletedFormNew(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame();

		objRegionDefault1.clickOnHomeButton();
		
		objNavigationToSubmenus1.navigateToFormList();
		
		objBlankForm.verifyReviewAndAcknowledgeLink(objFormConfiguration_data.strFormName1);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************************************
	'Description : Verify that 'Delivered To', 'Acknowledged On', & 'Acknowledged By' column header are 
	               displayed on 'Acknowledgements List' screen under resource acknowledgements.
	'Date	 	 : 11-Mar-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------------
	'Modified Date			                        	                         Modified By
	'Date					                                                     Name
	****************************************************************************************************/
	@Test(description = "Verify that 'Delivered To', 'Acknowledged On', & 'Acknowledged By' column header "
			+ "are displayed on 'Acknowledgements List' screen under resource acknowledgements.")
	public void testHappyDay162672() throws Exception {

		gstrTCID = "162672";
		gstrTO = "Verify that 'Delivered To', 'Acknowledged Time', & 'Acknowledged By' column header are "
				+ "displayed on 'Acknowledgements List' screen under resource acknowledgements. [Edit]";

		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement EventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm1 = new BlankForm(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);
		FormList objFormList1 = new FormList(this.driver1);
		
		String strStatusTypeValues [] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue    [] = new String[1];
		
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

		objResource.clickOnCreateNewResourceButton()
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
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
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
		
		System.out.println("--------Precondition ends and test execution starts--------");

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
		objBlankForm1.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.clickOnSave();
		
		objBlankForm1.clickOnComplete();
		
		Thread.sleep(10000);
		objDispatchForm1.selectResourcesInDispatchNew(
				objResource_data.strResourceName).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						 	objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName1+" for "+objResource_data.strResourceName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strNumericAnswer;
		
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWithOneQuest(objUserdata.strFullName1,
						objResource_data.strResourceName, objLogindata.strRegionName,
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
		
		String strApplicationTime =EventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		
		System.out.println(strApplicationTime);
	
		objNavigationToSubmenus1.navigateToFormList();
		
		objFormList1.clickOnAckLinkInMyRecentForms(objFormConfiguration_data.strFormName)
		
		           .verifyDeliverDetailsInResAcknowledgeList(objResource_data.strResourceName)
		           
		           .verifyAckByDetailsInResAcknowledgeList(objUserdata.strFullName)
		           
		           .verifyAckOnDetailsInResAcknowledgeList(strApplicationTime);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/************************************************************************************
	'Description : Verify that 'Send Form' web notification is received by the user 4min after 
	               completing the form (Form is completed but not dispatched).  
	'Date	 	 : 20-Mar-2015
	'Author		 : Hanumegowda
	'-----------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that 'Send Form' web notification is received by the user 4min after"
			+ "completing the form (Form is completed but not dispatched).")
	public void testHappyDay155627() throws Exception {

		gstrTCID = "155627";
		gstrTO = "Verify that 'Send Form' web notification is received by the user 4min after"
				+ "completing the form (Form is completed but not dispatched).";

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
		BlankFormData objBlankFormData = new BlankFormData();
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormList objFormList = new FormList(this.driver1);

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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
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
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
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

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(4000);
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
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer).clickOnSave();
		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
		Thread.sleep(5000);
		driver1.close();
		driver1.switchTo().window(mainWindowHandle1);
		Thread.sleep(5000);
		objRegionDefault1.selectFrame();
		Thread.sleep(5000);
		objNavigationToSubmenus1.navigateToFormList();
		objFormList.verifyFormListPage();
		objFormList
				.verFormListedUnderMyUnsentForms(objFormConfiguration_data.strFormName);

		String strMsg = objRegionDefault1.getNotificationToSendCompletedForm();
		TimeUnit.MINUTES.sleep(5);
		// driver1.navigate().refresh();

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame()
				.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/************************************************************************************
	'Description : Verify that questionnaire without data under 'Label' field cannot be saved 
	'Date	 	 : 19-OCT-2015
	'Author		 : Sangappa.k
	*************************************************************************************/
	@Test(description = "Verify that questionnaire without data under 'Label' field cannot be saved")
	public void testHappyDay168608() throws Exception {

		gstrTCID ="168608";
		gstrTO = "Verify that questionnaire without data under 'Label' field cannot be saved";

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
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

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
				.selectFormUserMayActivateFormsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
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
						objFormConfiguration_data.strComptdFormDelvry)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();
		
		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		
		objLogin.clickLogOut();
		
		//IE login
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);
		//Thread.sleep(200000);

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
				.verSaveBtnIsDaisbledInEditQsnryWin()
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.verSaveBtnIsEnabledInEditQsnryWin()
				.eraseEnteredLabelNameAndVerLablIsRqrdText()
				.verSaveBtnIsDaisbledInEditQsnryWin()
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnDoneButton()
				
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.verSaveBtnIsDaisbledInEditQsnryWin()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.verSaveBtnIsEnabledInEditQsnryWin()
				.eraseEnteredLabelNameAndVerLablIsRqrdText()
				.verSaveBtnIsDaisbledInEditQsnryWin()
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnDoneButton()
	
				.clickOnInsertElement(objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.verSaveBtnIsDaisbledInEditQsnryWin()
				.clickOnCancelOfEditQsnry()
				.verPrevewAndSaveButtonsAreDisabled()
				.verSaveAndPublishBtnsAreDisabled()
				.verValidationMsgLabelReq()
				.clickOnEditOf3RdQuestionnaire()
				.enterLabelName(objFormConfiguration_data.strLabelName2)
		        .clickOnDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);
		
	objFormConfiguration1.verifyQsnryUnderFiledSet(objFormConfiguration_data.strAttributeName, objFormConfiguration_data.strLabelName)
		    .verifyQsnryUnderFiledSet(objFormConfiguration_data.strAttributeName,objFormConfiguration_data.strLabelName1)
		   .verifyQsnryUnderFiledSet(objFormConfiguration_data.strAttributeName,objFormConfiguration_data.strLabelName2);
		
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(5000);
		String currentWindowHandle = driver1.getWindowHandle();
		for (String childwindow : driver1.getWindowHandles()) {
			driver1.switchTo().window(childwindow);
		}
		
		Thread.sleep(5000);
		objFormConfiguration1.verLabelNamesInPreviewPage(objFormConfiguration_data.strLabelName);
		objFormConfiguration1.verLabelNamesInPreviewPage(objFormConfiguration_data.strLabelName1);
		objFormConfiguration1.verLabelNamesInPreviewPage(objFormConfiguration_data.strLabelName2);

		driver1.close();

		driver1.switchTo().window(currentWindowHandle);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);
		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	/************************************************************************************
	'Description : Verify that 'Published' column displays appropriate value on 'Form Configuration' page. 
	'Date	 	 : 21-Mar-2016
	'Author		 : Sangappa.k
	*************************************************************************************/
	@Test(description = "Verify that 'Published' column displays appropriate value on 'Form Configuration' page. ")
	public void testHappyDay180620() throws Exception {

		gstrTCID ="180620";
		gstrTO = "Verify that 'Published' column displays appropriate value on 'Form Configuration' page. ";

		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

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
				.clickOnNextButton()
				.clickOnNextButton()
				.clickOnNextInResourcesToFillFormPage()
				.clickOnSaveOfFormSecuritySetting()
				.verPublishedColumnStatusInFormCongPage(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strUnpublished);

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
				.clickOnDoneButton();

		driver1.close();
		driver1.switchTo().window(mainWindowHandle);
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objFormConfiguration1.verPublishedColumnStatusInFormCongPage(
				objFormConfiguration_data.strFormName,
				objFormConfiguration_data.strUnpublished)

		.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle1);

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
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnDoneButton().clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objNavigationToSubmenus1.clickOnConfigureForm();
		objFormConfiguration1.verPublishedColumnStatusInFormCongPage(
				objFormConfiguration_data.strFormName,
				objFormConfiguration_data.strPublished);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
		
		