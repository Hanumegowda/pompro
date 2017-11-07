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

public class HappyDayFormDetailReportUpdated extends TestNG_UI_EXTENSIONS {

	public HappyDayFormDetailReportUpdated() throws Exception {
		super();
	}
	
	/*************************************************************************************
	'Description :Verify that, user U1 with "Carte Blanche" can generate the form detail report on
	              form F (NEW form) even if he/she is not involved in any of the following:
                  1. Activating the form
                  2. Filling out the form
                  3. Receiving the completed form.  
	'Precondition:
	'Date	 	 : 12-Mar-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/

	@Test(description = "Verify that, user U1 with 'Carte Blanche' can generate the form detail report "
			+ "on form F (NEW form) even if he/she is not involved in any of the following:"
			+ "1. Activating the form , 2. Filling out the form, 3. Receiving the completed form.")
	public void testHappyDay111825() throws Exception {

		gstrTCID = "111825";
		gstrTO = "Verify that, user U1 with 'Carte Blanche' can generate the form detail report "
				+ "on form F (NEW form) even if he/she is not involved in any of the following:"
				+ "1. Activating the form , 2. Filling out the form, 3. Receiving the completed form.";

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

		Report_data objReport_data = new Report_data();

		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

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

		// Sec file variables
		String strDownloadName2 = file + "\\" + "TC_1" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strCSVFileNameRenamed2 = "TC_1" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath2 = file + "\\" + "TC_1" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName3 = file + "\\" + "TC_1" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

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
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectReportformDetail()
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
				.clickSaveButton();
		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectReportformDetail()
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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectReportformDetail()
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
						objFormConfiguration_data.strUserToUsersAndResources)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName)
				.selectCarteBlancheChkBoxInSecurityPge(
						objUserdata.strNewUserName2)
				.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName2)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		String strApplicationDate = objEventManagement
				.getApplicationTimeWithCSTCDT();
		System.out.println(strApplicationDate);

		String[] strDate = strApplicationDate.split(" ");

		String strCurrentDate = objDts.getCurrentDate("dd");

		String strStartDate = "";
		//String strStartDate1 = "";
		int intDate = Integer.parseInt(strDate[0]);
		int intCurrentDate = Integer.parseInt(strCurrentDate);

		System.out.println(intDate);
		System.out.println(intCurrentDate);

		if (intDate == intCurrentDate) {
			strStartDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate < intCurrentDate) {
				strStartDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strStartDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		// strStartDate = strStartDate;
		//strStartDate1 = strStartDate + " " + strDate[3];

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

		Thread.sleep(2000);

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
		System.out.println("Activation time is : " + strActivationTime);

		objLogin1.clickLogOut();
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(6000);

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		// Thread.sleep(6000);
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
						.clickOnSave();

		objBlankForm.clickOnComplete();

		Thread.sleep(3000);

		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName);

		objDispatchForm.selectResourcesInDispatch(
				objResource_data.strResourceName).clickOnDispatchForm();

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

		Thread.sleep(5000);
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(10000);
		objNavigationToSubmenus1.navigateToFormReport();
		System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);
		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.clickOnGenerateReportBtn();

		Thread.sleep(5000);

		String[] strQuestions = { objFormConfiguration_data.strLabelName };

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strHtmlHeaderContents, strQuestions);
		String strDeliveredTo = objUserdata.strFullName + ", "
				+ objResource_data.strResourceName;

		String[] strAnswers = { strActivationDate, strActivationTime,
				objUserdata.strNewUserName, strDeliveredTo, strEndDate,
				strCompletedTime, objUserdata.strNewUserName1,
				objUserdata.strFullName1, objBlankFormData.strNumericAnswer };

		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite3 = a2.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

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

			

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.selectXlsxRadioBtn().clickOnGenerateReportBtn();
		Thread.sleep(2000);
		objReport1.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount3 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount3 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount3++;
					}

				} while (intCount3 < 60);

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

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
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

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToFormReport();
		System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);
		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.clickOnFilterButton().verifyFormDetailReportstep2Page()
				.verifyIncludeformswiththefollowingUsersSection()
				.verifyIncludeformswiththefollowingResourceSection();
		objReport1.selUserInFormDetailReportStep2(objUserdata.strNewUserName)
				.clickOnGenerateReportBtn();

		Thread.sleep(5000);

		String mainWindowHandle3 = driver1.getWindowHandle();

		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite4 = a3.iterator();

		while (ite4.hasNext()) {
			String popupHandle = ite4.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objReport1
				.verifyFormNameStartDateAndEndDate(
						objFormConfiguration_data.strFormName, strStartDate,
						strEndDate).verHTMLFormHeadersAndAnswers(
						strHeaderNames, strAnswers);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.selectXlsxRadioBtn().clickOnFilterButton()
				.verifyFormDetailReportstep2Page()
				.verifyIncludeformswiththefollowingUsersSection()
				.verifyIncludeformswiththefollowingResourceSection();
		objReport1.selUserInFormDetailReportStep2(objUserdata.strNewUserName)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		intCount = 0;
		intCount3 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed2);

				intCount3 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath2).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount3++;
					}

				} while (intCount3 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);

		String strValue1;

		String[] arrForm1 = { "Form", objFormConfiguration_data.strFormName };
		String[] arrStartDate1 = { "Start Date", strStartDate };
		String[] arrEndDate1 = { "End Date", strEndDate };

		for (intCount = 1; intCount <= arrForm1.length; intCount++) {
			strValue1 = objOffCommonFunc.readInfoExcel("Form Detail Report", 1,
					intCount, strDownloadName3);
			assertEquals(arrForm1[intCount - 1], strValue1);
		}

		for (intCount = 1; intCount <= arrStartDate1.length; intCount++) {
			strValue1 = objOffCommonFunc.readInfoExcel("Form Detail Report", 2,
					intCount, strDownloadName3);
			assertEquals(arrStartDate1[intCount - 1], strValue1);
		}

		for (intCount = 1; intCount <= arrEndDate1.length; intCount++) {
			strValue1 = objOffCommonFunc.readInfoExcel("Form Detail Report", 3,
					intCount, strDownloadName3);
			assertEquals(arrEndDate1[intCount - 1], strValue1);
		}

		String[] strValues1 = strAnswers;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			if (intCount == 2 || intCount == 6) {
				strValue1 = objOffCommonFunc.readInfoExcel(
						"Form Detail Report", 4, intCount, strDownloadName3);
				assertTrue(strValue1.contains(strHeaderNames[intCount - 1]));

				strValue1 = objOffCommonFunc.readInfoExcel(
						"Form Detail Report", 5, intCount, strDownloadName3);
				String strTime = strValues1[intCount - 1];
				String strTime1 = objDts
						.addTimetoExisting(strTime, -1, "HH:mm");
				String strTime2 = objDts.addTimetoExisting(strTime, 1, "HH:mm");
				assertTrue(strValue1.contains(strValues1[intCount - 1])
						|| strValue1.contains(strTime1)
						|| strValue1.contains(strTime2));
			} else {
				strValue1 = objOffCommonFunc.readInfoExcel(
						"Form Detail Report", 4, intCount, strDownloadName3);
				assertEquals(strHeaderNames[intCount - 1], strValue1);

				strValue1 = objOffCommonFunc.readInfoExcel(
						"Form Detail Report", 5, intCount, strDownloadName3);
				assertEquals(strValues1[intCount - 1], strValue1);
			}
		}

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description 		: Verify that, user U1 can generate the form detail report on form F 
    						(NEW form) when users other than user U1 has filled out the form sent to a resource
    'Precondition		:
    'Date         		: 13-Mar-2015
    'Author             : Renushree
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    **************************************************************************************/
	@Test(description = "Verify that, user U1 can generate the form detail report on form F (NEW form) "
			+ "when users other than user U1 has filled out the form sent to a resource")
	public void testHappyDay111826() throws Exception {

		gstrTCID = "111826";
		gstrTO = "Verify that, user U1 can generate the form detail report on form F (NEW form) "
				+ "when users other than user U1 has filled out the form sent to a resource";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		Report_data objReport_data = new Report_data();
		Date_Time_settings objDts = new Date_Time_settings();
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
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);

		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
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

		// Sec file variables
		String strDownloadName2 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strCSVFileNameRenamed2 = "TC1" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath2 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName3 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		System.out.println("-----Precondtion execution starts------");

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
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectReportformDetail()
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

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectAssosciateResourceRight(objResource_data.strResourceName)
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
						objFormConfiguration_data.strUserToUsersAndResources)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.clickOnNextButton()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.selectCarteBlancheChkBoxInSecurityPge(
						objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

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
				.selUserToFillOutForm(objUserdata.strNewUserName2)
				.clickOnActivateForm();

		Thread.sleep(2000);

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

		Thread.sleep(1000);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
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
						objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		Thread.sleep(8000);
		objDispatchForm.selectResourcesInDispatchNew(
				objResource_data.strResourceName).clickOnDispatchForm();

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

		Thread.sleep(1000);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName2 + " for "
				+ objResource_data.strResourceName + "\nSummary: | "
				+ objFormConfiguration_data.strLabelName + ": "
				+ objBlankFormData.strNumericAnswer;
		*/
		String strMsg = objRegionDefault1.getWebNotificationForResourceWithOneQuest(
				objUserdata.strFullName2, objResource_data.strResourceName,
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

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName);

		Thread.sleep(2000);

		objReport1.clickOnGenerateReportBtn();

		Thread.sleep(5000);

		String[] strQuestions = { objFormConfiguration_data.strLabelName };

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strHtmlHeaderContents, strQuestions);

		String[] strAnswers = { strActivationDate, strActivationTime,
				objUserdata.strNewUserName1, objResource_data.strResourceName,
				strEndDate, strCompletedTime, objUserdata.strNewUserName2,
				objUserdata.strFullName2, objBlankFormData.strNumericAnswer };

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

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate).selectXlsxRadioBtn()
				.selForm(objFormConfiguration_data.strFormName);

		Thread.sleep(2000);
		objReport1.clickOnGenerateReportBtn();

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

		for (intCount = 1; intCount <= (strHeaderNames.length - 1); intCount++) {
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

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.clickOnFilterInFormRep().verifyFormDetailReportstep2Page()
				.verifyIncludeformswiththefollowingUsersSection()
				.verifyIncludeformswiththefollowingResourceSection()
				.selUserInFormDetailReportStep2(objUserdata.strNewUserName1);

		Thread.sleep(2000);

		objReport1.clickOnGenerateReportBtn();

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
		objReport1
				.verifyFormNameStartDateAndEndDate(
						objFormConfiguration_data.strFormName, strStartDate,
						strEndDate).verHTMLFormHeadersAndAnswers(
						strHeaderNames, strAnswers);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate).selectXlsxRadioBtn()
				.selForm(objFormConfiguration_data.strFormName)
				.clickOnFilterInFormRep().verifyFormDetailReportstep2Page()
				.verifyIncludeformswiththefollowingUsersSection()
				.verifyIncludeformswiththefollowingResourceSection()
				.selUserInFormDetailReportStep2(objUserdata.strNewUserName1);

		Thread.sleep(2000);
		objReport1.clickOnGenerateReportBtn();
		Thread.sleep(10000);
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		intCount = 0;
		intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed2);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath2).exists());
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

		for (intCount = 1; intCount <= arrForm.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 1,
					intCount, strDownloadName3);
			assertEquals(arrForm[intCount - 1], strValue);
		}

		for (intCount = 1; intCount <= arrStartDate.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 2,
					intCount, strDownloadName3);
			assertEquals(arrStartDate[intCount - 1], strValue);
		}

		for (intCount = 1; intCount <= arrEndDate.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 3,
					intCount, strDownloadName3);
			assertEquals(arrEndDate[intCount - 1], strValue);
		}

		for (intCount = 1; intCount <= (strHeaderNames.length); intCount++) {
			if (intCount == 2 || intCount == 6) {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						4, intCount, strDownloadName3);
				assertTrue(strValue.contains(strHeaderNames[intCount - 1]));

				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						5, intCount, strDownloadName3);
				String strTime = strValues[intCount - 1];
				String strTime1 = objDts
						.addTimetoExisting(strTime, -1, "HH:mm");
				String strTime2 = objDts.addTimetoExisting(strTime, 1, "HH:mm");
				assertTrue(strValue.contains(strValues[intCount - 1])
						|| strValue.contains(strTime1)
						|| strValue.contains(strTime2));
			} else {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						4, intCount, strDownloadName3);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						5, intCount, strDownloadName3);
				assertEquals(strValues[intCount - 1], strValue);
			}
		}

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that the user U1 with "Carte Blanche" right can generate the form
	 			   detail report on a form F (NEW form) that was activated on predefined shifts 
	 			   even if the user is not involved in filling/receiving completed form.
	'Precondition:
	'Date	 	 : 13-Mar-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the user U1 with \"Carte Blanche\" right can generate the form detail report on a form F "
			+ "(NEW form) that was activated on predefined shifts even if the user is not involved in filling/receiving completed form.")
	public void testHappyDay111838() throws Exception {

		gstrTCID = "111838";
		gstrTO = "Verify that the user U1 with \"Carte Blanche\" right can generate the form detail report on a form F (NEW "
				+ "form) that was activated on predefined shifts even if the user is not involved in filling/receiving completed form.";

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
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectReportformDetail()
				.clickSaveButton();

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
							.selectCarteBlancheInSecurityPageForAsCertainStatsChangs(objUserdata.strNewUserName2)
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
		
		String strCompletedTime = strDate1[2];
		System.out.println("Completed Time: " + strCompletedTime);
		Thread.sleep(5000);
		
		//objFormConfiguration1.verAppTimeIsGreaterOrEqualToTimeProvided(strCompletedTime, strActivationShiftTime);
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName1,
						 		 objUserdata.strNewPassword);
		
	/*	String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
						+ objFormConfiguration_data.strLabelName + ": "
						+ objBlankFormData.strNumericAnswer + "| "
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
        
        objRegionDefault1.selectFrame()
                       	 .verWebNotificationframe()
                         .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                                     						strMsg)
                         .clickAcknowledgeAllForms()
                         .selectFrame();
 		Thread.sleep(3000);
		
		objRegionDefault1.switchToDefaultFrame()
						 .selectFrame();
        
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName2,
						 		objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

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
		
		String[] strQuestions = {objFormConfiguration_data.strLabelName, objFormConfiguration_data.strLabelName1};

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
	
	/*************************************************************************************
    'Description 		: Verify that the user U1 with "Carte Blanche" right can generate the 
    						form detail report on a form F (NEW form) that was activated on a status change even if the user is not involved in filling/receiving completed form.
    'Precondition		:
    'Date         		: 13-Mar-2015
    'Author             : Renushree
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    **************************************************************************************/
	@Test(description = "Verify that the user U1 with 'Carte Blanche' right can generate the "
			+ "form detail report on a form F (NEW form) that was activated on a status change even if the user is not involved in filling/receiving completed form.")
	public void testHappyDay111839() throws Exception {

		gstrTCID = "111839";
		gstrTO = "Verify that the user U1 with 'Carte Blanche' right can generate the "
				+ "form detail report on a form F (NEW form) that was activated on a status change even if the user is not involved in filling/receiving completed form.";

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
				.clickOnSaveButton()
				.clickOnViewResChkBox()
				.clickOnSaveButton();

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
				.clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2).selectFirstRole()
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
				.selectStatusTypes(objStatusTypes_data.strNSTStatusTypeName)
				.clickOnSelectStatusTypeButton()
				.selectWhenToSendOption(
						objFormConfiguration_data.strWheneverStatusIsAbove)
				.enterStatusTypeValue(
						objFormConfiguration_data.strStatusTypeValue)
				.clickOnSaveConfiguration()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectCarteBlancheInSecurityPageForAsCertainStatsChangs(objUserdata.strNewUserName2)
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

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0], objFormConfiguration_data.strValueForUpdate2);

		UpdateStatus_page1.clickOnSaveButton();
		
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
		
		Thread.sleep(5000);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
/*
		String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer;*/

		String strMsg =objRegionDefault1.getWebNotificationForOneQuestionnaire(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms();
		Thread.sleep(2000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);
		
		objRegionDefault1
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
		
		String[] strQuestions = {objFormConfiguration_data.strLabelName};

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strHtmlHeaderContents, strQuestions);
		
		String strCompletedByName = objUserdata.strFullName + " at " + objResource_data.strResourceName;
		
		String[] strAnswers = {strActivationDate,
				strActivationTime,
				objUserdata.strNewUserName,
				objUserdata.strFullName1,
				strEndDate,
				strCompletedTime,
				objUserdata.strNewUserName,
				strCompletedByName,
				objBlankFormData.strNumericAnswer };
		
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
    'Description 		:Verify that 'Carte Blanche' right for a user, cannot be given by users other than RegAdmin.
    'Precondition		:
    'Date         		: 15-Oct-2015
    'Author             : Sangappa K
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    **************************************************************************************/
	@Test(description = "Verify that 'Carte Blanche' right for a user, cannot be given by users other than RegAdmin.")
	public void testHappyDay34783() throws Exception {

		gstrTCID ="34783";
		gstrTO = "Verify that 'Carte Blanche' right for a user, cannot be given by users other than RegAdmin.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUser_data = new User_data();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayConfigureFormSecurity().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUser_data.strNewUserName)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUser_data.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		objFormConfiguration
				.clickOnSecurityLinkOfForm(
						objFormConfiguration_data.strFormName)
				.verFormSecurityPage(objFormConfiguration_data.strFormName)
				.selectCarteBlancheChkBoxInSecurityPge(
						objUser_data.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnSecurityLinkOfForm(
						objFormConfiguration_data.strFormName)
				.verFormSecurityPage(objFormConfiguration_data.strFormName)
				.verCarteBlancheChkBoxNotInSecurityPge(
						objUser_data.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}

}
	
	