package requirementGroup.Reports;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import java.io.File;
import java.util.Properties;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusReason_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.CSVFunctions;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayStatusSummaryReport extends TestNG_UI_EXTENSIONS {

	public HappyDayStatusSummaryReport() throws Exception {
		super();
	}

	/***************************************************************************************************************
	 * 'Description : Verify that sub-resources are not available while
	 * generating 'Status Summary Report' 'Date : 11-Nov-2014 'Author : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that sub-resources are not available while generating 'Status Summary Report' ")
	public void testHappyDay151045() throws Exception {
		gstrTCID = "151045";
		gstrTO = "Verify that sub-resources are not available while generating 'Status Summary Report' ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

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
		String strSubResourceTypeValue[] = new String[1];
		String strSubResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Report objReport1 = new Report(this.driver1);

		System.out.println("-----Precondtion execution starts------");

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

		// Create Sub-Resource Type
		ResourceType_Page
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName,
						strstatusTypeValues)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

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

		Resource_Page.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName);

		Resource_Page
				.clickOnCreateNewSubResourceButton()

				// Create New Sub-Resource' screen is displayed
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton();

		Resource_Page
				.verSubResourceInResourceListPage(objResource_data.strSubResourceName);

		strSubResourceValue[0] = Resource_Page
				.getSubResourceValue(objResource_data.strSubResourceName);

		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.selectRunReportRight(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectReportStatusSummaryOption()

				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objnNavigationToSubMenus.navigateToViews();


		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

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

		objnNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink();

		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);

		objReport1.verifyResourceNameNotDisplayed(strSubResourceValue[0]);

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description : Verify that Status Type is retrieved when searched
	 * providing its name in Status Summary Report page. 'Precondition : 'Date :
	 * 06-Jan-2015 'Author : Anil
	 * '-----------------------------------------------------------------------------------
	 * - 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that Status Type is retrieved when searched providing its name in Status Summary Report page.")
	public void testHappyDay185073() throws Exception {

		gstrTCID = "185073";//Old TC ID: 151539 - Modified TC because admin user cannot generate Status Summary Report
		gstrTO = "  Verify that Status Type is retrieved when searched providing its name in Status Summary Report page.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Resource_data objResource_data = new Resource_data();
		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		String strStatusesValues[] = new String[2];

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strNewStatusTypeValues[] = new String[2];

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + gstrTCID + "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.verAndCreate15MultiStatusTypes();

		String[] strStatusTypesNames = objStatusTypeList
				.getMultiStatusTypeNames();

		String[] strStatusTypeValues = new String[strStatusTypesNames.length];
		for (int i = 0; i < strStatusTypesNames.length; i++) {
			strStatusTypeValues[i] = objStatusTypeList
					.getStatusValue(strStatusTypesNames[i]);
		}

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

		System.out.println(objStatusTypes_data.strMSTStatusTypeName);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList
				.clickOnReturnToStatusTypeList()
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti3,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strNewStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		strNewStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		Thread.sleep(5000);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		String[] strAllStatusVal = ArrayUtils.addAll(strNewStatusTypeValues,
				strStatusTypeValues);

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllStatusVal);

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
		
		System.out.println(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = dts.timeNow("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		objReport1.enterReportStartDate(strApplicationTime)
				.enterReportEndDate(strApplicationTime)
				.selectResourceValue(strResourceValue[0])
				.clickOnNextStepBtn()
				.verifyStatusTypesIsDisplayed(
						objStatusTypes_data.strMSTStatusTypeName)
				.verifyStatusTypesIsDisplayed(
						objStatusTypes_data.strMSTStatusTypeName1)
				.selectStatusType(objStatusTypes_data.strMSTStatusTypeName1)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description :  Verify that all the status Types associated to a Resource Type are displayed in Status Summary Report page.
	 * generating 'Status Summary Report' 
	 * 'Date : 29-Apr-2014 
	 * 'Author : Sangappa.k
	 ***************************************************************************************************************/

	@Test(enabled = false, description = "Verify that all the status Types associated to a Resource Type are displayed in Status Summary Report page.")
	public void testHappyDay151502() throws Exception {
		
		gstrTCID = "151502";
		gstrTO = " Verify that all the status Types associated to a Resource Type are displayed in Status Summary Report page.";

		Login_data objTest_data = new Login_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		String strTimeText = objDate_Time_settings
				.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		
		Resource objResource_Page = new Resource(this.driver1);
	
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

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

		String strResourceValue[] = new String[1];

		String strMultiStatusTypeValues[] = new String[6];

		String strStatusesValues[] = new String[12];

		String strResourceTypeValue[] = new String[1];

		String strEventTemplateValue[] = new String[1];

		Date_Time_settings dts = new Date_Time_settings();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		boolean blnTest = false;

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// shared

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti3,
				objStatusTypes_data.strStatusColor);
		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		// private

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti4,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[4] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti4);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti5,
				objStatusTypes_data.strStatusColor);
		strStatusesValues[5] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti5);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);

		// private with event only

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName3,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti5,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[6] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti5);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti6,
				objStatusTypes_data.strStatusColor);
		strStatusesValues[7] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti6);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName3);

		// shred with event

		objStatusTypeList.createSharedStatusTypeWithEvent(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName4,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti7,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[8] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti7);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti8,
				objStatusTypes_data.strStatusColor);
		strStatusesValues[9] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti8);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName4);

		// role with event

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName5,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti9,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[10] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti9);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti10,
				objStatusTypes_data.strStatusColor);
		strStatusesValues[11] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti10);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName5);

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strMultiStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource1
		objResource_Page.navigateToResourceListPage();

		objResource_Page.createResourceWithAddress(
				objResource_data.strResourceName,
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

		objResource_Page
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strMultiStatusTypeValues).clickOnSaveButton();

		// User
		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println("New User name  " + objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strMultiStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		System.out.println("Event Templet Name  "
				+ objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondtion ends and test execution starts------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		System.out.println("Event name   " + objEvent_data.strEventName);
		System.out.println("Event Tittle " + objEvent_data.strEventDescription);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);
	
		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		// Update St

		objUpdateStatus.clickOnSelectAll();

		objUpdateStatus.selectMSTUpdateValue(strMultiStatusTypeValues[0],
				strStatusesValues[0]);

		objUpdateStatus.selectMSTUpdateValue(strMultiStatusTypeValues[1],
				strStatusesValues[2]);

		objUpdateStatus.selectMSTUpdateValue(strMultiStatusTypeValues[2],
				strStatusesValues[4]);

		objUpdateStatus.selectMSTUpdateValue(strMultiStatusTypeValues[3],
				strStatusesValues[6]);

		objUpdateStatus.selectMSTUpdateValue(strMultiStatusTypeValues[4],
				strStatusesValues[8]);

		objUpdateStatus.selectMSTUpdateValue(strMultiStatusTypeValues[5],
				strStatusesValues[10])

		.clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		System.out.println("Updated time  " + strUpdatedTime);

		objNavigationToSubMenus1.clickOnStatusReports();

		String strDate = dts.timeNow("MM/dd/yyyy");

		objReport1.clickOnStatusSummaryLink();

		System.out.println("Start date & end Date  " + strDate);

		objReport1.verStatusSummeryReportPgeIsDisplayed()
				.enterReportStartDate(strDate).enterReportEndDate(strDate)
				.selectResources(strResourceValue[0]).clickOnNextStepBtn();
		Thread.sleep(5000);

		objReport1.selectAllStatustypesChkBox()
				.verEventStatusTypeNotDisplayed(strMultiStatusTypeValues[3])
				.verEventStatusTypeNotDisplayed(strMultiStatusTypeValues[4])
				.verEventStatusTypeNotDisplayed(strMultiStatusTypeValues[5])
				.clickOnGenerateReportBtn();

		Thread.sleep(10000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		System.out.println("Auto It path " + strAutoItPath);
		System.out.println("downlaode name " + strDownloadName);

		objLogin1.clickLogOut();

		// String strUpdatedTime = strEventStartTime;
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
					objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName1 + ", "
							+ objStatusTypes_data.strMSTStatusTypeName2,
					strEventStartTime,
					strEventEndTime,
					objReport_data.ExternalIP,
					strUpdate,
					strUpdatedTime,
					strDownloadName,
					"",
					"",
					"",
					"",
					"",
					"",
					strStatusesValues[0] + ", " + strStatusesValues[2] + ", "
							+ strStatusesValues[4] };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		gstrResult = "PASS";
	}

	
	/*************************************************************************************
	 * 'Description 	: Update status of a multi private status type pMST added at the resource type level 
	 * 						for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without 
	 * 						any role can view the status type in the generated 'Status Summary Report'. 
	 * 'Precondition	: 
	 * 'Date 			: 22-Dec-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Update status of a multi private status type pMST added at the resource type level "
			+ "for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and "
			+ "without any role can view the status type in the generated 'Status Summary Report'. ")
	public void testHappyDay63285() throws Exception {

		gstrTCID = "63285";
		gstrTO = "Update status of a multi private status type pMST added at the resource type level "
				+ "for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and "
				+ "without any role can view the status type in the generated 'Status Summary Report'. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Report_data objReport_data = new Report_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Report objReport1 = new Report(this.driver1);

		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + gstrTCID + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + gstrTCID + "_2_" + strTimeText
				+ fileType1;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectViewResourceRights(objResource_data.strResourceName)
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();
		objUpdateStatus1.selectStatusTypes(strStatusTypeValues[0])
		.selectMSTUpdateValue(strStatusTypeValues[0],
				strStatusesValues[0]).clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		String updatedtime = "(" + strAppTime + " " + objLogindata.timeZone
				+ ")";
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnStatusReports();

		String strDate = dts.timeNow("MM/dd/yyyy");

		objReport1.clickOnStatusSummaryLink();

		System.out.println("Start date & end Date  " + strDate);

		objReport1.verStatusSummeryReportPgeIsDisplayed()
				.enterReportStartDate(strDate).enterReportEndDate(strDate)
				.selectResources(strResourceValue[0]).clickOnNextStepBtn();
		
		objReport1.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();

		objNavigationToSubmenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink().enterReportStartDate(strDate)
				.enterReportEndDate(strDate)
				.selectDataFileCommaSepatatedCSVRadioBtn()
				.selectResources(strResourceValue[0]).clickOnNextStepBtn()
				.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file2 = new File(strDownloadName1);
		boolean strCsv1 = file2.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + "/" +objUserdata.strNewUserName1 + "/"
									+ objUserdata.strNewPassword,
					objLogindata.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", updatedtime,
					strDownloadName, "", "",
					objStatusTypes_data.strStatusNameInMulti, strDate, strDate,
					"" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");

			if (strCsv1) {
				String[] strTestData2 = {
						gstrTCID,
						Login_data.strBuildName,
						objUserdata.strNewUserName + "/"
								+ objUserdata.strNewPassword+ "/" +objUserdata.strNewUserName1 + "/"
										+ objUserdata.strNewPassword,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName, "", "", "", "",
						objReport_data.ExternalIP, strDownloadName1, "", "", "" };

				objOffCommonFunc.writeResultData(strTestData2,
						strPartialAutoResultsPath, "CSVDetails");
			}

			objLogin1.clickLogOut();

			if (strPdf1 && strCsv1) {
				gstrResult = "PASS";
			} else {
				gstrResult = "FAIL";
			}
		}
	}
	
	/**********************************************************************************************************
	'Description : Update status of a multi status type MST added at the resource type level for a resource RS.
	               Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with 
	               only view right for MST can view the status of MST in the status summary report.
	'Date	 	 : 22-Dec-2014
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***********************************************************************************************************/
	@Test(description = " Update status of a multi status type MST added at the resource type level for a resource RS."
			+ " Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with only "
			+ "view right for MST can view the status of MST in the status summary report.")
	public void testHappyDay63272() throws Exception {

		gstrTCID = "63272";
		gstrTO = " Update status of a multi status type MST added at the resource type level for a resource RS. "
				+ "Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with "
				+ "only view right for MST can view the status of MST in the status summary report.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		CSVFunctions objCSVFunctions = new CSVFunctions();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + gstrTCID + "1_" + strTimeText
				+ fileType;
		
		String strDownloadName2 = file + "\\" + gstrTCID + "3_" + strTimeText
				+ fileType1;
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.createStatusType(objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
			   .clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1.selectStatusTypes(strstatusTypeValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0]);

		objUpdateStatus_Page1.clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		String updatedtime = "(" + strAppTime + " " + objTest_data.timeZone
				+ ")";

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti, updatedtime);

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
				  .selectResources(strResourceValue[0])
				  .clickOnNextStepBtn()
				  .selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
				
		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();
		
		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", updatedtime,
					strDownloadName, "", objStatusReason_data.strReasonName,
					objStatuTypes_data.strStatusNameInMulti, strCurrentDate,
					strCurrentDate, "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
			  	  .selectDataFileCommaSepatatedCSVRadioBtn()
				  .selectResources(strResourceValue[0])
				  .clickOnNextStepBtn()
				  .selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file3 = new File(strDownloadName2);
		boolean strCsv1 = file3.exists();
		
		String[][] strReportData = {
				{ "Status Summary", "**", "**", "**", "**" },
				{ "Status Type", "Resource", "Status", "Total Hours",
						"% of Total Hours" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName,
						objStatuTypes_data.strStatusNameInMulti, "\\d+\\.\\d+",
						"\\d+" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName,
						objStatuTypes_data.strStatusNameInMulti1,
						"\\d+\\.\\d+", "\\d+" },
				{ "**", "**", "**", "**", "**" },
				{ "Aggregate Status Summary", "**", "**", "**", "**" },
				{ "Status Type", "Resource Type", "Status", "Total Hours",
						"% of Total Hours" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strStatusNameInMulti, "\\d+\\.\\d+",
						"\\d+" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strStatusNameInMulti2,
						"\\d+\\.\\d+", "\\d+" } };
		
	//	objCSVFunctions.verifyMonthlyAssesmentCSVData(strDownloadName2, strReportData);

		if (strCsv1) {
			String[] strTestData2 = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "", "",
					objReport_data.ExternalIP, strDownloadName2, "", "", "" };

			objOffCommonFunc.writeResultData(strTestData2,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	 * 'Description 	:  Add a multi status type MST back to resource RS and update the status 
	 * 						value of RS, generate the ‘Status Summary Report’ and verify that the data is displayed 
	 * 						appropriately in the report
	 * 'Precondition	: 
	 * 'Date 			: 22-Dec-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Add a multi status type MST back to resource RS and update the status value of RS, "
			+ "generate the ‘Status Summary Report’ and verify that the data is displayed appropriately in the report")
	public void testHappyDay63245() throws Exception {

		gstrTCID = "63245";
		gstrTO = " Add a multi status type MST back to resource RS and update the status value of RS, "
			+ "generate the ‘Status Summary Report’ and verify that the data is displayed appropriately in the report";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Report_data objReport_data = new Report_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + gstrTCID + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + gstrTCID + "2_" + strTimeText
				+ fileType1;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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
		
		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
		.selectStatusType(strStatusTypeValues1)
		.clickOnSaveButton();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.selectSetupResourceOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();
		objUpdateStatus1.selectStatusTypes(strStatusTypeValues1[0])
		.selectMSTUpdateValue(strStatusTypeValues1[0],
				strStatusesValues[0]).clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		String updatedtime = "(" + strAppTime + " " + objLogindata.timeZone
				+ ")";
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
		objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();

		objResource1.navigateToResourceListPageNew()
		.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
		.deselectStatusType(strStatusTypeValues1)
		.clickOnSaveButton()
		.verResourceListPageIsDisplayed()
		.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
		.selectStatusType(strStatusTypeValues1)
		.clickOnSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();
		objUpdateStatus1.selectStatusTypes(strStatusTypeValues1[0])
		.selectMSTUpdateValue(strStatusTypeValues1[0],
				strStatusesValues[1]).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		objNavigationToSubmenus1.clickOnStatusReports();

		String strDate = dts.timeNow("MM/dd/yyyy");

		objReport1.clickOnStatusSummaryLink();

		System.out.println("Start date & end Date  " + strDate);

		objReport1.verStatusSummeryReportPgeIsDisplayed()
				.enterReportStartDate(strDate).enterReportEndDate(strDate)
				.selectResources(strResourceValue[0]).clickOnNextStepBtn();
		
		objReport1.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();

		objNavigationToSubmenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink().enterReportStartDate(strDate)
				.enterReportEndDate(strDate)
				.selectDataFileCommaSepatatedCSVRadioBtn()
				.selectResources(strResourceValue[0]).clickOnNextStepBtn()
				.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file2 = new File(strDownloadName1);
		boolean strCsv1 = file2.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogindata.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", updatedtime,
					strDownloadName, "", "",
					objStatusTypes_data.strStatusNameInMulti, strDate, strDate,
					"" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");

			if (strCsv1) {
				String[] strTestData2 = {
						gstrTCID,
						Login_data.strBuildName,
						objUserdata.strNewUserName + "/"
								+ objUserdata.strNewPassword,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName, "", "", "", "",
						objReport_data.ExternalIP, strDownloadName1, "", "", "" };

				objOffCommonFunc.writeResultData(strTestData2,
						strPartialAutoResultsPath, "CSVDetails");
			}
			objLogin1.clickLogOut();

			if (strPdf1 && strCsv1) {
				gstrResult = "PASS";
			} else {
				gstrResult = "FAIL";
			}
		}
	}
	
	/**********************************************************************************************************
	'Description : Verify that the details of status type are not displayed in the 'Status Summary' report for a perticular
	               resource for which it is refined.
	'Date	 	 : 23-Dec-2014
	'Author		 : Sangappa K
	'----------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***********************************************************************************************************/
	@Test(description = "Verify that the details of status type are not displayed in the 'Status Summary' report for a perticular"
			+ " resource for which it is refined.")
	public void testHappyDay63284() throws Exception {

		gstrTCID ="63284";
		gstrTO = "Verify that the details of status type are not displayed in the 'Status Summary' report for a perticular resource "
				+ "for which it is refined.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		CSVFunctions objCSVFunctions = new CSVFunctions();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strstatusTypeValues1[] = new String[2];
		String strstatusTypeValues2[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[6];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + gstrTCID + "1_" + strTimeText
				+ fileType;

		String strDownloadName2 = file + "\\" + gstrTCID + "3_" + strTimeText
				+ fileType1;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// Mst1

		objStatusTypeList
				.createStatusType(objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Mst2

		objStatusTypeList
				.createStatusType(objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName1,
						objStatuTypes_data.strStatusDescription)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti2,
						objStatuTypes_data.strStatusColor)

				.createNewStatus(objStatuTypes_data.strStatusNameInMulti3,
						objStatuTypes_data.strStatusColor);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti2);

		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		// MSt3

		objStatusTypeList
				.createStatusType(objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName2,
						objStatuTypes_data.strStatusDescription)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti4,
						objStatuTypes_data.strStatusColor)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti5,
						objStatuTypes_data.strStatusColor);

		strStatusesValues[4] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti4);

		strStatusesValues[5] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti5);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName2);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation Rs1
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

		System.out.println(objResource_data.strResourceName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Resource creation Rs2
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName1)
				.verEditResourceLevelStatusTypesPageisDisplayed()
				.selectStatusType(strstatusTypeValues2)
				.clickOnSaveButton()
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.verEditResourceLevelStatusTypesPageisDisplayed()
				.selectStatusType(strstatusTypeValues2).clickOnSaveButton();

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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectRunReportsCheckBox(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1.clickOnSelectAll()

		.selectMSTUpdateValue(strstatusTypeValues1[0], strStatusesValues[0])

		.selectMSTUpdateValue(strstatusTypeValues1[1], strStatusesValues[3])

		.selectMSTUpdateValue(strstatusTypeValues2[0], strStatusesValues[5])

		.clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		String updatedtime = "(" + strAppTime + " " + objTest_data.timeZone
				+ ")";

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti, updatedtime);
		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti3, updatedtime);
		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti5, updatedtime);

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		String[] strRefineSt1 = { strstatusTypeValues1[1] };
		String[] strRefineSt2 = { strstatusTypeValues2[0] };

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)

				.clickRefineLinkOfViewResource(objResource_data.strResourceName)
				.selectFrameOfRefineVisibleStatusTypes()
				.deselectStatusTypesInRefine(strRefineSt1)
				.deselectStatusTypesInRefine(strRefineSt2)

				.clickSaveChangesButtonInRefine().selectFrame()
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1]).clickOnNextStepBtn()
				.selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.selectStatusType(objStatuTypes_data.strMSTStatusTypeName1)
				.selectStatusType(objStatuTypes_data.strMSTStatusTypeName2)
				.clickOnGenerateReportBtn();
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
				
		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();
		
		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName, "", "",
					objResourceType_data.strResourceTypeName,
					"Under 'Aggregate on resource type' section:"+
                    "1. Both resource "+objResource_data.strResourceName+"'s and "+objResource_data.strResourceName1+" 's data is included for "+objStatuTypes_data.strStatusNameInMulti+"."+
                    "2. Only resource "+objResource_data.strResourceName1+"'s data is included for "+objStatuTypes_data.strStatusNameInMulti1+" and "+objStatuTypes_data.strStatusNameInMulti2+". "+
					objResource_data.strResourceName,
					objResource_data.strResourceName1,
					objStatuTypes_data.strMSTStatusTypeName, "", "",
					objStatuTypes_data.strMSTStatusTypeName1, "", "",
					objStatuTypes_data.strMSTStatusTypeName2, "", "",
					objReport_data.ExternalIP, "", "", updatedtime,
					strDownloadName, "", objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusNameInMulti1,
					objStatuTypes_data.strStatusNameInMulti2,
					objStatuTypes_data.strStatusNameInMulti3,
					objStatuTypes_data.strStatusNameInMulti4,
					objStatuTypes_data.strStatusNameInMulti5, strCurrentDate,
					strCurrentDate, "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
			  	  .selectDataFileCommaSepatatedCSVRadioBtn()
				   .selectResources(strResourceValue[0])
				   .selectResources(strResourceValue[1])
				  .clickOnNextStepBtn()
				  .selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .selectStatusType(objStatuTypes_data.strMSTStatusTypeName1)
				  .selectStatusType(objStatuTypes_data.strMSTStatusTypeName2)
		          .clickOnGenerateReportBtn();

		Thread.sleep(5000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
	

		File file3 = new File(strDownloadName2);
		boolean strCsv1 = file3.exists();
		
		
		String[] strCsvData = {
				objStatuTypes_data.strMSTStatusTypeName + ","
						+ objResource_data.strResourceName + ","
						+ objStatuTypes_data.strStatusNameInMulti1,

				objStatuTypes_data.strMSTStatusTypeName + ","
						+ objResource_data.strResourceName + ","
						+ objStatuTypes_data.strStatusNameInMulti,

				objStatuTypes_data.strMSTStatusTypeName + ","
						+ objResource_data.strResourceName1 + ","
						+ objStatuTypes_data.strStatusNameInMulti1,

				objStatuTypes_data.strMSTStatusTypeName + ","
						+ objResource_data.strResourceName1 + ","
						+ objStatuTypes_data.strStatusNameInMulti,

				objStatuTypes_data.strMSTStatusTypeName1 + ","
						+ objResource_data.strResourceName1 + ","
						+ objStatuTypes_data.strStatusNameInMulti2,

				objStatuTypes_data.strMSTStatusTypeName1 + ","
						+ objResource_data.strResourceName1 + ","
						+ objStatuTypes_data.strStatusNameInMulti3,

				objStatuTypes_data.strMSTStatusTypeName2 + ","
						+ objResource_data.strResourceName1 + ","
						+ objStatuTypes_data.strStatusNameInMulti4,

				objStatuTypes_data.strMSTStatusTypeName2 + ","
						+ objResource_data.strResourceName1 + ","
						+ objStatuTypes_data.strStatusNameInMulti5 };

		/*for(int intCount=0;intCount<=strCsvData.length-1;intCount++){
		
		String strCapturedCSVData=objCSVFunctions.readCSVFileData(strDownloadName2,intCount+4);
				
		assertTrue(strCapturedCSVData.startsWith(strCsvData[intCount]), strCsvData[intCount]+"  is not exist in generatted report Or data is not captured properly from csv file");
		
		}*/
		
		if (strCsv1) {
			String[] strTestData2 = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName + ","
							+ objResource_data.strResourceName + ","
							+ objStatuTypes_data.strStatusNameInMulti1,

					objStatuTypes_data.strMSTStatusTypeName + ","
							+ objResource_data.strResourceName + ","
							+ objStatuTypes_data.strStatusNameInMulti,

					objStatuTypes_data.strMSTStatusTypeName + ","
							+ objResource_data.strResourceName1 + ","
							+ objStatuTypes_data.strStatusNameInMulti1,

					objStatuTypes_data.strMSTStatusTypeName + ","
							+ objResource_data.strResourceName1 + ","
							+ objStatuTypes_data.strStatusNameInMulti,

					objStatuTypes_data.strMSTStatusTypeName1 + ","
							+ objResource_data.strResourceName1 + ","
							+ objStatuTypes_data.strStatusNameInMulti2,

					objStatuTypes_data.strMSTStatusTypeName1 + ","
							+ objResource_data.strResourceName1 + ","
							+ objStatuTypes_data.strStatusNameInMulti3,

					objStatuTypes_data.strMSTStatusTypeName2 + ","
							+ objResource_data.strResourceName1 + ","
							+ objStatuTypes_data.strStatusNameInMulti4,

					objStatuTypes_data.strMSTStatusTypeName2 + ","
							+ objResource_data.strResourceName1 + ","
							+ objStatuTypes_data.strStatusNameInMulti5, "", "",
					"", "", objReport_data.ExternalIP, strDownloadName2, "",
					"", "" };

			objOffCommonFunc.writeResultData(strTestData2,
					strPartialAutoResultsPath, "CSVDetails");
		}
		
		
		String[][] strReportData = {
				{ "Status Summary", "**", "**", "**", "**" },
				{ "Status Type", "Resource", "Status", "Total Hours",
						"% of Total Hours" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName,
						objStatuTypes_data.strStatusNameInMulti, "\\d+\\.\\d+",
						"\\d+" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName,
						objStatuTypes_data.strStatusNameInMulti1,
						"\\d+\\.\\d+", "\\d+" },
				{ "**", "**", "**", "**", "**" },
				{ "Aggregate Status Summary", "**", "**", "**", "**" },
				{ "Status Type", "Resource Type", "Status", "Total Hours",
						"% of Total Hours" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strStatusNameInMulti, "\\d+\\.\\d+",
						"\\d+" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strStatusNameInMulti2,
						"\\d+\\.\\d+", "\\d+" } };
		
	//	objCSVFunctions.verifyMonthlyAssesmentCSVData(strDownloadName2, strReportData);
		
		objLogin1.clickLogOut();

		if(strCsv1&&strPdf1)
		{
		gstrResult = "PASS";
		}
		else
		{
		gstrResult = "FAIL";
		}

	}
	
	
	/**********************************************************************************************************
	'Description : Update status of a multi status type MST added at the resource level for a resource RS. 
					Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with 
					only view right for MST can view the status of MST in the status summary report. 
	'Date	 	 : 07-Jan-2015
	'Author		 : Anil
	'----------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***********************************************************************************************************/
	@Test(description = "Update status of a multi status type MST added at the resource level for a resource RS."+ 
					"Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with "+ 
					"only view right for MST can view the status of MST in the status summary report. ")
	public void testHappyDay86872() throws Exception {

		gstrTCID = "86872";
		gstrTO =  "Update status of a multi status type MST added at the resource level for a resource RS."+ 
				"Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with "+ 
				"only view right for MST can view the status of MST in the status summary report. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		CSVFunctions objCSVFunctions = new CSVFunctions();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strstatusTypeValues1[] = new String[1];
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + gstrTCID + "1_" + strTimeText
				+ fileType;
		
		String strDownloadName2 = file + "\\" + gstrTCID + "3_" + strTimeText
				+ fileType1;
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.createStatusType(objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList
		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);
			
		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

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

		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource.selectStatusType(strstatusTypeValues).clickOnSaveButton();
		
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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
			   .clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1.selectStatusTypes(strstatusTypeValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0]);

		objUpdateStatus_Page1.clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		String updatedtime = "(" + strAppTime + " " + objTest_data.timeZone
				+ ")";

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti, updatedtime);

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
				  .selectResources(strResourceValue[0])
				  .clickOnNextStepBtn()
				  .selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
				
		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();
		
		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", updatedtime,
					strDownloadName, "", objStatusReason_data.strReasonName,
					objStatuTypes_data.strStatusNameInMulti, strCurrentDate,
					strCurrentDate, "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
			  	  .selectDataFileCommaSepatatedCSVRadioBtn()
				  .selectResources(strResourceValue[0])
				  .clickOnNextStepBtn()
				  .selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file3 = new File(strDownloadName2);
		
		
		boolean strCsv1 = file3.exists();
		
		String[][] strReportData = {
				{ "Status Summary", "**", "**", "**", "**" },
				{ "Status Type", "Resource", "Status", "Total Hours",
						"% of Total Hours" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName,
						objStatuTypes_data.strStatusNameInMulti, "\\d+\\.\\d+",
						"\\d+" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName,
						objStatuTypes_data.strStatusNameInMulti1,
						"\\d+\\.\\d+", "\\d+" },
				{ "**", "**", "**", "**", "**" },
				{ "Aggregate Status Summary", "**", "**", "**", "**" },
				{ "Status Type", "Resource Type", "Status", "Total Hours",
						"% of Total Hours" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strStatusNameInMulti, "\\d+\\.\\d+",
						"\\d+" },
				{ objStatuTypes_data.strMSTStatusTypeName,
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strStatusNameInMulti2,
						"\\d+\\.\\d+", "\\d+" } };
		
		
		if (strCsv1) {
			String[] strTestData2 = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "", "",
					objReport_data.ExternalIP, strDownloadName2, "", "", "" };

			objOffCommonFunc.writeResultData(strTestData2,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objCSVFunctions.verifyMonthlyAssesmentCSVData(strDownloadName2, strReportData);/*EMS-1393*/

		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}	

}
			