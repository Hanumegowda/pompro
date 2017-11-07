package requirementGroup.Forms;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import lib.dataObject.BlankFormData;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.AutoIT;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.EventManagement;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
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
	'Description :  	Verify that, user U1 can generate the form detail report on form F (NEW form) when users other than user U1 has received the completed form sent to a resource 
	'Precondition:
	'Date	 	 : 13-Mar-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that, user U1 can generate the form detail report on form F (NEW form) when users other than user U1 has received the completed form sent to a resource ")
	public void testHappyDay111827() throws Exception {

		gstrTCID = "111827";
		gstrTO = "Verify that, user U1 can generate the form detail report on form F (NEW form) when users other than user U1 has received the completed form sent to a resource ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
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
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners = new LinksAtTopRightCorners(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		Report objReport1 = new Report(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		ActivateForms objActivateForms = new ActivateForms(this.driver1);
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;
		AutoIT objAutoIT = new AutoIT(this.driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
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

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		// Sec file variables
		String strDownloadName2 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + fileType;
		
		String strCSVDownlRenamedPath2 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strCSVFileNameRenamed2 = "TC1" + gstrTCID + "_" + strTimeText;
		
		String strDownloadName3 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;
		
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
						objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
						.selectViewResourceCheckBox(objResource_data.strResourceName)
						.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1).selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2).selectFirstRole()
				.clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName3,
				objUserdata.strNewPassword, objUserdata.strFullName3).selectFirstRole()
				.clickSaveButton();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName4,
				objUserdata.strNewPassword, objUserdata.strFullName4).selectFirstRole()
				.deselectAllViewResReightOption()
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
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selectFormActivation(objFormConfiguration_data.strFormActivatnUIOTFO)
				.selectCompletedFormDelivery(objFormConfiguration_data.strUserToUsersAndResources)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.selectCarteBlancheChkBoxInSecurityPge(objUserdata.strNewUserName4)
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

		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToActivateForm();

		strApplicationDate = objEventManagement.getApplicationTimeWithCSTCDT();
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
		
		objActivateForms.clickOnSendForm(objFormConfiguration_data.strFormName)
		
		.selUserToFillOutForm(objUserdata.strNewUserName2)
		
		.clickOnActivateForm();

		objLogin.clickLogOut();
		
		Thread.sleep(5000);
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName2,
				 objUserdata.strNewPassword);

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
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer)
					.clickOnSave();
		
		Thread.sleep(5000);
		
		objBlankForm.clickOnComplete();
		
		Thread.sleep(5000);
		
		objDispatchForm.selUserToReceiveCompletedForm(objUserdata.strNewUserName3);
		
		objDispatchForm.selectResourcesInDispatch(
				objResource_data.strResourceName).clickOnDispatchForm();
		
		driver.switchTo().window(mainWindowHandle1);
		
		objRegionDefault.selectFrame();

	    objLinksAtTopRightCorners.clickOnRefresh();
		
		Thread.sleep(1000);
		
		String strApplicationDate1 = objEventManagement.getApplicationTimeWithCSTCDT();

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
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName4,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate).enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName);

		Thread.sleep(2000);

		objReport1.clickOnGenerateReportBtn();


        Thread.sleep(5000);
        
        String[] strQuestions = {objFormConfiguration_data.strLabelName, objFormConfiguration_data.strLabelName1};

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strHtmlHeaderContents, strQuestions);

		String[] strAnswers = { strActivationDate, strActivationTime,
				objUserdata.strNewUserName1, objUserdata.strFullName3+", "+objResource_data.strResourceName,
				strEndDate, strCompletedTime, objUserdata.strNewUserName2,
				objUserdata.strFullName2, objBlankFormData.strNumericAnswer, objBlankFormData.strTextAnswer };

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

		for (intCount = 1; intCount <= (strHeaderNames.length - 1); intCount++) {
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
				String strTime3 = objDts.addTimetoExisting(strTime, 2, "HH:mm");
				assertTrue(strValue.contains(strValues[intCount - 1])
						|| strValue.contains(strTime1)
						|| strValue.contains(strTime2)
						|| strValue.contains(strTime3));
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


}
