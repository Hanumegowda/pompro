package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Properties;

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
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayExcelViewsAndEvents extends TestNG_UI_EXTENSIONS {
	
	public HappyDayExcelViewsAndEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************************************************************************************************
	 * 'Description : Verify that user with ‘Report-Snapshot’ right can generate snapshot of ‘Region-View’ of current date and time in excel format. 
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = " 	Verify that user with ‘Report-Snapshot’ right can generate snapshot of ‘Region-View’ of current date and time in excel format. ")
	public void testHappyDay146274() throws Exception {
		gstrTCID = "146274";
		gstrTO = " 	Verify that user with ‘Report-Snapshot’ right can generate snapshot of ‘Region-View’ of current date and time in excel format. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
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

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

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

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectReportStatusSnapshotOption()

				.clickSaveButton();

		objnNavigationToSubMenus.navigateToViews();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

//		objViewsList.clickCreateNewViewButton()
//					.enterViewName(objView_data.strViewName)
//					.enterViewDesc(objView_data.strViewDesc);
//		
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
				objResource_data.strResourceName, strStatusTypeNames);
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnViewMenu();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		Thread.sleep(3000);
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[0]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateValue);

		UpdateStatus_page1.clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTime();
		String[] strTime = strApplicationTime.split(" ");
		String[] strTimeHrMin = strTime[2].split(":");

		System.out.println(objResource_data.strResourceName);
		System.out.println(objResourceType_data.strResourceTypeName);

		String strCurrentDate = objDts.getCurrentDate("yyyy-MM-dd");

		RegionDefault_page1.clickExcelOption();

		Thread.sleep(2000);
		RegionDefault_page1.clickOnGenerateReportOption();
		Thread.sleep(2000);

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

		String strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strTimeHrMin[0]+":"
				+ strTimeHrMin[1] + " " + objView_data.strViewName
				+ " View Snapshot", strValue);

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment" };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"" };

		for (intCount = 1; intCount <= (strHeaderNames.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedValues[intCount - 1], strValue);
		}
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************************
	 * 'Description : Edit a view add few more status types and verify that excel snapshot displays the newly added status type.
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anitha
	 ***************************************************************************************************************************/

	@Test(description = " Edit a view add few more status types and verify that excel snapshot displays the newly added status type.")
	public void testHappyDay146598() throws Exception {
		gstrTCID = "146598";
		gstrTO = " Edit a view add few more status types and verify that excel snapshot displays the newly added status type.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
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

		// New file variables
		String strDownloadName2 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strCSVFileNameRenamed2 = "TC1" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath2 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName3 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

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

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectConfigureRegionViewsOption()

				.selectReportStatusSnapshotOption()

				.clickSaveButton();

		String[] strSTNames1 = { objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName };
		objnNavigationToSubMenus.navigateToViews();

		objViewsList
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strSTNames1);
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		String[] strStatusTypeValues = { strstatusTypeValues[1],
//				strstatusTypeValues[3], strstatusTypeValues[5] };
//
//		objViewsList.selectStatusTypeForView(strStatusTypeValues);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);
		System.out.println(objView_data.strViewName);

		System.out
				.println("-----precondition ends and test execution starts------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		Thread.sleep(3000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[0]);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateValue);

		UpdateStatus_page1.clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTime();
		String[] strTime = strApplicationTime.split(" ");
		String[] strTimeHrMin = strTime[2].split(":");

		System.out.println(objResource_data.strResourceName);
		System.out.println(objResourceType_data.strResourceTypeName);

		String strCurrentDate = dts.getCurrentDate("yyyy-MM-dd");

		RegionDefault_page1.clickExcelOption();

		Thread.sleep(2000);
		RegionDefault_page1.clickOnGenerateReportOption();
		Thread.sleep(2000);

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

		String strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strTimeHrMin[0]+":"
				+ strTimeHrMin[1] + " " + objView_data.strViewName
				+ " View Snapshot", strValue);
//changed the order of STs
		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				 "Comment" };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strNEDOCVal,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strDateUpdateValue,
				 "" };

		for (intCount = 1; intCount <= (strHeaderNames.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedValues[intCount - 1], strValue);
		}

		// add status types and update once again view

		objnNavigationToSubMenus1.navigateToViews();

		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName);

//		String[] strStatusTypeValues2 = { strstatusTypeValues[0],
//				strstatusTypeValues[2], strstatusTypeValues[4] },
		String[] strSTNames2 = { objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, 
				objStatusTypes_data.strSSTStatusTypeName };

//		objViewsList1.selectStatusTypeForView(strStatusTypeValues2)
//		.clickOnSaveOfCreateNewView();

		objViewsList1.clickOnSTTab();
		
		for(int i = 0; i< strSTNames2.length; i++) {
			objViewsList1.selectStatusType(strSTNames2[i]);
		}

		objViewsList1.clickOnSaveOfCreateNewView();
		
		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		Thread.sleep(3000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[0]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateValue);

		UpdateStatus_page1.clickOnSaveButton();

		strApplicationTime = objEventManagement1.getApplicationTime();
		String[] strTime1 = strApplicationTime.split(" ");
		String[] strTimeHrMin1 = strTime1[2].split(":");

		// Generate latest report

		RegionDefault_page1.clickExcelOption();

		Thread.sleep(2000);
		RegionDefault_page1.clickOnGenerateReportOption();
		Thread.sleep(2000);

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

		strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName3);
		assertEquals("" + strCurrentDate + " " + strTimeHrMin1[0]+":"
				+ strTimeHrMin1[1] + " " + objView_data.strViewName
				+ " View Snapshot", strValue);

		String[] strHeaderNames1 = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment" };

		String[] strUpdatedValues1 = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"" };

		for (intCount = 1; intCount <= (strHeaderNames1.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName3);
			assertEquals(strHeaderNames1[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName3);
			assertEquals(strUpdatedValues1[intCount - 1], strValue);
		}

		gstrResult = "PASS";
	}

	/***************************************************************************************************************
	 * 'Description : 	Verify that user can generate snapshot of ‘Region-View’ providing past time in 'excel' format. 
	 * 'Date        : 12-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that user can generate snapshot of ‘Region-View’ providing past time in 'excel' format. ")
	public void testHappyDay146301() throws Exception {
		gstrTCID = "146301";
		gstrTO = " 	Verify that user can generate snapshot of ‘Region-View’ providing past time in 'excel' format. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		
		
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
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
		
		File file = new File(System.getProperty("user.dir") + fileDownloadPath) ;
		
		File autoItFiles = new File(System.getProperty("user.dir")+autoItFilesPath);
		
		String strDownloadName = file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		String strCSVFileNameRenamed =  "TC"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath =  file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName1 = file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText
				+  objReport_data.xlsFile;
		
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		ResourceType ResourceType_Page = new ResourceType(this.driver1);		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
	
		Login objLogin1 = new Login(this.driver1);
		
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");

		String filePath = file+"\\";
		String strApplicationTime = "";
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		
		objStatusTypeList.navigateToStatusTypeList();
		
		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
				
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);	
		
		strstatusesValues[0] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti);
				
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);	
		
		strstatusesValues[1] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();
		
		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
		.navigateToUsersNew()

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		
		.selectFirstRole()
						
		.selectUpdateStatusOfResource(objResource_data.strResourceName)

		.clickAdvancedOptionAndExpand()

		.selectReportStatusSnapshotOption()

		.clickSaveButton();

		objnNavigationToSubMenus.navigateToViews();
		
		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
//		objViewsList.clickCreateNewViewButton()
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);
//		
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//		
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
	
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
				objResource_data.strResourceName, strStatusTypeNames);
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
	    Thread.sleep(5000);
	
		objnNavigationToSubMenus1.clickOnViewMenu();
		
		Thread.sleep(2000);
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		Thread.sleep(2000);

		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		UpdateStatus_page1.clickOnSelectAll();
				
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1], objView_data.strValueForNDST);
	     
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strValueForTST);
		    
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3], strstatusesValues[0]);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4], objView_data.strValueForSST);
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5], objView_data.strDateUpdateValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();

		strApplicationTime = objEventManagement1.getApplicationTime();
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;
			    
		strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		Thread.sleep(180000);
		
		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		UpdateStatus_page1.clickOnSelectAll();
				
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate1);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1], objView_data.strValueForNDST1);
	     
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strValueForTST1);
		    
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3], strstatusesValues[1]);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4], objView_data.strValueForSST1);
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5], objView_data.strDateUpdateFutureValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();
	    
	    Thread.sleep(5000);
	    
		RegionDefault_page1.clickExcelOption();
		
		String strDate = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,  "MM/dd/yyyy HH:mm","mm");
		String strCurrentDate = objDts.getCurrentDate("yyyy-MM-dd");
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		Thread.sleep(2000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName, strAutoITName);
		int intCount = 0;
		int intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath)
								.exists());
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
		
		String strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strHour+":"
				+ strMinutes + " " + objView_data.strViewName
				+ " View Snapshot", strValue);

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment"};

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"" };

		for (intCount = 1; intCount <= (strHeaderNames.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedValues[intCount - 1], strValue);
		}
		gstrResult = "PASS";
	}

	/***************************************************************************************************************
	 * 'Description : Verify that appropriate past view is displayed in region default excel snapshot.  
	 * 'Date        : 12-Nov-2014 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/

	@Test(description = "Verify that appropriate past view is displayed in region default excel snapshot.")
	public void testHappyDay146593() throws Exception {
		
		gstrTCID = "146593";
		gstrTO = "Verify that appropriate past view is displayed in region default excel snapshot.";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = objDate_Time_settings.getCurrentDate(objReport_data.dateFormat1);
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

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName2 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed1 = "2ndTC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath1 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName3 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Views objViews1 = new Views(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

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
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
							      objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

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

		objNavigationToSubMenus.navigateToResourceInSetup();

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

		objUsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectReportStatusSnapshotOption()

				.clickSaveButton();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.clickOnEditOfRegDefault()
					.clickOnResourcesTab()
					.selectResource(
							objResource_data.strResourceName)
					.clickNextButton();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList/*.selectResource(objResource_data.strResourceName)*/
				.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		String strFirst3StatusTypeVal[] = { strStatusTypeValues[0],
				strStatusTypeValues[1], strStatusTypeValues[2] };

		String strSec3StatusTypeVal[] = { strStatusTypeValues[3],
				strStatusTypeValues[4], strStatusTypeValues[5] };

		for (int i = 0; i < strFirst3StatusTypeVal.length; i++) {
			objUpdateStatus.selectStatusTypes(strFirst3StatusTypeVal[i]);
		}

		objUpdateStatus
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strDateUpdateValue)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST)
				.clickOnCalculate()
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0])
				.clickOnSaveButton();

		String strUpdateTime = objEventManagement1.getApplicationTime();
		System.out.println(strUpdateTime);

		Thread.sleep(120000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		for (int i = 0; i < strSec3StatusTypeVal.length; i++) {
			objUpdateStatus.selectStatusTypes(strSec3StatusTypeVal[i]);
		}

		objUpdateStatus
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strStatusTypeValues[4],
						objView_data.strValueForSST)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
						objView_data.strValueForUpdate1).clickOnSaveButton();

		String strUpdateTime2 = objEventManagement1.getApplicationTime();
		System.out.println(strUpdateTime2);
		String strCurrentDate = objDate_Time_settings.getCurrentDate("yyyy-MM-dd");
		String[] strDateTime = strUpdateTime.split(" ");
		String[] strHourAndMin = strDateTime[2].split(":");
		String strMinute = objDate_Time_settings.addTimetoExisting(strHourAndMin[1], 1, "mm");
		String strCureentDate = objDate_Time_settings.getCurrentDate("MM/dd/yyyy");

		Thread.sleep(2000);
		objRegionDefault_page1.clickExcelOption();
		Thread.sleep(2000);

		objRegionDefault_page1
				.selectAndEnterDateAndTime(strCureentDate, strHourAndMin[0],
						strMinute)
				.clickOnGenerateReportOption();

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

		String strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strHourAndMin[0]+":"
				+ strMinute + " Region Default View Snapshot", strValue);

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment" };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strHyphen,objView_data.strHyphen,objView_data.strHyphen,"" };

		for (intCount = 1; intCount <= (strHeaderNames.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedValues[intCount - 1], strValue);
		}

		String[] strDateTime2 = strUpdateTime2.split(" ");
		String[] strHourAndMin2 = strDateTime2[2].split(":");
		String strMinute1 = objDate_Time_settings.addTimetoExisting(strHourAndMin2[1], 1, "mm");
		Thread.sleep(2000);
		objRegionDefault_page1.clickExcelOption();
		Thread.sleep(2000);

		objRegionDefault_page1.selectAndEnterDateAndTime(strCureentDate, strHourAndMin2[0],
						strMinute1).clickOnGenerateReportOption();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		int intCount2 = 0;
		int intCount3 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed1);

				intCount3 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath1).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount3++;
					}

				} while (intCount3 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount2++;
			}
		} while (intCount2 < 60);

		strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName3);
		assertEquals("" + strCurrentDate + " " + strHourAndMin2[0]+":"
				+ strMinute1 + " Region Default View Snapshot", strValue);

		String[] strHeaderNames1 = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment" };

		String[] strUpdatedValues1 = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForUpdate1, "" };

		for (intCount = 1; intCount <= (strHeaderNames1.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName3);
			assertEquals(strHeaderNames1[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName3);
			assertEquals(strUpdatedValues1[intCount - 1], strValue);
		}
		gstrResult = "PASS";
	}

	/***************************************************************************************************************
	 * 'Description : 	Verify that user with ‘Report-Snapshot’ right can generate snapshot of ‘Region-View’ of current date and time in excel format. 
	 * 'Date        : 13-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = " 	Verify that user can generate 'excel' snapshot of ‘Event Status’ for current date and time. ")
	public void testHappyDay146306() throws Exception {
		gstrTCID = "146306";
		gstrTO = " 	Verify that user can generate 'excel' snapshot of ‘Event Status’ for current date and time. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
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
		
		File file = new File(System.getProperty("user.dir") + fileDownloadPath) ;
		
		File autoItFiles = new File(System.getProperty("user.dir")+autoItFilesPath);
		
		String strDownloadName = file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		String strCSVFileNameRenamed =  "TC"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath =  file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName1 = file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText
				+  objReport_data.xlsFile;
		
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		ResourceType ResourceType_Page = new ResourceType(this.driver1);		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
	
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
	
		Login objLogin1 = new Login(this.driver1);
		
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");

		String filePath = file+"\\";
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
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
		
		strstatusesValues[0] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti);
				
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();
		
		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
		.navigateToUsersNew()

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		
		.selectFirstRole()
						
		.selectUpdateStatusOfResource(objResource_data.strResourceName)

		.clickAdvancedOptionAndExpand()

		.selectMaintainEventsOption()
		
		.selectReportEventSnapshotOption()
		
		.selectReportStatusSnapshotOption()

		.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strstatusTypeValues)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
	
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue).clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyEventStatus();
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		UpdateStatus_page1.clickOnSelectAll();
				
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1], objView_data.strValueForNDST);
	     
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strValueForTST);
		    
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3], strstatusesValues[0]);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4], objView_data.strValueForSST);
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5], objView_data.strDateUpdateValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTimeWithCSTCDT();
		String[] strTime = strApplicationTime.split(" ");
		String[] strTimeHrMin = strTime[2].split(":");
		String strCurrentDate = dts.getCurrentDate("yyyy-MM-dd");
		RegionDefault_page1.clickExcelOption();
		
		Thread.sleep(2000);
		RegionDefault_page1.clickOnGenerateReportOption();
		Thread.sleep(2000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName, strAutoITName);
		int intCount = 0;
		int intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath)
								.exists());
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
		
		String strValue ="";

		String[] strUpdatedStatusTypeNames = { objResourceType_data.strResourceTypeName, 
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, 
				objTest_data.strComment, objTest_data.strLastUpdate, objTest_data.strUpdatedBy};
		
		String[] strUpdatedExcelValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST,
				"",strApplicationTime, objUserdata.strFullName };
		
		String[] strSummaryValue = { objTest_data.strSummary, objView_data.strNotApplicable,//objView_data.strNotApplicable,
				objView_data.strNotApplicable,objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,objView_data.strUpdatedValForSST,
				objView_data.strNotApplicable,"", "", ""};
		
		strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strTimeHrMin[0]+":"
				+ strTimeHrMin[1] + " " + objEvent_data.strEventName
				+ " Event Snapshot", strValue);

		for( intCount = 1; intCount<=strUpdatedStatusTypeNames.length; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName1);
			assertEquals(strUpdatedStatusTypeNames[intCount-1], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName1);
			assertEquals(strUpdatedExcelValues[intCount-1], strValue);
					
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 4, intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount-1], strValue);
			
		}
		
		String[] strSummaryStatusTypeNames = {objView_data.strStatusTypeSummary,  objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName};
		
		String[] strSummaryStatusTypeUpdatedValues = {objView_data.strTotal, objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,objView_data.strUpdatedValForSST};
		
		for( intCount = 2; intCount<=(strSummaryStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount, 1, strDownloadName1);
			assertEquals(strSummaryStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount, 2, strDownloadName1);
			assertEquals(strSummaryStatusTypeUpdatedValues[intCount-2], strValue);
		}	
		gstrResult = "PASS";
	}


	/***************************************************************************************************************
	 * 'Description : Verify that user can generate 'excel' snapshot of ‘Event Status’ providing past date and time. 
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(enabled=false,description = "Verify that user can generate 'excel' snapshot of ‘Event Status’ providing past date and time. ")
	public void testHappyDay146307() throws Exception {
		gstrTCID = "146307";
		gstrTO = "Verify that user can generate 'excel' snapshot of ‘Event Status’ providing past date and time. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
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
		
		File file = new File(System.getProperty("user.dir") + fileDownloadPath) ;
		
		File autoItFiles = new File(System.getProperty("user.dir")+autoItFilesPath);
		
		String strDownloadName = file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		String strCSVFileNameRenamed =  "TC"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath =  file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName1 = file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText
				+  objReport_data.xlsFile;
		
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Date_Time_settings objDts = new Date_Time_settings();
		
		ResourceType ResourceType_Page = new ResourceType(this.driver1);		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
	
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
	
		Login objLogin1 = new Login(this.driver1);
		
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");

		String filePath = file+"\\";
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
				
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);	
		
		strstatusesValues[0] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti);
					
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);	
		
		strstatusesValues[1] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti1);
				
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();
		
		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
		.navigateToUsersNew()

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		
		.selectFirstRole()
						
		.selectUpdateStatusOfResource(objResource_data.strResourceName)

		.clickAdvancedOptionAndExpand()

		.selectMaintainEventsOption()
		
		.selectReportEventSnapshotOption()
		
		.selectReportStatusSnapshotOption()

		.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strstatusTypeValues)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		

	
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue).clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyEventStatus();
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		UpdateStatus_page1.clickOnSelectAll();
				
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1], objView_data.strValueForNDST);
	     
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strValueForTST);
		    
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3], strstatusesValues[0]);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4], objView_data.strValueForSST);
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5], objView_data.strDateUpdateValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();

		String strApplicationTime1 = objEventManagement1.getApplicationTimeWithCSTCDT();
			
		String strApplicationTime = objEventManagement1.getApplicationTime();
	    
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;
		String strCurrentDate = dts.getCurrentDate("yyyy-MM-dd");
		strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		Thread.sleep(180000);
		
		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		UpdateStatus_page1.clickOnSelectAll();
				
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate1);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1], objView_data.strValueForNDST1);
	     
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strValueForTST1);
		    
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3], strstatusesValues[1]);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4], objView_data.strValueForSST1);
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5], objView_data.strDateUpdateFutureValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();
	    
	    Thread.sleep(5000);
	    
		RegionDefault_page1.clickExcelOption();
		
		String strDate = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,  "MM/dd/yyyy HH:mm","mm");
		
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		Thread.sleep(2000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName, strAutoITName);
		int intCount = 0;
		int intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath)
								.exists());
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
		
		String strValue ="";

		String[] strUpdatedStatusTypeNames = { objResourceType_data.strResourceTypeName, 
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, 
				objTest_data.strComment, objTest_data.strLastUpdate, objTest_data.strUpdatedBy};
		
		String[] strUpdatedExcelValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST,
				"",strApplicationTime1, objUserdata.strFullName };
		
		String[] strSummaryValue = { objTest_data.strSummary, objView_data.strNotApplicable,
				objView_data.strNotApplicable,objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,objView_data.strUpdatedValForSST,
				objView_data.strNotApplicable,"", "", ""};
		
		strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strHour+":"
				+ strMinutes + " " + objEvent_data.strEventName
				+ " Event Snapshot", strValue);
		
		for( intCount = 1; intCount<=strUpdatedStatusTypeNames.length; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName1);
			assertEquals(strUpdatedStatusTypeNames[intCount-1], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName1);
			assertEquals(strUpdatedExcelValues[intCount-1], strValue);
					
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 4, intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount-1], strValue);
			
		}
		
		String[] strSummaryStatusTypeNames = {objView_data.strStatusTypeSummary,  objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,};
		
		String[] strSummaryStatusTypeUpdatedValues = {objView_data.strTotal, objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,objView_data.strUpdatedValForSST};
		
		for( intCount = 2; intCount<=(strSummaryStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount,1, strDownloadName1);
			assertEquals(strSummaryStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount,2, strDownloadName1);
			assertEquals(strSummaryStatusTypeUpdatedValues[intCount-2], strValue);
		}	
		gstrResult = "PASS";
	}

	/***************************************************************************************************************
	 * 'Description : Verify that appropriate past view is displayed in 'Custom View' excel snapshot.   
	 * 'Date        : 17-Nov-2014 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/

	@Test(description = "Verify that appropriate past view is displayed in 'Custom View' excel snapshot. ")
	public void testHappyDay146895() throws Exception {
		gstrTCID = "146895";
		gstrTO = "Verify that appropriate past view is displayed in 'Custom View' excel snapshot. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = objDate_Time_settings
				.getCurrentDate(objReport_data.dateFormat1);
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

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName2 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed1 = "2ndTC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath1 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName3 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

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
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
							      objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

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

		objNavigationToSubMenus.navigateToResourceInSetup();

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

		objUsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectViewcustomViewOption()

				.selectReportStatusSnapshotOption()

				.clickSaveButton();

		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		String[] strResourceNames = { objResource_data.strResourceName };

		objCustomUnderView1.verResourceAndResTypeInCustomViewTablePage(
				strResourceNames, objResourceType_data.strResourceTypeName);

		objCustomUnderView1
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		String strFirst3StatusTypeVal[] = { strStatusTypeValues[0],
				strStatusTypeValues[1], strStatusTypeValues[2] };

		String strSec3StatusTypeVal[] = { strStatusTypeValues[3],
				strStatusTypeValues[4], strStatusTypeValues[5] };

		for (int i = 0; i < strFirst3StatusTypeVal.length; i++) {
			objUpdateStatus1.selectStatusTypes(strFirst3StatusTypeVal[i]);
		}

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strDateUpdateValue)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST)
				.clickOnCalculate()
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0]).clickOnSaveButton();

		String strApplicationTime1 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String strUpdateTime = objEventManagement1.getApplicationTime();
		System.out.println(strUpdateTime);

		Thread.sleep(120000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		for (int i = 0; i < strSec3StatusTypeVal.length; i++) {
			objUpdateStatus1.selectStatusTypes(strSec3StatusTypeVal[i]);
		}

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strStatusTypeValues[4],
						objView_data.strValueForSST)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
						objView_data.strValueForUpdate1).clickOnSaveButton();

		String strApplicationTime2 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String strUpdateTime2 = objEventManagement1.getApplicationTime();
		System.out.println(strUpdateTime2);

		String[] strDateTime = strUpdateTime.split(" ");
		String[] strHourAndMin = strDateTime[2].split(":");
		String strMinute = objDate_Time_settings.addTimetoExisting(
				strHourAndMin[1], 1, "mm");
		String strCureentDate = objDate_Time_settings
				.getCurrentDate("MM/dd/yyyy");
		String strCurrentDate = objDate_Time_settings.getCurrentDate("yyyy-MM-dd");
		Thread.sleep(2000);
		objRegionDefault_page1.clickExcelOption();
		Thread.sleep(2000);

		objRegionDefault_page1.selectAndEnterDateAndTime(strCureentDate,
				strHourAndMin[0], strMinute).clickOnGenerateReportOption();

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

		String strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strHourAndMin[0]+":"
				+ strMinute + " Custom View Snapshot", strValue);

		String[] strUpdatedStatusTypeNames = {
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objTest_data.strComment, objTest_data.strLastUpdate,
				objTest_data.strUpdatedBy };

		String[] strUpdatedExcelValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strHyphen,objView_data.strHyphen,objView_data.strHyphen,"", strApplicationTime1,
				objUserdata.strFullName };

		String[] strSummaryValue = { objTest_data.strSummary,
				objView_data.strNotApplicable, objView_data.strNotApplicable,
				objView_data.strNEDOCVal,objView_data.strZero,objView_data.strZero, objView_data.strNotApplicable,"", "", "" };

		for (intCount = 1; intCount <= strUpdatedStatusTypeNames.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strUpdatedStatusTypeNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedExcelValues[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 4, intCount,
					strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);
		}

		String[] strSummaryStatusTypeNames = {
				objView_data.strStatusTypeSummary,
				objStatusTypes_data.strNDSTStatusTypeName };

		String[] strSummaryStatusTypeUpdatedValues = { objView_data.strTotal,
				objView_data.strNEDOCVal };

		for (intCount = 2; intCount <= (strSummaryStatusTypeNames.length)+1; intCount++) {
			strValue = objOffCommonFunc
					.readInfoExcel(objView_data.strSummaryTable, intCount, 1,
							strDownloadName1);
			assertEquals(strSummaryStatusTypeNames[intCount - 2], strValue);

			strValue = objOffCommonFunc
					.readInfoExcel(objView_data.strSummaryTable, intCount, 2,
							strDownloadName1);
			assertEquals(strSummaryStatusTypeUpdatedValues[intCount - 2],
					strValue);
		}

		String[] strDateTime2 = strUpdateTime2.split(" ");
		String[] strHourAndMin2 = strDateTime2[2].split(":");
		String strMinute1 = objDate_Time_settings.addTimetoExisting(
				strHourAndMin2[1], 1, "mm");
		Thread.sleep(2000);
		objRegionDefault_page1.clickExcelOption();
		Thread.sleep(2000);

		objRegionDefault_page1.selectAndEnterDateAndTime(strCureentDate,
				strHourAndMin2[0], strMinute1).clickOnGenerateReportOption();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		int intCount2 = 0;
		int intCount3 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed1);

				intCount3 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath1).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount3++;
					}

				} while (intCount3 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount2++;
			}
		} while (intCount2 < 60);


		strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName3);
		assertEquals("" + strCurrentDate + " " + strHourAndMin2[0]+":"
				+ strMinute1 + " Custom View Snapshot", strValue);

		String[] strUpdatedStatusTypeNames2 = {
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objTest_data.strComment, objTest_data.strLastUpdate,
				objTest_data.strUpdatedBy };

		String[] strUpdatedExcelValues2 = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForUpdate1,
				"", strApplicationTime2, objUserdata.strFullName };

		String[] strSummaryValue2 = { objTest_data.strSummary,
				objView_data.strZeroValue, objView_data.strZeroValue,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strZeroValue,
				"", "", "" };

		for (intCount = 1; intCount <= strUpdatedStatusTypeNames2.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName3);
			assertEquals(strUpdatedStatusTypeNames2[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName3);
			assertEquals(strUpdatedExcelValues2[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 4, intCount,
					strDownloadName3);
			assertEquals(strSummaryValue2[intCount - 1], strValue);

		}

		String[] strSummaryStatusTypeNames2 = {
				objView_data.strStatusTypeSummary,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName, };

		String[] strSummaryStatusTypeUpdatedValues2 = { objView_data.strTotal,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST };

		for (intCount = 2; intCount <= (strSummaryStatusTypeNames2.length)+1; intCount++) {
			strValue = objOffCommonFunc
					.readInfoExcel(objView_data.strSummaryTable, intCount, 1,
							strDownloadName3);
			assertEquals(strSummaryStatusTypeNames2[intCount - 2], strValue);

			strValue = objOffCommonFunc
					.readInfoExcel(objView_data.strSummaryTable, intCount, 2,
							strDownloadName3);
			assertEquals(strSummaryStatusTypeUpdatedValues2[intCount - 2],
					strValue);
		}
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that appropriate past view is displayed in ‘Event Status’ excel snapshot.  
	 * 'Date        : 14-Nov-2014 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/

	@Test(description = "Verify that appropriate past view is displayed in ‘Event Status’ excel snapshot. ")
	public void testHappyDay146592() throws Exception {
		gstrTCID = "146592";
		gstrTO = "Verify that user can generate 'excel' snapshot of ‘Event Status’ providing past date and time. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		Event_data objEvent_data = new Event_data();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
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

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Date_Time_settings objDts = new Date_Time_settings();

		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
	
		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

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

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.selectReportEventSnapshotOption()

				.selectReportStatusSnapshotOption()

				.clickSaveButton()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectReportStatusSnapshotOption()
				
				.selectReportEventSnapshotOption()
				
				.selectMaintainEventsOption()
				.selectMaintainAdHocEventsOption()
				.clickSaveButton();


		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objEvent_data.strEventName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnNextButton().selectResource(strResourceValue)
				.clickOnNextButton();

		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objEventManagement1
					.selectStatusTypeDuringAdhocEvents(strStatusTypeValues[i]);
		}

		objEventManagement1.clickOnNextButton().clickOnYesButton()

		.verifyEventName(objEvent_data.strEventName);
		
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyEventStatus();

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate);

		UpdateStatus_page1.enterNedocsUpdateValue(strStatusTypeValues[1],
				objView_data.strValueForNDST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForTST);

		UpdateStatus_page1.selectMSTUpdateValue(strStatusTypeValues[3],
				strStatusesValues[0]);

		UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strDateUpdateValue);

		UpdateStatus_page1.clickOnSaveButton();

		String strApplicationTime1 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(
				strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		Thread.sleep(180000);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyEventStatus();

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate1);

		UpdateStatus_page1.enterNedocsUpdateValue(strStatusTypeValues[1],
				objView_data.strValueForNDST1);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForTST1);

		UpdateStatus_page1.selectMSTUpdateValue(strStatusTypeValues[3],
				strStatusesValues[1]);

		UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST1);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strDateUpdateFutureValue);

		UpdateStatus_page1.clickOnSaveButton();

		Thread.sleep(5000);

		RegionDefault_page1.clickExcelOption();

		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");
		String strCurrentDate = dts.getCurrentDate("yyyy-MM-dd");
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour,
				strMinutes);

		Thread.sleep(2000);

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

		String strValue = "";

		String[] strUpdatedStatusTypeNames = {
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objTest_data.strComment, objTest_data.strLastUpdate,
				objTest_data.strUpdatedBy};

		String[] strUpdatedExcelValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"", strApplicationTime1, objUserdata.strFullName1};

		String[] strSummaryValue = { objTest_data.strSummary,
				objView_data.strNotApplicable, objView_data.strNotApplicable,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strNotApplicable,
				"", "", "" };
		
		strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strHour+":"
				+ strMinutes + " " + objEvent_data.strEventName
				+ " Event Snapshot", strValue);

		for (intCount = 1; intCount <= strUpdatedStatusTypeNames.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strUpdatedStatusTypeNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedExcelValues[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 4, intCount,
					strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);

		}

		String[] strSummaryStatusTypeNames = {
				objView_data.strStatusTypeSummary,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName, };

		String[] strSummaryStatusTypeUpdatedValues = { objView_data.strTotal,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST };

		for (intCount = 2; intCount <= strSummaryStatusTypeNames.length; intCount++) {
			strValue = objOffCommonFunc
					.readInfoExcel(objView_data.strSummaryTable, intCount, 1,
							strDownloadName1);
			assertEquals(strSummaryStatusTypeNames[intCount - 2], strValue);

			strValue = objOffCommonFunc
					.readInfoExcel(objView_data.strSummaryTable, intCount, 2,
							strDownloadName1);
			assertEquals(strSummaryStatusTypeUpdatedValues[intCount - 2],
					strValue);
		}
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that user can generate 'excel' snapshot of ‘Other Region View’ providing past time.  
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(enabled=false,description = "Verify that user can generate 'excel' snapshot of ‘Other Region View’ providing past time. ")
	public void testHappyDay146309() throws Exception {
		gstrTCID = "146309";
		gstrTO = "Verify that user can generate 'excel' snapshot of ‘Other Region View’ providing past time. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
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

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Date_Time_settings objDts = new Date_Time_settings();

		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strArkansasReg);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strstatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createSharedResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				// .clickAdvancedOptionAndExpand()
				//
				// .selectMaintainEventsOption()
				//
				// .selectReportEventSnapshotOption()
				//
				// .selectReportStatusSnapshotOption()

				.clickSaveButton();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.clickOnEditOfRegDefault()
					.clickOnResourcesTab()
					.selectResource(objResource_data.strResourceName)
					.clickNextButton();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList
				.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objRegionDefault.clickRegionLink();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strSetracReg);

		objRegionDefault.selectFrame();

		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectViewOtherRegView(objTest_data.strArkansasRegVal)

				.clickAdvancedOptionAndExpand()

				.selectReportStatusSnapshotOption()

				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objResource_data.strResourceName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[0]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateValue);

		UpdateStatus_page1.clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(
				strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");

		Thread.sleep(180000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate1);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST1);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST1);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[1]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST1);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateFutureValue);

		UpdateStatus_page1.clickOnSaveButton();

		objLogin1.clickLogOut();

		Thread.sleep(5000);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToRegUnderOtherRegions(objTest_data.strArkansasReg);

		objRegionDefault1
				.verifyParticularRegPageIsDisplayed(objTest_data.strArkansasReg);

		RegionDefault_page1.clickExcelOption();

		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");
		String strCurrentDate = objDts.getCurrentDate("yyyy-MM-dd");
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour,
				strMinutes);

		Thread.sleep(2000);

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

		String strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strHour+":"
				+ strMinutes + " Region Default View Snapshot", strValue);
	
		String[] strHeaderNames1 = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment" };

		String[] strUpdatedValues1 = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST, "" };

		for (intCount = 1; intCount <= (strHeaderNames1.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strHeaderNames1[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedValues1[intCount - 1], strValue);
		}
		
		gstrResult = "PASS";
	}

	/***************************************************************************************************************
	 * 'Description : Verify that user can generate 'excel' snapshot of ‘Other Region Event Detail View’ providing past time.   
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/

	@Test(enabled=false,description = "Verify that user can generate 'excel' snapshot of ‘Other Region Event Detail View’ providing past time.")
	public void testHappyDay146311() throws Exception {
		gstrTCID = "146311";
		gstrTO = "Verify that user can generate 'excel' snapshot of ‘Other Region Event Detail View’ providing past time.";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
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

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;
		
		String strDownloadName2 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed1 = "2ndTC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath1 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName3 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();

		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
	
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		objRegionDefault.selectFrame();
		
		objSelectRegion.selectRegionAndNavigate(objTest_data.strArkansasReg);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();
		
System.out.println(objStatusTypes_data.strDateStatusTypeName);
System.out.println(objResourceType_data.strResourceTypeName);
System.out.println(objResource_data.strResourceName);
System.out.println(objEvent_data.strEventName);
System.out.println(objUserdata.strNewUserName);
System.out.println(objUserdata.strNewUserName1);

		// RoleBased statustypes
		
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		
		objStatusTypeList
		.createSharedStatusType(objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);


		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createSharedResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();
		
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		
		objSelectRegion.selectRegionAndNavigate(objTest_data.strSetracReg);

		objRegionDefault.selectFrame();

		objUsersList_page
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectViewOtherRegView(objTest_data.strArkansasRegVal)
		.clickAdvancedOptionAndExpand()
		.selectReportEventSnapshotOption()
		.selectReportStatusSnapshotOption()
		.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue).clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyEventStatus();
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		String strFirst3StatusTypeVal[] = { strStatusTypeValues[0],
				strStatusTypeValues[1], strStatusTypeValues[2] };

		String strSec3StatusTypeVal[] = { strStatusTypeValues[3],
				strStatusTypeValues[4], strStatusTypeValues[5] };

		for (int i = 0; i < strFirst3StatusTypeVal.length; i++) {
			objUpdateStatus1.selectStatusTypes(strFirst3StatusTypeVal[i]);
		}

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strDateUpdateValue)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST)
				.clickOnCalculate()
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0]).clickOnSaveButton();

		String strApplicationTime1 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String strUpdateTime = objEventManagement1.getApplicationTime();
		System.out.println(strUpdateTime);

		Thread.sleep(120000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		for (int i = 0; i < strSec3StatusTypeVal.length; i++) {
			objUpdateStatus1.selectStatusTypes(strSec3StatusTypeVal[i]);
		}

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strStatusTypeValues[4],
						objView_data.strValueForSST)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
						objView_data.strValueForUpdate1).clickOnSaveButton();

		String strApplicationTime2 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String strUpdateTime2 = objEventManagement1.getApplicationTime();
		System.out.println(strUpdateTime2);

		String[] strDateTime = strUpdateTime.split(" ");
		String[] strHourAndMin = strDateTime[2].split(":");
		String strMinute = objDate_Time_settings.addTimetoExisting(
				strHourAndMin[1], 1, "mm");
		String strCureentDate = objDate_Time_settings
				.getCurrentDate("MM/dd/yyyy");
		String strCurrentDate = objDate_Time_settings.getCurrentDate("yyyy-MM-dd");
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToRegUnderOtherRegions(objTest_data.strArkansasReg);

		objRegionDefault1
				.verifyParticularRegPageIsDisplayed(objTest_data.strArkansasReg);

		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyEventStatus();
		
		objRegionDefault1.clickExcelOption();
		Thread.sleep(2000);

		objRegionDefault1.selectAndEnterDateAndTime(strCureentDate,
				strHourAndMin[0], strMinute).clickOnGenerateReportOption();

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
		
		String strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strHourAndMin[0]+":"
				+ strMinute + " "+objEvent_data.strEventName+" Event Snapshot", strValue);
	
		String[] strHeaderNames1 = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment" };

		String[] strUpdatedValues1 = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strHyphen,
				objView_data.strHyphen, objView_data.strHyphen, "" };

		for (intCount = 1; intCount <= (strHeaderNames1.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strHeaderNames1[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedValues1[intCount - 1], strValue);
		}

		String[] strDateTime2 = strUpdateTime2.split(" ");
		String[] strHourAndMin2 = strDateTime2[2].split(":");
		String strMinute1 = objDate_Time_settings.addTimetoExisting(
				strHourAndMin2[1], 1, "mm");
		Thread.sleep(2000);
		objRegionDefault1.clickExcelOption();
		Thread.sleep(2000);

		objRegionDefault1.selectAndEnterDateAndTime(strCureentDate,
				strHourAndMin2[0], strMinute1).clickOnGenerateReportOption();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		int intCount2 = 0;
		int intCount3 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed1);

				intCount3 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath1).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount3++;
					}

				} while (intCount3 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount2++;
			}
		} while (intCount2 < 60);

		strValue = objOffCommonFunc.readInfoExcel(
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strCurrentDate + " " + strHourAndMin2[0]
				+ strMinute1 + " "+objEvent_data.strEventName+" Event Snapshot", strValue);
	
		String[] strHeaderNames2 = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment" };

		String[] strUpdatedValues2 = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForUpdate1, "" };
		
		String[] strSummaryValue = { objTest_data.strSummary, objView_data.strNotApplicable,
				objView_data.strNotApplicable,objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,objView_data.strUpdatedValForSST,
				objView_data.strNotApplicable,"", "", ""};

		for (intCount = 1; intCount <= (strHeaderNames2.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName3);
			assertEquals(strHeaderNames2[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName3);
			assertEquals(strUpdatedValues2[intCount - 1], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 4, intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount-1], strValue);
		}
		

		String[] strSummaryStatusTypeNames = {objView_data.strStatusTypeSummary,  objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,};
		
		String[] strSummaryStatusTypeUpdatedValues = {objView_data.strTotal, objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,objView_data.strUpdatedValForSST};
		
		for( intCount = 2; intCount<=(strSummaryStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount,1, strDownloadName1);
			assertEquals(strSummaryStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount,2, strDownloadName1);
			assertEquals(strSummaryStatusTypeUpdatedValues[intCount-2], strValue);
		}	
		gstrResult = "PASS";
	}
}
