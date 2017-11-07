package requirementGroup.CreatingAndManagingUsers;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import lib.dataObject.Calendar_data;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.Calendar;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.CSVFunctions;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class CreateUser extends TestNG_UI_EXTENSIONS {

	public CreateUser() throws Exception {
		super();
	}
	
	/*********************************************************************************
	'Description : Verify that a user can be provided the right to generate Event Detail report. 
	'Precondition:
	'Date	 	 : 03-Mar-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a user can be provided the right to generate Event Detail report.")
	public void testHappyDay68201() throws Exception {
		gstrTCID = "68201";
		gstrTO = "Verify that a user can be provided the right to generate Event Detail report.";
		
		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = objDate_Time_settings.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Event_data objEvent_data = new Event_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Report objReport1 = new Report(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Map objMap = new Map(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];
		Date_Time_settings dts = new Date_Time_settings();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		
		boolean blnTest = false;
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		
		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource_Page.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName);

		objUsersList_page
		.navigateToUsersNew()

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectFirstRole()
		.selectMaintainEventsOption()
		.selectReportStatusSnapshotOption()
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = {strResourceTypeValue[0]};
		
		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement();

		objEventManagement.clickOnCreateNewEvent();
				
		String[] strResVal = {strResourceValue[0]};
		
		
		objEventManagement
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		System.out.println(objEvent_data.strEventName);


		String strDrill = objEventManagement
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement
				.getEventEndTime(objEvent_data.strEventName);
		
		objNavigationToSubMenus.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus.clickOnSelectAll();
		
		objUpdateStatus.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);
		
		objUpdateStatus.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST);
		
		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate);

		objUpdateStatus.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST);
		
		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue)
				.clickOnSaveButton();

		String strUpdatedTime = objEventManagement.getApplicationTime();

		Thread.sleep(10000);
		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objUsersList1.navigateToUsers();
		
		objUsersList1.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword,  objUserdata.strFullName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectFirstRole()
				.selectReportEventDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
				
		objLogin1.clickLogOut();
	
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
		objNavigationToSubMenus1.navigateToEventReports();
		String strDate = dts.timeNow("MM/dd/yyyy");

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed().enterStartDate(strDate)
				.enterEndDate(strDate)
				.selectEventTemplate(strEventTemplateValue[0]).clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.verEnteredDatesAndPgeDetails(strDate)
				.enterReportStartDate(strDate).enterReportEndDate(strDate)
				.selectEvent(strEventVal)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		objLogin1.clickLogOut();

//		String strUpdatedTime = strEventStartTime;
		String strUpdate = objReport_data.strUpdate;

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objTest_data.strRegionName,
					objEvent_data.strEventName,
					objEventSetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNumberStatusType + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName + ", "
							+ objStatusTypes_data.strNDSTStatusTypeName + ", "
							+ objStatusTypes_data.strDateStatusTypeName,
					strEventStartTime,
					strEventEndTime,
					objReport_data.ExternalIP,
					strDrill,
					strUpdate,
					strUpdatedTime,
					strDownloadName,
					"",
					"",
					"",
					"",
					"",
					"",
					objView_data.strValueForUpdate + ", "+ 
					objView_data.strValueForTST + ", "
					+ objStatusTypes_data.strStatusNameInMulti + ", "
					+ objView_data.strUpdatedValForSST + ", "
					+ objView_data.strNEDOCValue + ", "
					+ objView_data.strDateUpdateValue };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************
	'Description :  Verify that a user can be provided the right to generate Monthly Status Assessment report.
	'Precondition:
	'Date	 	 : 23-Mar-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************/
	@Test(description = " Verify that a user can be provided the right to generate Monthly Status Assessment report.")
	public void testHappyDay68200() throws Exception {

		gstrTCID = "68200";
		gstrTO = " Verify that a user can be provided the right to generate Monthly Status Assessment report.";
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		CSVFunctions objCSVFunctions = new CSVFunctions();
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.csvFile;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + "TC" +gstrTCID+ "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();



		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		// User creation
		objUsersList1
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMonthlyStatusAssignmentOption()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin1.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();
		System.out.println(objResource_data.strResourceName);
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.selectStatusTypes(strstatusTypeValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
						.clickOnSaveButton();

		String strCurrentDate = objDts.getCurrentDate("MM/dd/yyyy HH:mm");

		String[] strTime4 = strCurrentDate.split(" ");
		
		String[] strTime5 = strTime4[0].split("/");
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnMonthlyStatusSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1.verifyDetailsInMonthlyStatusAssesmentPage1(strTime5[0], strTime5[2]);
		
		String strMonth = objReport1.getSelectedMonth();
		
		objReport1.selectResources(strResourceValue[0]).clickOnNextBtn()
		
		.verMonthlyStatusAssessmentReportPge2IsDisplayed()
		  .selStatusType(objStatusTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .verMonthlyStatusAssessmentReportPge3IsDisplayed()
		  .verifyStatuses(strStatusesValues[0])
		  .verifyStatuses(strStatusesValues[1])
		  .selStatuses(strStatusesValues[0]);
		
		String mainWindowHandle = driver1.getWindowHandle();

		String strEventStartTime = objEventManagement1.getApplicationTimeWithCSTCDT();

		String strEventStartTime1 = dts.AddTimeToExistingTimeHourAndMin(strEventStartTime, 0, 1, "dd MMM HH:mm");
		String strStartTime[] = strEventStartTime.split(" ");

		String strReportTime = strStartTime[0]+" "+strStartTime[1]+" "+strTime5[2]+" "+strStartTime[2]+" "+objTest_data.timeZone;
		
		String strStartTime1[] = strEventStartTime1.split(" ");
		
		String strReportTime1 = strStartTime1[0]+" "+strStartTime1[1]+" "+strTime5[2]+" "+strStartTime1[2]+" "+objTest_data.timeZone;
		
		objReport1.clickOnGenerateReportBtn();

		Thread.sleep(10000);
		
		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		
		String TitleName = driver1.getTitle();
		assertTrue(TitleName.contains("Monthly Status Assessment Report"));

		String[] strHeaderName = {"Monthly Status Assessment Report for "+strMonth+" "+ strTime5[2],objStatusTypes_data.strMSTStatusTypeName };
		
		objReport1.verifyHeadersInHTMLMonthlyAssesmentReport(strHeaderName);
		
		String[] strHeaderName1  = {"Resource Selected: "+objResource_data.strResourceName+" (N=1)", "Status Selected: "+objStatuTypes_data.strStatusNameInMulti};
		objReport1.verifyRSAndSTInHTMLMonthlyAssesmentReport(strHeaderName1);
		
		objReport1.verifyFooterHTMLMonthlyAssesmentReport(strReportTime, strReportTime1);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnMonthlyStatusSummaryLink();

		objReport1.selectCSVRadioBtn();
		
		objReport1.selectResources(strResourceValue[0]).clickOnNextBtn()
		
		  .selStatusType(objStatusTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .verMonthlyStatusAssessmentReportPge3IsDisplayed()
		  .selStatuses(strStatusesValues[0]);

		objReport1.clickOnGenerateReportBtn();
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
		File file1 = new File(strDownloadName);
		boolean strCsv1 = file1.exists();

		objLogin1.clickLogOut();

		String[][] strReportData = {{},{}, {},{}, {"\"Monthly Status Assessment Report for "+strMonth+" of "+strTime5[2]+"\""}, {"\""+objStatuTypes_data.strMSTStatusTypeName+"\""},{"\"Resource Selected: "+objResource_data.strResourceName+"(N=1)\""}, {"\"Status Selected: "+objStatuTypes_data.strStatusNameInMulti+"\""}, {"\"HOUR\""}};

		assertTrue(file1.exists());
		objCSVFunctions.verifyMonthlyAssesmentCSVData(strDownloadName, strReportData);
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName + ", ",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					"",
					objReport_data.ExternalIP,
					strDownloadName,"",
					"",
					 objStatuTypes_data.strStatusNameInMulti};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
			gstrResult = "PASS";
		}
	}
	/******************************************************************
	'Description : Verify that a user can be provided the right to edit Regional Message Bulletin Board.
	'Precondition:
	'Date	 	 : 06-Jun-2014
	'Author		 : Sangappa.k
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a user can be provided the right to edit Regional Message Bulletin Board.")
	public void testHappyDay68391() throws Exception {

		gstrTCID = "68391";
		gstrTO = "Verify that a user can be provided the right to edit Regional Message Bulletin Board.";

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Login_data objLogindata = new Login_data();
		Calendar objCalendar1 = new Calendar(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		Calendar_data objCalendar_data = new Calendar_data();
		User_data objUser_data = new User_data();
		
		Login objLogin2 = new Login(this.driver1);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus2 = new NavigationToSubMenus(
				this.driver1);
	
		Calendar objCalendar2 = new Calendar(this.driver1);

		String strMsgDate = dts.timeNow("MM/dd/yyyy");

		String strVerifyMsgDate = dts.converDateFormat(strMsgDate,
				"MM/dd/yyyy", "yyyy-MM-dd");

		String strFutureDate = dts.AddDaytoExistingDate(strMsgDate, 2,
				"MM/dd/yyyy");
		String[] strCurrentYear = strFutureDate.split("/");

		String strVerifyMsgDate1 = dts.converDateFormat(strFutureDate,
				"MM/dd/yyyy", "yyyy-MM-dd");

		String futureYear = dts.getFutureYear(2, "MM/dd/yyyy");
		String[] strFutureyear = futureYear.split("/");

		String strVerifyFutureyear = dts.converDateFormat(futureYear,
				"MM/dd/yyyy", "yyyy-MM-dd");
		System.out.println("strverifyFutureyear" + strVerifyFutureyear);


		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus.navigateToCalendarInRegionalInfo();

		objCalendar1
				.clickOnCreateNewMessage()
				.verCreateBulletinMessagePgeIsDispalyed()
				.createMessgae(strMsgDate, objCalendar_data.strTitle,
						objCalendar_data.strMessage,
						objCalendar_data.strContact);

		objCalendar1.verActionColumn()
				.verTitleOfMessage(objCalendar_data.strTitle)
				.verDateOfMessage(strVerifyMsgDate)
				.verMessage(objCalendar_data.strMessage)
				.verContactOfMessage(objCalendar_data.strContact);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selecMaintainDocumentLibraryOption()
				.selectEditRegionalMessageBulletinBoard().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin2.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault2.selectFrame();

		objNavigationToSubMenus2.navigateToCalendarInRegionalInfo();

		objCalendar2
				.clickOnCreateNewMessage()
				.verCreateBulletinMessagePgeIsDispalyed()
				.createMessgae(strMsgDate, objCalendar_data.strTitle1,
						objCalendar_data.strMessage,
						objCalendar_data.strContact);

		objCalendar2.verActionColumn()
				.verTitleOfMessage(objCalendar_data.strTitle1)
				.verDateOfMessage(strVerifyMsgDate)
				.verMessage(objCalendar_data.strMessage)
				.verContactOfMessage(objCalendar_data.strContact);

		objCalendar2.clickOnEditMsg(objCalendar_data.strTitle1)
				.enterTitle(objCalendar_data.strEditTittle)
				.enterDate(strFutureDate).clickOnSave();

		objCalendar2
				.verTitleOfMessage(objCalendar_data.strEditTittle)
				.verDateOfMessage(strVerifyMsgDate1)
				.verMessage(objCalendar_data.strMessage)
				.verContactOfMessage(objCalendar_data.strContact)
				.clickOnEditMsg(objCalendar_data.strTitle1)
				.enterTitle(objCalendar_data.strEditTittle1)
				.entereFutureYear(strCurrentYear[2], strCurrentYear[0],
						strFutureyear[0], strFutureyear[2])
				.clickOnSave()
				.verTitleOfMessageIsNotDispalyed(
						objCalendar_data.strEditTittle1)
				.verTitleOfMessageIsNotDispalyed(objCalendar_data.strTitle1)
				.verMessage(objCalendar_data.strMessage)
				.clickOnDeleteMsg(objCalendar_data.strTitle)
				.verTitleOfMessageIsNotDispalyed(objCalendar_data.strTitle);
				objLogin2.clickLogOut();

		gstrResult = "PASS";
	}
}
		
		
		



	

