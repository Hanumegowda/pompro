package requirementGroup.CreatingAndManagingUsers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import lib.dataObject.*;
import lib.module.NavigationToSubMenus;
import lib.module.UserFunctions;
import lib.page.ActivateForms;
import lib.page.BlankForm;
import lib.page.ChangePassword;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.RegionalInfo;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UpdateUserInfo;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseCreateUser extends TestNG_UI_EXTENSIONS{

	public EdgeCaseCreateUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a user cannot be created by providing duplicate username. 
	'Date	 	 : 16-Feb-2016
	'Author		 : Renushree
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a user cannot be created by providing duplicate username. ")
	public void testEdgeCase88035() throws Exception {

		gstrTCID = "88035";
		gstrTO = "Verify that a user cannot be created by providing duplicate username. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();
		System.out.println(objUserdata.strNewUserName);

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton().verErrorHeading()
				.verErrorMsgWhenUserWithDuplicateNameProvided();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user can be created by selecting all the rights. 
	'Date	 	 : 16-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user can be created by selecting all the rights. ")
	public void testEdgeCase88717() throws Exception {

		gstrTCID = "88717";
		gstrTO = "Verify that user can be created by selecting all the rights. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().selectMaintainAdHocEventsOption()
				.selectMaintainEventTemplateOption()
				.selectFormDoNotParticipateInFormsForResourcesOption()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayConfigureFormSecurity()
				.selectFormUserMayActivateAndModifyFormsOption()
				.selectInstantMessagingInitiateChatSessionOption()
				.selectIncomingPatientNotificationOption()
				.selectCreateIncomingPatientNotificationsOption()
				.selectEditEventNotificationPreferencesOption()
				.selectReporAuditResourceDetail()
				.selectReporMonthlyStatusAssessment()
				.selectReportStatewideResourceDetail()
				.selectReportStatusDetailOption()
				.selectReportStatusReasonDetailOption()
				.selectReportStatusReasonSummaryOption()
				.selectReportStatusSnapshotOption()
				.selectReportStatusSummaryOption()
				.selectReportEventDetailOption()
				.selectReportEventSnapshotOption().selectReportformDetail()
				.selectSetupResourceOption().selectSetupResourceTypesOption()
				.selectSetUpRolesRight().selectSetupStatusReasonOption()
				.selectSetupStatusTypesOption()
				.selectConfigureRegionViewsOption()
				.selectConfigureMultiRegionViewsOption()
				.selectConfigureRegionalUserAccessOption()
				.selectEditResourcesOnlyOption().selectViewcustomViewOption()
				.selectOverrideViewingRestrictionOption()
				.selectMustUpdateOverdueStatusOption()
				.selectHavBedScheduleAndActivateHaavBedInterface()
				.selectEditRegionalMessageBulletinBoard()
				.selecMaintainDocumentLibraryOption()
				.selectUserViewUserInformationOnlyOption()
				.selectPreferencesDontNotSendUserReminderMails()
				.selectEditStatusChangeNotPrefernceOption()
				.selectMayUpdateRegionSetupInformationOption()
				.selectadministerOtherRegionViewsOption()
				.selectUserResetPasswordOnly().clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.verSelectFormUserMayActivateandModifyFormsOptionIsSelected()
				.verMaintainEventsOptionIsSelected()
				.verMaintainAdHocEventsOptionIsSelected()
				.verMaintainEventTemplateOptionIsSelected()
				.verFormDoNotParticipateInFormsForResourcesOptionIsSelected()
				.verFormUserMayActivateFormsOptionIsSelected()
				.verFormUserMayConfigureFormSecurityIsSelected()
				.verFormUserMayActivateAndModifyFormsOptionIsSelected()
				.verInstantMessagingInitiateChatSessionOptionIsSelected()
				.verIncomingPatientNotificationOptionIsSelected()
				.verCreateIncomingPatientNotificationsOptionIsSelected()
				.verEditEventNotificationPreferencesOptionIsSelected()
				.verReporAuditResourceDetailIsSelected()
				.verReporMonthlyStatusAssessmentIsSelected()
				.verReportStatewideResourceDetail()
				.verReportStatusDetailOptionIsSelected()
				.verReportStatusReasonDetailOptionIsSelected()
				.verReportStatusReasonSummaryOptionIsSelected()
				.verReportStatusSnapshotOptionIsSelected()
				.verReportStatusSummaryOptionIsSelected()
				.verReportEventDetailOptionIsSelected()
				.verReportEventSnapshotOptionIsSelected()
				.verReportformDetailIsSelected()
				.verSetupResourceOptionIsSelected()
				.verSetupResourceTypesOptionIsSelected()
				.verSetUpRolesRightIsSelected()
				.verSetupStatusReasonOptionIsSelected()
				.verSetupStatusTypesOptionIsSelected()
				.verConfigureRegionViewsOptionIsSelected()
				.verConfigureMultiRegionViewsOptionIsSelected()
				.verConfigureRegionalUserAccessOptionIsSelected()
				.verEditResourcesOnlyOptionIsSelected()
				.verViewcustomViewOptionIsSelected()
				.verOverrideViewingRestrictionOptionIsSelected()
				.verMustUpdateOverdueStatusOptionIsSelected()
				.verHavBedScheduleAndActivateHaavBedInterfaceIsSelected()
				.verEditRegionalMessageBulletinBoardIsSelected()
				.verMaintainDocumentLibraryOptionIsSelected()
				.verUserViewUserInformationOnlyOptionIsSelected()
				.verPreferencesDontNotSendUserReminderMailsIsSelected()
				.verEditStatusChangeNotPrefernceOptionIsSelected()
				.verMayUpdateRegionSetupInformationOptionIsSelected()
				.veradministerOtherRegionViewsOptionIsSelected()
				.verUserResetPasswordOnlyIsSelected();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user can be created with the right to reset password. 
	'Date	 	 : 18-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user can be created with the right to reset password.")
	public void testEdgeCase88712() throws Exception {

		gstrTCID = "88712";
		gstrTO = "Verify that user can be created with the right to reset password.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectUserResetPasswordOnly().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectUserResetPasswordOnly().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectUserResetPasswordOnly().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUsersList1.navigateToUsers().clickOnIncludeInactiveChkBox()
				.verCreateNewUserButtonIsNotPresent()
				.verPasswordLink(objUserdata.strNewUserName)
				.enterUsernameInSearchInputField(objUserdata.strNewUserName2)
				.clickSearchButton().verUserInList(objUserdata.strNewUserName2)
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton().verUserInList(objUserdata.strNewUserName1)
				.clickOnPasswordLink(objUserdata.strNewUserName1);

		objChangePassword1.clickOnResetYourPasswordText()
				.verChangePwdScreenWithClickHere(objUserdata.strNewUserName1,
						objUserdata.strFullName1)
				.clickOnHere()
				.switchTochangePwdFrame()
				.verChangePwdWindow()
				.changePassword(objUserdata.strNewPassword1,
						objUserdata.strNewPassword1)
				.verPasswordStatusScreenIsDisplayedNew().clickOnClose();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objLogin1.verifyInvalidUsernameAndPwdError();

		objLogin1.enterUserName(objUserdata.strNewUserName1)
				.enterPassword(objUserdata.strNewPassword1).clickLogin()
				.enterCurrentPassword(objUserdata.strNewPassword1)
				.enterNewPassword(objUserdata.strNewPassword1)
				.enterConfirmPassword(objUserdata.strNewPassword1)
				.clickSubmit();

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Enter data in all the fields and cancel the process of creating a user and verify that: a. The user is taken to the user list screen. b. The user is not created.
	'Date	 	 : 19-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                           Modified By
	'Date					                                                                       Name
	**********************************************************************************************************************/
	@Test(description = " Enter data in all the fields and cancel the process of creating a user and verify that: a. The user is taken to the user list screen. b. The user is not created.")
	public void testEdgeCase88718() throws Exception {

		gstrTCID = "88718";
		gstrTO = " Enter data in all the fields and cancel the process of creating a user and verify that: a. The user is taken to the user list screen. b. The user is not created.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickCancelButton()
				.verUserNotInList(objUserdata.strNewUserName);

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Verify that user with the right 'Update Status' for a resource and without 'Form-Do not participate in forms for resources' right receives the completed form sent to a user who has 'Update Status' right for a resource. 
	'Date	 	 : 19-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                           Modified By
	'Date					                                                                       Name
	**********************************************************************************************************************/
	@Test(description = "Verify that user with the right 'Update Status' for a resource and without 'Form-Do not participate in forms for resources' right receives the completed form sent to a user who has 'Update Status' right for a resource. ")
	public void testEdgeCase88708() throws Exception {

		gstrTCID = "88708";
		gstrTO = "Verify that user with the right 'Update Status' for a resource and without 'Form-Do not participate in forms for resources' right receives the completed form sent to a user who has 'Update Status' right for a resource. ";

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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
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
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.selectCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualResources)
				.clickOnNextButton().clickOnNextButton()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)

				.selResourceToFillOutForm(strResourceValue[0])

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
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();
		
		objRegionDefault1.selectFrame();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that the user with 'Associated With' right for a resource cannot 
	                   view the resource participating in the private event. 
	'Date 			: 22-Feb-2016 
	'Author 		: Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = " Verify that the user with 'Associated With' right for a resource cannot "
			+ "view the resource participating in the private event. ")
	public void testEdgeCase88658() throws Exception {

		gstrTCID = "88658";
		gstrTO = " Verify that the user with 'Associated With' right for a resource cannot view "
				+ "the resource participating in the private event. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Roles_data objRoles_data = new Roles_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	.clickOnReturnToStatusTypeList();
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println("1u " + objUser_data.strNewUserName);

		// Create user2
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println("2u " + objUser_data.strNewUserName1);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox();

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnSaveButton().verifyEventName(
				objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user with 'Update Status' right on the resource can view 
	                    the resources in the private event. 
	'Date 			: 23-Feb-2016 
	'Author 		: Renushree
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that user with 'Update Status' right on the resource can view "
			+ "the resources in the private event.")
	public void testEdgeCase88701() throws Exception {

		gstrTCID = "88701";
		gstrTO = "Verify that user with 'Update Status' right on the resource can view the resources"
				+ " in the private event.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Roles_data objRoles_data = new Roles_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println("1u " + objUser_data.strNewUserName);

		// Create user2
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickSaveButton();
			
		System.out.println("2u " + objUser_data.strNewUserName1);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox();

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnSaveButton().verifyEventName(
				objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Verify that user with the right 'Update Status' for a resource and 'Form-Do not participate in forms for resources' right does not receive the completed form sent to a user who has 'Update Status' right for a resource.  
	'Date	 	 : 19-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                           Modified By
	'Date					                                                                       Name
	**********************************************************************************************************************/
	@Test(description = "Verify that user with the right 'Update Status' for a resource and 'Form-Do not participate in forms for resources' right does not receive the completed form sent to a user who has 'Update Status' right for a resource. ")
	public void testEdgeCase88709() throws Exception {

		gstrTCID = "88709";
		gstrTO = "Verify that user with the right 'Update Status' for a resource and 'Form-Do not participate in forms for resources' right does not receive the completed form sent to a user who has 'Update Status' right for a resource. ";

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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectFormDoNotParticipateInFormsForResourcesOption().clickSaveButton();

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
				.selectCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualResources)
				.clickOnNextButton().clickOnNextButton()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)

				.selResourceToFillOutForm(strResourceValue[0])

				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		List<String> list = new ArrayList<String>(a1);
		
		if(a1.size() == 1){
			assertEquals(mainWindowHandle1, list.get(0));
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/*********************************************************************************************************************
	'Description : Verify that user with the right 'Update Status' for a resource and without 'Form-Do not participate in forms for resources' right receives the completed form sent to a user who has 'Update Status' right for a resource. 
	'Date	 	 : 19-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                           Modified By
	'Date					                                                                       Name
	**********************************************************************************************************************/
	@Test(description = "Verify that user with the right 'Update Status' for a resource and without 'Form-Do not participate in forms for resources' right receives the completed form sent to a user who has 'Update Status' right for a resource. ")
	public void testEdgeCase88657() throws Exception {

		gstrTCID = "88657";
		gstrTO = "Verify that user with the right 'Update Status' for a resource and without 'Form-Do not participate in forms for resources' right receives the completed form sent to a user who has 'Update Status' right for a resource. ";

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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
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
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.selectCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualResources)
				.clickOnNextButton().clickOnNextButton()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)

				.selResourceToFillOutForm(strResourceValue[0])

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
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();
		
		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Verify that user with the right 'Associate With' for a resource and 'Form-Do not participate in forms for resources' right does not receive the blank form sent to a user who has 'Associate With' right for a resource.   
	'Date	 	 : 24-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                           Modified By
	'Date					                                                                       Name
	**********************************************************************************************************************/
	@Test(description = "Verify that user with the right 'Associate With' for a resource and 'Form-Do not participate in forms for resources' right does not receive the blank form sent to a user who has 'Associate With' right for a resource. ")
	public void testEdgeCase88656() throws Exception {

		gstrTCID = "88656";
		gstrTO = "Verify that user with the right 'Associate With' for a resource and 'Form-Do not participate in forms for resources' right does not receive the blank form sent to a user who has 'Associate With' right for a resource. ";

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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectFormDoNotParticipateInFormsForResourcesOption().clickSaveButton();

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
				.selectCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualResources)
				.clickOnNextButton().clickOnNextButton()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)

				.selResourceToFillOutForm(strResourceValue[0])

				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		List<String> list = new ArrayList<String>(a1);
		
		if(a1.size() == 1){
			assertEquals(mainWindowHandle1, list.get(0));
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/*************************************************************************************
	'Description : Verify that user can be created by providing data in all the fields.  
	'Date	 	 : 3-Mar-2016
	'Author		 : Sandhya
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user can be created by providing data in all the fields.")
	public void testEdgeCase88054() throws Exception {

		gstrTCID = "88054";
		gstrTO = "Verify that user can be created by providing data in all the fields.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		UserFunctions objUserFunctions1 = new UserFunctions(this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);
		UpdateUserInfo objUpdateUserInfo1 = new UpdateUserInfo(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.verifyUserListPageIsDisplayed()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.verUserInList(objUserdata.strNewUserName)
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strFullName, objUserdata.strOrganization)
				.verNeverTextIsDisplayed(objUserdata.strNewUserName);

		objNavigationToSubmenus1.navigateToUsersInRegionalInfo();

		objUserFunctions1.enterUsernameInSearchInputField(
				objUserdata.strNewUserName).clickSearchButton();

		objRegionalInfo1.verUserDetailsInUserListPgeOfRegionalInfo(
				objUserdata.strNewUserName, objUserdata.strFullName,
				objUserdata.strOrganization, objUserdata.strPhone,
				objUserdata.strPrimaryMailId, objUserdata.strPrimaryMailId);
		objLogin1.clickLogOut();

		objLogin1.loginToApplicationNew(objUserdata.strNewUserName,
				objUserdata.strUserPwd);
		objLogin1.verifySetUpYourPasswordPage()
				.enterCurrentPassword(objUserdata.strUserPwd)
				.enterNewPassword(objLogindata.strPassword)
				.enterConfirmPassword(objLogindata.strPassword)
				.clickSubmit()
				.verifySecurityQuestionAndAnswerPageAndClickOnCancel();

		objRegionDefault1.selectFrame().verifyRegionDefaultPage()
				.verifyUserNameInFooter(objUserdata.strNewUserName);

		objNavigationToSubmenus1.navigateToUsersInfoInPreferences();

		objUpdateUserInfo1.verUpdateUserInfoIsDisplayed()
				.verifyUserDetailsAreRetrieved(objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId);

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user with Web Service right can be created. 
	'Date	 	 : 25-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with Web Service right can be created.")
	public void testEdgeCase88636() throws Exception {

		gstrTCID = "88636";
		gstrTO = "Verify that user with Web Service right can be created.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		RegionalInfo objRegionalInfo = new RegionalInfo(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		UserFunctions objUserFunctions = new UserFunctions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UserFunctions objUserFunctions1 = new UserFunctions(this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

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
						objUserdata.strPrimaryMailId).selectWebServiceChkBox()
				.selectFirstRole().clickSaveButton();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strFullName, objUserdata.strOrganization);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectUserViewUserInformationOnlyOption().clickSaveButton();

		objNavigationToSubmenus.navigateToUsersInRegionalInfo();

		objUserFunctions.enterUsernameInSearchInputField(
				objUserdata.strNewUserName).clickSearchButton();

		objRegionalInfo.verUserDetailsInUserListPgeOfRegionalInfo(
				objUserdata.strNewUserName, objUserdata.strFullName,
				objUserdata.strOrganization, objUserdata.strPhone,
				objUserdata.strPrimaryMailId, objUserdata.strPrimaryMailId);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objUsersList1.navigateToUsers()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.verUserNotInList(objUserdata.strNewUserName);

		objNavigationToSubmenus1.navigateToUsersInRegionalInfo();

		objUserFunctions1.enterUsernameInSearchInputField(
				objUserdata.strNewUserName).clickSearchButton();

		objRegionalInfo1.verUserNotListedInUserListPgeOfRegionalInfo(
				objUserdata.strNewUserName, objUserdata.strFullName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user with the right 'Associate With' for a resource and with a role to view the status types associated with the resource does not recive the status update prompt when the status expires.
	'Date	 	 : 15-march-2016
	'Author		 : Sandhya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that user with the right 'Associate With' for a resource and with a role to view the status types associated with the resource does not recive the status update prompt when the status expires.")
	public void testEdgeCase88655() throws Exception {

		gstrTCID = "88655";
		gstrTO = " Verify that user with the right 'Associate With' for a resource and with a role to view the status types associated with the resource does not recive the status update prompt when the status expires.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new	StatusTypes_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new	SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new	StatusTypeList(this.driver1);
		ResourceType objResourceType = new	ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus =	new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);		
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 =	new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_page1 = new UpdateStatus(this.driver1);
		
		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strstatusesValues[] = new String[1];

		objLogin.loginToApplication(objTest_data.strAdminUser, objTest_data.strAdminUserPwd);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased status types creation

		objStatusTypeList.createStatusTypeWithExpirationTime(objStatuTypes_data.strNumberStatusType,
		                                                     objStatuTypes_data.strNSTStatusTypeName,
		                                                     objStatuTypes_data.strStatusDescription,
		                                                     objStatuTypes_data.strStatusExpirationTime);
		
		strstatusTypeValues[0] = objStatusTypeList.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(objStatuTypes_data.strMultiStatusType,
		                                   objStatuTypes_data.strMSTStatusTypeName,
		                                   objStatuTypes_data.strStatusDescription)
		                 .clickOnCreateNewStatus()
		                 .enterStatusName(objStatuTypes_data.strStatusNameInMulti)
		                 .selectEventExpirationOption()
		                 .selectExpirationMinute(objStatusTypes_data.strStatusExpirationTime)
		                 .clickOnSaveButton()
		                 .verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithExpirationTime(objStatuTypes_data.strTextStatusType,
		                                                     objStatuTypes_data.strTSTStatusTypeName,
		                                                     objStatuTypes_data.strStatusDescription,
		                                                     objStatuTypes_data.strStatusExpirationTime);
		strstatusTypeValues[2] = objStatusTypeList.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithExpirationTime(objStatuTypes_data.strSaturationScoreStatusType,
		                                                     objStatuTypes_data.strSSTStatusTypeName,
		                                                     objStatuTypes_data.strStatusDescription,
		                                                     objStatuTypes_data.strStatusExpirationTime);
		strstatusTypeValues[3] = objStatusTypeList.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithExpirationTime(objStatuTypes_data.strNedocCalculationStatusType,
                                                             objStatuTypes_data.strNDSTStatusTypeName,
                                                             objStatuTypes_data.strStatusDescription,
                                                             objStatuTypes_data.strStatusExpirationTime);
		strstatusTypeValues[4] = objStatusTypeList.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);
	
		objStatusTypeList.createStatusTypeWithExpirationTime(objStatuTypes_data.strDateStatusType,
		                                                     objStatuTypes_data.strDateStatusTypeName,
		                                                     objStatuTypes_data.strStatusDescription,
		                                                     objStatuTypes_data.strStatusExpirationTime);
		strstatusTypeValues[5] = objStatusTypeList.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation

		objResourceType.navigateToResourceTypePage()
		               .createResourceType(objResourceType_data.strResourceTypeName,strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation

		objResource.navigateToResourceListPage()
		           .createResource(objResource_data.strResourceName,
		        		           objResource_data.strResourceAbbrivation,
		        		           objResourceType_data.strResourceTypeName,
		        		           objResource_data.strStandardResourceTypename,
		        		           objResource_data.strResourceFirstName,
		        		           objResource_data.strResourceLastName);

		strResourceValue[0] =	objResource.getResourceValue(objResource_data.strResourceName);

		// create role

		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		System.out.println(strRoleValue[0]);
		
		String[] strStatusTypeNames = {	objStatusTypes_data.strDateStatusTypeName,
				                        objStatusTypes_data.strMSTStatusTypeName,
				                        objStatusTypes_data.strNDSTStatusTypeName,
				                        objStatusTypes_data.strNSTStatusTypeName,
				                        objStatusTypes_data.strSSTStatusTypeName,
				                        objStatusTypes_data.strTSTStatusTypeName };
		
		// Create views
		
		objNavigationToSubMenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, 
				                objView_data.strViewDesc, 
				                objResource_data.strResourceName, 
				                strStatusTypeNames);

		// Create User

		objNavigationToSubMenus.navigateToUsers();

		objUsersList.clickCreateNewUserButton()
		            .enterUserDetails(objUser_data.strNewUserName,
                                      objUser_data.strNewPassword,
                                      objUser_data.strFullName)
                    .selectRoleCheckBox(strRoleValue)
                    .selectAssosciateResourceRight(objResource_data.strResourceName)                    
				    .clickAdvancedOptionAndExpand()
				    .selectMustUpdateOverdueStatusOption()
				    .clickSaveButton()
				    .clickCreateNewUserButton()
				    .enterUserDetails(objUser_data.strNewUserName1,
				                      objUser_data.strNewPassword1,
				                      objUser_data.strFullName1)
				    .selectRoleCheckBox(strRoleValue)
				    .selectUpdateStatusOfResource(objResource_data.strResourceName)				   
				    .clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1, objUser_data.strNewPassword1);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnViewMenu()
		                       .navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_page1.clickOnSelectAll();

		objUpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[1], strstatusesValues[0]);

		objUpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strValueForTST);

		objUpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[3], objView_data.strValueForSST);

		objUpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[4], objView_data.strValueForNDST);

		objUpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],	objView_data.strDateUpdateValue);

		objUpdateStatus_page1.clickOnSaveButton();

		String strUpdatedVal[] ={ objView_data.strValueForUpdate,
                            	  objStatusTypes_data.strStatusNameInMulti,
                            	  objView_data.strValueForTST,
                            	  objView_data.strUpdatedValForSST,
                            	  objView_data.strNEDOCValue,
                            	  objView_data.strDateUpdateValue };

		for (int i = 0; i <	strstatusTypeValues.length; i++) 
		{

			objViewsList1.verifyUpdatedValue(strResourceValue[0], strstatusTypeValues[i], strUpdatedVal[i]);
		}

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);

		objRegionDefault1.selectFrame()
 		                .verifyUpdateStatusPageNotDisplayed();

		// Wait for 5 min

		TimeUnit.MINUTES.sleep(6);

		objRegionDefault1.verifyUpdateStatusPageNotDisplayed();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
