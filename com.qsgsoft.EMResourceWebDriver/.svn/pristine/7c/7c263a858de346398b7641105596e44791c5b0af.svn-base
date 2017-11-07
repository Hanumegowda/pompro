package requirementGroup.Forms;

import static org.testng.Assert.assertTrue;

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
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.FormConfiguration;
import lib.page.FormList;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayReceiveBlankForm extends TestNG_UI_EXTENSIONS{

	public HappyDayReceiveBlankForm() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	'Description : Create a V3 form to be sent to others and completed form to be received by Users and Resources, activate and fill out the form and verify that the completed form displays correct data. 
	'Precondition:
	'Date	 	 : 22-Dec-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Configure a form to be activated on shift time, select resource RS for filling out the form and verify that the form can be filled out by a user with 'Associated with' right on the resource ")
	public void testHappyDay152318() throws Exception {

		gstrTCID = "152318";
		gstrTO = "Configure a form to be activated on shift time, select resource RS for filling out the form and verify that the form can be filled out by a user with 'Associated with' right on the resource ";

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
		BlankForm objBlankForm = new BlankForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		
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
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

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
						objUserdata.strPrimaryMailId).selectFirstRole()
						.deselectAssosciatedWithRight()
						.selectViewResourceCheckBox(objResource_data.strResourceName)
						.selectAssosciateResourceRight(objResource_data.strResourceName)
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
				.verCompletedFormDeliveryIsDisabled(objFormConfiguration_data.strTemplateDefine)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton();
				
				
				
		String strAppTime = objFormConfiguration.getApplicationTime();
		
		System.out.println(strAppTime);
		
		objFormConfiguration.selectShift(objFormConfiguration_data.strShift1);
		
		String strShiftTime = objFormConfiguration.selectTimeByAddingFourMins(strAppTime,
															objFormConfiguration_data.strShift1);
		
		System.out.println(strShiftTime);
		
		objFormConfiguration.clickOnNextButton()
							.clickOnNextButton()
							.selectResources(objResource_data.strResourceName)
							.clickOnNextButton()
							.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
							.clickOnNextButton()
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

		Thread.sleep(180000);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						 objUserdata.strNewPassword);
		
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
		objBlankForm.switchToFormFrame()
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		Thread.sleep(3000);
	
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
						 	objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+" for "+objResource_data.strResourceName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strNumericAnswer + "| "+objFormConfiguration_data.strLabelName1+": "+objBlankFormData.strTextAnswer;
		
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWith2Quest(
						objUserdata.strFullName,
						objResource_data.strResourceName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer); 
				
		objRegionDefault1.selectFrame();
		objRegionDefault1.verWebNotificationframe();
		objRegionDefault1.verWebNotificationMsgForForms(
				objFormConfiguration_data.strFormName, strMsg);					
	
		Thread.sleep(5000);
		objRegionDefault1.selectFrame();
		Thread.sleep(3000);
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
	'Description : Send a blank form to a single resource RS, where a single user'U1' has 'Associated with' 
					right on the resource and verify that user U1 can fill out the form received.
	'Date	 	 : 13-Jan-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Send a blank form to a single resource RS, where a single user'U1' has 'Associated with' "
			+ "				right on the resource and verify that user U1 can fill out the form received.")
	public void testHappyDay152316() throws Exception {

		gstrTCID = "152316";
		gstrTO = "Send a blank form to a single resource RS, where a single user'U1' has 'Associated with' "
				+ "right on the resource and verify that user U1 can fill out the form received.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
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
		BlankForm objBlankForm1 = new BlankForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectAssosciateResourceRight(
						objResource_data.strResourceName)
				.selectViewResourceCheckBox(
						objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
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
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(
						objUserdata.strNewUserName)
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
				.selResourceToFillOutForm(strResourceValue[0])
				.clickOnActivateForm();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(8000);
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
							objUserdata.strNewUserName2)
						.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		System.out.println(objUserdata.strNewUserName2);
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName2,
							objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName1 + " at "
//				+ objResource_data.strResourceName + "\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strNumericAnswer + "";

		String strMsg = objRegionDefault1
				.getWebNotificationWhenResourceFillsForm(
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
				.clickAcknowledgeAllForms().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBodyWithResource(
				objUserdata.strFullName1, objLogindata.strRegionName,objResource_data.strResourceName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBodyWithResource(
				objUserdata.strFullName1, objLogindata.strRegionName,objResource_data.strResourceName,
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
	
	/****************************************************************************************************
	'Description : Verify that user cannot complete the blank form without providing data for required fields
	'Date	 	 : 09-Feb-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that user cannot complete the blank form without providing data for required fields")
	public void testHappyDay152582() throws Exception {

		gstrTCID = "152582";
		gstrTO = "Verify that user cannot complete the blank form without providing data for required fields";

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
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);

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
				.clickSaveButton();

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
				.clickOnAddToSummary()
				.selectRequiredCheckBox()
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
		objBlankForm1
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.clickOnSave()
//				.verMandatoryQuestionCantBeSavedWithoutAnswering(objFormConfiguration_data.strLabelName)
				.verifyRequiedTextForMandatoryQuestion(objFormConfiguration_data.strLabelName)
				.clickOnComplete()
				.verMandatoryQuestionCantBeSavedWithoutAnswering(objFormConfiguration_data.strLabelName);
		
		objBlankForm1.enterAnswerInField(objFormConfiguration_data.strLabelName,
										 objBlankFormData.strTextAnswer)
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
//				+ objBlankFormData.strTextAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer);
		
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
	'Description : Verify that multiple forms popped for a single user can be filled. 
	'Precondition:
	'Date	 	 : 12-Feb-2015
	'Author		 : Deepa
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that multiple forms popped for a single user can be filled.")
	public void testHappyDay152872() throws Exception {

		gstrTCID = "152872";
		gstrTO = "Verify that multiple forms popped for a single user can be filled.";

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
		BlankFormData objBlankFormData = new BlankFormData();
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		
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
				.selectFormUserMayActivateFormsOption()
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
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		
		Thread.sleep(10000);

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

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName)
				.clickOnActivateForm();
		
		objLogin1.clickLogOut();

		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.clickOnConfigureForm();
		
		objFormConfiguration
						.verFormConfigurePage()
						.createNewFormTempltete()
						.entireTittleName_DescriptionName(
								objFormConfiguration_data.strFormName2,
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
						
		objFormConfiguration
		.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName2);

		mainWindowHandle = driver.getWindowHandle();
		
		a = driver.getWindowHandles();
		ite = a.iterator();
		
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
		
		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName2)
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
				driver1.navigate().refresh();
			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName,objBlankFormData.strNumericAnswer)
					.clickOnSave();
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		Thread.sleep(3000);
		a1 = driver1.getWindowHandles();
		ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
				driver1.navigate().refresh();
			}
		}
	
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName2)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName,objBlankFormData.strNumericAnswer)
					.clickOnSave();
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/********************************************************************************************************
	'Description : Verify that user can 'Save' the popped up blank forms without filling the required fields.
	'Date	 	 : 25-Feb-2015
	'Author		 : Pallavi
	'--------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                  Modified By
	'Date					                                                              Name
	*********************************************************************************************************/
	@Test(description = "Verify that user can 'Save' the popped up blank forms without filling the required fields.")
	public void testHappyDay154261() throws Exception {

		gstrTCID = "154261";
		gstrTO = "Verify that user can 'Save' the popped up blank forms without filling the required fields.";

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
		FormList objFormList1 = new FormList(this.driver1);

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
						"", "","", "","", objUserdata.strPrimaryMailId,
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

		Thread.sleep(5000);
		
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
						    .selectRequiredCheckBox()
						    .clickOnDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strDateQuestion)
						    .enterLabelName(objFormConfiguration_data.strLabelName3)
						    .clickOnAddToSummary()
						    .selectRequiredCheckBox()
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
		
	System.out.println("-----------Precondtion ends and test execution starts-----------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		Thread.sleep(2000);
		
		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);
		
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
					.enterAnswerInField(objFormConfiguration_data.strLabelName,
										objBlankFormData.strTextAnswer)
					.enterAnswerInTextAreaField(objBlankFormData.strTextAreaAnswer)
					.clickOnSave();
					
		Thread.sleep(30000);
		
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
				
                .enterAnswerInField(objFormConfiguration_data.strLabelName2,
										objBlankFormData.strNumericAnswer)
				.enterAnswerInDateField(objBlankFormData.strCurrentDate);
		
		objBlankForm.clickOnComplete();
		
		Thread.sleep(4000);
		
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle2);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName1,
						 		 objUserdata.strNewPassword);
		
//		String strWebNotificationMsg = "Submitted by "+objUserdata.strFullName +
//										"\nSummary: | "
//										+ objFormConfiguration_data.strLabelName + ": "+ objBlankFormData.strTextAnswer + "| "
//										+ objFormConfiguration_data.strLabelName1 + ": "+ objBlankFormData.strTextAreaAnswer + "| "
//										+ objFormConfiguration_data.strLabelName2 + ": "+ objBlankFormData.strNumericAnswer + "| "
//										+ objFormConfiguration_data.strLabelName3 + ": "+ objBlankFormData.strCurrentDate;
		
		String strWebNotificationMsg = objRegionDefault1
				.getWebNotificationForFourQuestionnaire(
						objUserdata.strFullName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAreaAnswer,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName3,
						objBlankFormData.strCurrentDate);
		
		Thread.sleep(5000);
        
        objRegionDefault1.selectFrame()
                       	 .verWebNotificationframe()
                         .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                        		 						strWebNotificationMsg)
                         .clickAcknowledgeAllForms()
                         .selectFrame()
                         .switchToDefaultFrame()
                         .selectFrame();

        objLogin1.clickLogOut();
        
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that answers filled by user are auto-saved after every 5min. 
	'Precondition:
	'Date	 	 : 12-Mar-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that answers filled by user are auto-saved after every 5min.")
	public void testHappyDay154259() throws Exception {

		gstrTCID = "154259";
		gstrTO = "Verify that answers filled by user are auto-saved after every 5min.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		Date_Time_settings objDTs = new Date_Time_settings();
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
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
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
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton();

		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId)
		.selectFirstRole()
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
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);Thread.sleep(2000);

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

		objRegionDefault1.selectFrame();Thread.sleep(5000);

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		Thread.sleep(10000);
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer)
					.clickOnGrpNameVirtually(objFormConfiguration_data.strGroupName);
		
		//Wait for 5 minutes
		TimeUnit.MINUTES.sleep(5);
//		TimeUnit.SECONDS.sleep(45);
		String strTimeSaved = objDTs.timeNow("h:mm aa");
		strTimeSaved = strTimeSaved.toLowerCase();
		objBlankForm.verifyAutoSavedAndSaveTextAfter5Mins(strTimeSaved);
		driver1.close();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objNavigationToSubmenus1.navigateToFormList();
		
		objActivateForms1.clickOnFillOut(objFormConfiguration_data.strFormName);Thread.sleep(5000);
		
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
					.verifyEnteredAnswerIsRetainedInField(
							objFormConfiguration_data.strLabelName,
							objBlankFormData.strNumericAnswer)
					.verifyEnteredAnswerIsRetainedInField(
							objFormConfiguration_data.strLabelName1,
							objBlankFormData.strTextAnswer);
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(objUserdata.strNewUserName2)
					   .clickOnDispatchForm();
		
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName2,
						 	objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//						+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//						+ ": " + objBlankFormData.strNumericAnswer + "| "
//						+ objFormConfiguration_data.strLabelName1 + ": "
//						+ objBlankFormData.strTextAnswer;
		
		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
		
		objRegionDefault1
				.selectFrame().switchToDefaultFrame().selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
						strMsg)
				.clickAcknowledgeAllForms()
				.selectFrame();

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/****************************************************************************************************
	'Description : Send a blank form to a single resource RS, where a single user (user A) has 'Update' right 
						on the resource and verify that user A can fill out the form received.
	'Date	 	 : 19-Mar-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = " Send a blank form to a single resource RS, where a single user (user A) has 'Update' "
			+ "right on the resource and verify that user A can fill out the form received.")
	public void testHappyDay155953() throws Exception {

		gstrTCID = "155953";
		gstrTO = " Send a blank form to a single resource RS, where a single user (user A) has 'Update' right "
				+ "on the resource and verify that user A can fill out the form received.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
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
		BlankForm objBlankForm1 = new BlankForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();
		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
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
				.clickSaveButton();

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
				.clickOnNextButton().clickOnNextButton()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
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
				.selResourceToFillOutForm(strResourceValue[0])
				.clickOnActivateForm();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(8000);
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

		System.out.println(objUserdata.strNewUserName2);
		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName1 + " at "
//				+ objResource_data.strResourceName + "\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strNumericAnswer + "";

		String strMsg = objRegionDefault1
				.getWebNotificationWhenResourceFillsForm(
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
				.clickAcknowledgeAllForms().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBodyWithResource(
				objUserdata.strFullName1, objLogindata.strRegionName,objResource_data.strResourceName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBodyWithResource(
				objUserdata.strFullName1, objLogindata.strRegionName,objResource_data.strResourceName,
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
	
	//Bug TC need to modify
	/*************************************************************************************
	'Description : Verify that multiple forms popped up at status change can be filled by single user.
	'Precondition:
	'Date	 	 : 27-Mar-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that multiple forms popped up at status change can be filled by single user.")
	public void testHappyDay152873() throws Exception {

		gstrTCID = "152873";
		gstrTO = " Verify that multiple forms popped up at status change can be filled by single user.";

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
		View_data objView_data = new View_data();
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_page1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		BlankFormData objBlankFormData = new BlankFormData();

		String strStatusTypeValues[] = new String[2];
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

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
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
		String strStatusTypeNames[] = {objStatusTypes_data.strSSTStatusTypeName,objStatusTypes_data.strNSTStatusTypeName };
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList
//				.selectStatusType(objStatusTypes_data.strSSTStatusTypeName)
//				.selectStatusType(objStatusTypes_data.strNSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
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
						objFormConfiguration_data.strAsCertainStatusChanges)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
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
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);
		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.switchToDefaultFrame().selectFrame();
		
		Thread.sleep(1000);

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName2,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strAsCertainStatusChanges)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selectStatusTypes(objStatusTypes_data.strNSTStatusTypeName)
				.clickOnSelectStatusTypeButton()
				.selectWhenToSendOption(
						objFormConfiguration_data.strWheneverStatusIsAbove)
				.enterStatusTypeValue(
						objFormConfiguration_data.strStatusTypeValue)
				.clickOnSaveConfiguration()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnSaveOfFormSecuritySetting();

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName2);
		
		Thread.sleep(10000);

		mainWindowHandle = driver.getWindowHandle();

		a = driver.getWindowHandles();
		ite = a.iterator();

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

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus_page1.selectStatusTypes(strStatusTypeValues[0]);
		
		objUpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValues[0],
				objView_data.strValueForSST);

		objUpdateStatus_page1.clickOnSaveButton();

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
						objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm.clickOnComplete();
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_page1.selectStatusTypes(strStatusTypeValues[1]);
		
		objUpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[1],
				objFormConfiguration_data.strValueForUpdate2);

		objUpdateStatus_page1.clickOnSaveButton();
		
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

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName2)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strNumericAnswer3).clickOnSave();

		objBlankForm.clickOnComplete();

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objBlankFormData.strNumericAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);
		
//		String strMsg1 = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName1
//				+ ": " + objBlankFormData.strNumericAnswer3;

		String strMsg1 = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strNumericAnswer3);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMultipleMsgformsForms(
						objFormConfiguration_data.strFormName2, strMsg1)
				.verWebNotificationMultipleMsgformsForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms();
		Thread.sleep(2000);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions
				.getFormMailBodyWithResource(objUserdata.strFullName,
						objLogindata.strRegionName,
						objResource_data.strResourceName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);

		String strMsgBody1 = objMailVerificationFunctions
				.getFormPagerBodyWithResource(objUserdata.strFullName,
						objLogindata.strRegionName,
						objResource_data.strResourceName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strLabelValue);

		String strMsgBody2 = objMailVerificationFunctions
				.getFormMailBodyWithResource(objUserdata.strFullName,
						objLogindata.strRegionName,
						objResource_data.strResourceName,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strNumericAnswer3);

		String strMsgBody3 = objMailVerificationFunctions
				.getFormPagerBodyWithResource(objUserdata.strFullName,
						objLogindata.strRegionName,
						objResource_data.strResourceName,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strNumericAnswer3);

		String strSubject = objFormConfiguration_data.strFormName;
		String strSubject1 = objFormConfiguration_data.strFormName2;

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

		blnMsg1 = false;
		blnMsg2 = false;
		blnMsg3 = false;

		objMailVerificationFunctions.NavToInbox(strSubject1);

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
}