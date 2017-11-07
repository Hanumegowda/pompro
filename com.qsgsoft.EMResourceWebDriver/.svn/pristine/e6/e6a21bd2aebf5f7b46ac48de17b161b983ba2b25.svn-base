package requirementGroup.Reports;

import java.util.Iterator;
import java.util.Set;

import lib.dataObject.BlankFormData;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.EventManagement;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseFormDetailReportUpdated extends TestNG_UI_EXTENSIONS{

	public EdgeCaseFormDetailReportUpdated() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*******************************************************************************************************
    'Description :Verify that generation of form detail report can be canceled on "Form Detail Report" page.
    'Date        :20-Apr-2015
    'Author      :Anitha
    '-------------------------------------------------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    ********************************************************************************************************/
	@Test(description = "Verify that generation of form detail report can be canceled on Form Detail Report page.")
	public void testEdgeCase34567() throws Exception {

		gstrTCID = "34567";
		gstrTO = "Verify that generation of form detail report can be canceled on Form Detail Report page.";

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
		
		String strMsg = objRegionDefault1.getWebNotificationForOneQuestionnaire(
				objUserdata.strFullName, objLogindata.strRegionName, 
				objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer);
		System.out.println(strMsg);

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

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
		        .verFormDetailPageElements()
		        .verFormDetailPageButtons()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)			
				.clickOnCancelBtn()
				.verifyFormReportsMenuPage()
				.clickOnFormDetail()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.clickOnFilterButton()
				.verifyFormDetailReportstep2Page()
				.verifyIncludeformswiththefollowingUsersSection()
				.verFormDetailPageButtons()
				.clickOnCancelBtn()
				.verifyFormReportsMenuPage();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************************
    'Description :Verify that generation of form detail report can be canceled on "Form Detail Report - Step 2" page.
    'Date        :20-Apr-2015
    'Author      :Anitha
    '----------------------------------------------------------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    *****************************************************************************************************************/
	@Test(description = "Verify that generation of form detail report can be canceled on Form Detail Report - Step 2 page.")
	public void testEdgeCase34568() throws Exception {

		gstrTCID = "34568";
		gstrTO = "Verify that generation of form detail report can be canceled on Form Detail Report - Step 2 page.";

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

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selectXlsxRadioBtn()
				.selForm(objFormConfiguration_data.strFormName)			
				.clickOnFilterButton()
				.verifyFormDetailReportstep2Page()
				.verifyIncludeformswiththefollowingUsersSection()
				.verFormDetailPageButtons()
				.clickOnCancelBtn()
				.verifyFormReportsMenuPage();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************
    'Description : Verify that form report cannot be generated if any of the mandatory fields are left blank
    'Date        : 15-May-2015
    'Author      : Rensuhree
    '-------------------------------------------------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    ********************************************************************************************************/
	@Test(description = "Verify that form report cannot be generated if any of the mandatory fields are left blank")
	public void testEdgeCase34569() throws Exception {

		gstrTCID = "34569";
		gstrTO = "Verify that form report cannot be generated if any of the mandatory fields are left blank";

		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
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
		Report_data objReport_data = new Report_data();

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
				.clickOnAddToSummary().clickOnDoneButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		System.out
				.println("--------Precondition ends and test execution starts-------");

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

		String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer;

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

		objReport1
				.clickOnFormDetail()
				.verifyFormDetailReportPage()
				.clickOnGenerateReportBtn()
				.verErrorWhenMandatoryDataNtProvided(
						objReport_data.errorWhenStartDateNotProvided)
				.verErrorWhenMandatoryDataNtProvided(
						objReport_data.errorWhenEndDateNotProvided)
				.verErrorWhenMandatoryDataNtProvided(
						objReport_data.errorWhenFormNotSelected)
				.enterReportStartDate(strStartDate)
				.clickOnGenerateReportBtn()
				.verErrorWhenMandatoryDataNtProvided(
						objReport_data.errorWhenEndDateNotProvided)
				.verErrorWhenMandatoryDataNtProvided(
						objReport_data.errorWhenFormNotSelected)
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.clickOnGenerateReportBtn()
				.verErrorWhenMandatoryDataNtProvided(
						objReport_data.errorWhenFormNotSelected);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
