package requirementGroup.Reports;

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

public class EdgeCaseFormSummaryReport extends TestNG_UI_EXTENSIONS {

	public EdgeCaseFormSummaryReport() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/************************************************************************************************************
	'Description : Verify that appropriate error message is displayed when future end date is selected
	'Precondition: None
	'Date	 	 : 20/04/2015
	'Author		 : Renushree 
	'------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************************/
	@Test(description = "Verify that appropriate error message is displayed when future end date is selected.")
	public void testEdgeCase142714() throws Exception {

		gstrTCID = "142714";
		gstrTO = "Verify that appropriate error message is displayed when future end date is selected.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
		Date_Time_settings objDts = new Date_Time_settings();

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
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Report objReport1 = new Report(this.driver1);

		System.out.println("-----Precondtion execution starts------");

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
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectReportformDetail()
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
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

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
		
		String strFutureStartDate = objDts.AddDaytoExistingDate(strStartDate, 1, "MM/dd/yyyy");

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
				.clickOnFillForm(objFormConfiguration_data.strFormName);

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

		String strActivationTime = "" + strActivationDate + " " + strDate[2];
		System.out.println("Activation time is : " + strActivationTime);

		String mainWindowHandle1 = driver1.getWindowHandle();

		objBlankForm.switchToNewWin()
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		Thread.sleep(7000);
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();

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

		String strFutureEndDate = objDts.AddDaytoExistingDate(strEndDate, 1, "MM/dd/yyyy");
		
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objBlankFormData.strNumericAnswer + "| "
//				+ objFormConfiguration_data.strLabelName1 + ": "
//				+ objBlankFormData.strTextAnswer;

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
				.clickAcknowledgeAllForms().selectFrame();

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		System.out.println("Start Date: " + strFutureStartDate);
		System.out.println("End Date: " + strFutureEndDate);

		objReport1.clickOnFormSummary().verifyFormSummaryReportPage()
				.enterReportStartDate(strFutureStartDate)
				.enterReportEndDate(strFutureEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.clickOnGenerateReportBtn()
				.verErrorWhenFutureStartAndEndDateSelected();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/************************************************************************************************************
	'Description : Verify that appropriate error message is displayed when future start date is selected
	'Date	 	 : 20-Apr-2015
	'Author		 : Pallavi
	'------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************************/
	@Test(description = "Verify that appropriate error message is displayed when future start date is selected")
	public void testEdgeCase142713() throws Exception {

		gstrTCID = "142713";
		gstrTO = "Verify that appropriate error message is displayed when future start date is selected";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
		Date_Time_settings objDts = new Date_Time_settings();

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
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Report objReport1 = new Report(this.driver1);

		System.out.println("-----Precondtion execution starts------");

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName2)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

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
		
		String strFutureStartDate = objDts.AddDaytoExistingDate(strStartDate, 1, "MM/dd/yyyy");

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

		objActivateForms1
					.clickOnSendForm(objFormConfiguration_data.strFormName)
					.selUserToFillOutForm(objUserdata.strNewUserName)
					.clickOnActivateForm();
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		objBlankForm.switchToNewWin()
					.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName,
							objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,
							objBlankFormData.strTextAnswer)
					.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName2)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();

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

		String strFutureEndDate = objDts.AddDaytoExistingDate(strEndDate, 1, "MM/dd/yyyy");
		
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
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
		
		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms()
				.selectFrame();

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		System.out.println("Start Date: " + strFutureStartDate);
		System.out.println("End Date: " + strFutureEndDate);

		objReport1.clickOnFormSummary()
				  .verifyFormSummaryReportPage()
				  .enterReportStartDate(strFutureStartDate)
				  .enterReportEndDate(strFutureEndDate)
				  .selForm(objFormConfiguration_data.strFormName)
				  .clickOnGenerateReportBtn()
				  .verErrorWhenFutureStartAndEndDateSelected();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
    'Description :Verify that appropriate error message is displayed when form is not selected while generating the report.
    'Date        :20-Apr-2015
    'Author      :Anitha
    '---------------------------------------------------------------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    **********************************************************************************************************************/
	@Test(description = "Verify that appropriate error message is displayed when form is not selected while generating the report.")
	public void testEdgeCase142715() throws Exception {

		gstrTCID = "142715";
		gstrTO = "Verify that appropriate error message is displayed when form is not selected while generating the report.";

		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		Report objReport1 = new Report(this.driver1);

		System.out.println("-----Precondtion execution starts------");

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
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
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.selectCarteBlancheChkBoxInSecurityPge(
						objUserdata.strNewUserName1)
				.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

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

	System.out.println("--------Precondition ends and test execution starts-------");

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
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		Thread.sleep(8000);
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();

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
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);

		objReport1.clickOnFormSummary().verifyFormSummaryReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.clickOnGenerateReportBtn()
				.verifyErrorMessageInFormSummaryPage()
				.clickOnCancelBtn()
				.verifyFormReportsMenuPage();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user can generate 'Form summary report' for a New form configured 
					selecting Form activation as "Pre-defined shifts"
	'Precondition:
	'Date	 	 : 21-Apr-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user can generate 'Form summary report' for a New form configured selecting "
			+ "Form activation as 'Pre-defined shifts'")
	public void testEdgeCase145898() throws Exception {

		gstrTCID = "145898";
		gstrTO = "Verify that user can generate 'Form summary report' for a New form configured selecting "
				+ "Form activation as 'Pre-defined shifts'";

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
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
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

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectReportformDetail()
				.clickSaveButton();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(objFormConfiguration_data.strPredifinedShifts)
				.verCompletedFormDeliveryIsDisabled(objFormConfiguration_data.strTemplateDefine)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton();
		
		String strAppTime = objFormConfiguration.getApplicationTime();
		
		System.out.println(strAppTime);
		
		objFormConfiguration.selectShift(objFormConfiguration_data.strShift1);
		
		String strActivationShiftTime = objFormConfiguration.selectTimeByAddingFourMins(strAppTime,
															objFormConfiguration_data.strShift1);
		
		objFormConfiguration.clickOnNextButton()
							.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
							.clickOnNextButton()
							.clickOnNextButton()
							.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
							.clickOnNextButton()
							.selectRunReportInSecurityPageForAsCertainStatsChangs(objUserdata.strNewUserName1)
							.clickOnSaveOfFormSecuritySetting();
		
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
		
		//Waiting for 3 minutes for form to get activated at specified time
		System.out.println("3 mins wait started"); 
		TimeUnit.MINUTES.sleep(3);
		System.out.println("3 mins wait completed");
		
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
		
		String strActivationTime = strActivationDate + " " + strActivationShiftTime;
		System.out.println("Activatio Date: " + strActivationDate);
		Thread.sleep(2000);

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
		Thread.sleep(3000);
		objBlankForm.clickOnComplete();
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
		
		String strFilledOutDate = strEndDate;
		String strCompletedTime = strDate1[2];
		System.out.println("Completed Time: " + strCompletedTime);
		Thread.sleep(5000);
		
		objFormConfiguration1.verAppTimeIsGreaterOrEqualToTimeProvided(strCompletedTime, strActivationShiftTime);
		
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
 		Thread.sleep(3000);
		
 		objRegionDefault1.switchToDefaultFrame().selectFrame();
		Thread.sleep(2000);
        
        objLinksAtTopRightCorners1.clickOnRefresh();
        
		Thread.sleep(2000);
		
		String strApplicationDate2 = objEventManagement1.getApplicationTimeWithCSTCDT();

		String[] strDate2 = strApplicationDate2.split(" ");
		String strAcknowledgedDate = "";
		int intDate2 = Integer.parseInt(strDate2[0]);
		if(intDate2 == intCurrentDate){
			strAcknowledgedDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if(intDate2 < intCurrentDate){
				strAcknowledgedDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			}
			else {
				strAcknowledgedDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		
		String strAcknowledgedTime = strDate2[2] + " " + strDate2[3];
		System.out.println("Acknowledged Time: " + strAcknowledgedTime);
		Thread.sleep(5000);
        
		String strFirstRow = "Form Summary Report for "
				+ objFormConfiguration_data.strFormName + " between "
				+ strStartDate + " " + strDate[3] + " and " + strEndDate + " " + strDate1[3];
		String[] arrForm = { strFirstRow };

		String[] strHeaderNames = ArrayUtils
				.addAll(objReport_data.strFormSummaryReport);

		String[] strAnswers = { "system", strActivationDate,
				strActivationTime,objUserdata.strFullName+" ("+ objUserdata.strNewUserName+")", "",
				strFilledOutDate, strCompletedTime,
				objUserdata.strFullName1+" ("+objUserdata.strNewUserName1+")", objUserdata.strFullName1+" ("+objUserdata.strNewUserName1+")",
				strAcknowledgedDate, strAcknowledgedTime, "", "", "" };
		
        objNavigationToSubmenus1.navigateToFormReport();
        
        System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);

		objReport1.clickOnFormSummary()
				  .verifyFormSummaryReportPage()
				  .enterReportStartDate(strStartDate)
				  .enterReportEndDate(strEndDate)
				  .selForm(objFormConfiguration_data.strFormName)
				  .clickOnGenerateReportBtn();

		Thread.sleep(5000);
		
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

		for (intCount = 1; intCount <= arrForm.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Summary Report", 1,
					intCount, strDownloadName1);
			assertEquals(arrForm[intCount - 1], strValue);
		} 
		
		String[] strValues = strAnswers;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			System.out.println("intCount value: " + intCount);
			if (intCount == 3 || intCount == 7 || intCount == 11) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 3, intCount, strDownloadName1);
				String strTime = strValues[intCount - 1];
				if(intCount!=11 && intCount!=7){
					String[] strDateTime = strValues[intCount - 1].split(" ");
					strTime = strDateTime[1];
				}
				strTime = objDts.converDateFormat(strTime, "hh:mm", "HH:mm");
				String strTime1 = objDts
						.addTimetoExisting(strTime, -1, "HH:mm");
				String strTime2 = objDts.addTimetoExisting(strTime, 1, "HH:mm");
				if (intCount == 11) {
					String strTimeAndTiemZone = strTime + " " + strDate2[3];
					String strTimeAndTiemZone1 = strTime1 + " " + strDate2[3];
					String strTimeAndTiemZone2 = strTime2 + " " + strDate2[3];
					assertTrue(strValue.contains(strTimeAndTiemZone)
							|| strValue.contains(strTimeAndTiemZone1)
							|| strValue.contains(strTimeAndTiemZone2));
				} else {
					assertTrue(strValue.contains(strTime)
							|| strValue.contains(strTime1)
							|| strValue.contains(strTime2));
				}
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);
			} else if (intCount == 2 || intCount == 6 || intCount == 10) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 3, intCount, strDownloadName1);
				assertTrue(strValue.contains(strValues[intCount - 1]));
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);
			} else {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Form Summary Report",
						3, intCount, strDownloadName1);
				assertEquals(strValues[intCount - 1], strValue);
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);
			}
		}

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************
	'Description : Verify that user can generate 'Form summary report' for a New form configured selecting Form activation as "As certain changes"
	'Date	 	 : 21-Apr-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that user can generate 'Form summary report' for a New form configured selecting Form activation as As certain changes")
	public void testEdgeCase145897() throws Exception {
		
		gstrTCID = "145897";
		gstrTO = "Verify that user can generate 'Form summary report' for a New form configured selecting Form activation as As certain changes";

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
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
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
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

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

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strNDSTStatusTypeName);
		
//		objViewsList.clickCreateNewViewButton()
//					.enterViewName(objView_data.strViewName)
//					.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strNDSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//					.clickOnSaveOfCreateNewView();

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
				.selectFormUserMayActivateFormsOption()
				.selectReportformDetail()
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
				.selectFormActivation(
						objFormConfiguration_data.strAsCertainStatusChanges)
				.clickOnNextButton()
				.selectStatusTypes(objStatusTypes_data.strNDSTStatusTypeName)
				.clickOnSelectStatusTypeButton()
				.selectWhenToSendOption(
						objFormConfiguration_data.strWheneverStatusIsAbove)
				.enterStatusTypeValue(
						objFormConfiguration_data.strStatusTypeValue)
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
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.switchToDefaultFrame().selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.enterNedocsUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForNDST);

		UpdateStatus_page1.clickOnSaveButton();
		
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

		String strActivationTime = "" + strActivationDate + " " + strDate[2];
		System.out.println("Activation time is : " + strActivationTime);

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
				.clickOnSave();

		objBlankForm.clickOnComplete();
		
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();
		
		objLinksAtTopRightCorners1.clickOnRefresh();

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

		String strFilledOutDate = strEndDate;
		String strFilledOutTime = strDate1[2];
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
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms();
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();

		Thread.sleep(2000);

		String strApplicationDate2 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String[] strDate2 = strApplicationDate2.split(" ");
		String strAcknowledgedDate = "";
		int intDate2 = Integer.parseInt(strDate2[0]);
		if (intDate2 == intCurrentDate) {
			strAcknowledgedDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate2 < intCurrentDate) {
				strAcknowledgedDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strAcknowledgedDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String strAcknowledgedTime = strDate2[2] + " " + strDate2[3];
		System.out.println("Acknowledged Time: " + strAcknowledgedTime);
		Thread.sleep(5000);

		String strFirstRow = "Form Summary Report for "
				+ objFormConfiguration_data.strFormName + " between "
				+ strStartDate + " " + strDate[3] + " and " + strEndDate + " "
				+ strDate1[3];
		String[] arrForm = { strFirstRow };

		String[] strHeaderNames = ArrayUtils
				.addAll(objReport_data.strFormSummaryReport);

		String[] strAnswers = { objUserdata.strFullName+" ("+objUserdata.strNewUserName+")", strActivationDate,
				strActivationTime,objUserdata.strFullName+" ("+ objUserdata.strNewUserName+")", objResource_data.strResourceName,
				strFilledOutDate, strFilledOutTime,
				objUserdata.strFullName1+" ("+objUserdata.strNewUserName1+")", objUserdata.strFullName1+" ("+objUserdata.strNewUserName1+")",
				strAcknowledgedDate, strAcknowledgedTime, "", "", "" };
		
		objNavigationToSubMenus1.navigateToFormReport();

		System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);

		objReport1.clickOnFormSummary().verifyFormSummaryReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
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

		for (intCount = 1; intCount <= arrForm.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Summary Report", 1,
					intCount, strDownloadName1);
			assertEquals(arrForm[intCount - 1], strValue);
		}

		String[] strValues = strAnswers;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			System.out.println("intCount value: " + intCount);
			if (intCount == 3 || intCount == 7 || intCount == 11) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 3, intCount, strDownloadName1);
				String strTime = strValues[intCount - 1];
				if (intCount != 11 && intCount != 7) {
					String[] strDateTime = strValues[intCount - 1].split(" ");
					strTime = strDateTime[1];
				}
				strTime = objDts.converDateFormat(strTime, "HH:mm", "hh:mm");
				String strTime1 = objDts
						.addTimetoExisting(strTime, -1, "hh:mm");
				String strTime2 = objDts.addTimetoExisting(strTime, 1, "hh:mm");
				if (intCount == 11) {
					String strTimeAndTiemZone = strTime + " " + strDate2[3];
					String strTimeAndTiemZone1 = strTime1 + " " + strDate2[3];
					assertTrue(strValue.contains(strTimeAndTiemZone)
							|| strValue.contains(strTimeAndTiemZone1));
				} else {
					assertTrue(strValue.contains(strTime)
							|| strValue.contains(strTime1)
							|| strValue.contains(strTime2));
				}
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);

			} else if (intCount == 2 || intCount == 6 || intCount == 10) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 3, intCount, strDownloadName1);
				assertTrue(strValue.contains(strValues[intCount - 1]));
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);
			} else {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 3, intCount, strDownloadName1);
				assertEquals(strValues[intCount - 1], strValue);
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);
			}
		}

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
