package requirementGroup.Reports;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusReason_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusReasonList;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayStatusReasonSummary extends TestNG_UI_EXTENSIONS {

	public HappyDayStatusReasonSummary() throws Exception {
		super();
	}

	/***************************************************************************************************************
	 * 'Description : Verify that sub-resources are not available while generating 'Status Summary Report' 
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that sub-resources are not available while generating 'Status Reason Summary' ")
	public void testHappyDay151048() throws Exception {
		gstrTCID = "151048";
		gstrTO = "Verify that sub-resources are not available while generating 'Status Reason Summary' ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);

		
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		Report_data objReport_data = new Report_data();
		Date_Time_settings dts = new Date_Time_settings();
		
		ResourceType ResourceType_Page = new ResourceType(this.driver1);		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[3];
		String strstatusesValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strSubResourceValue[] = new String[1];
		String strReasonVal[] = new String[1];
		
		Login objLogin1 = new Login(this.driver1);
		
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Report objReport1 = new Report(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		
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
		
		String strDownloadName1 = file + "\\" + gstrTCID + "1_" + strTimeText
				+ fileType1;
		
		System.out.println("-----Precondtion execution starts------");
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithReason(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, strReasonVal)
				
		.createNewStatusWithReason(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor, strReasonVal)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);	
		
		strstatusesValues[0] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti);
				
		
		objStatusTypeList.createNewStatusWithReason(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor, strReasonVal)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);	
		
		strstatusesValues[1] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
						
		// Private status types
		objStatusTypeList.createPrivateStatusTypeWithReason(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, strReasonVal)
				
		.createNewStatusWithReason(objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor, strReasonVal)
				
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti2);	
		
		strstatusesValues[2] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti2);
				
		
		objStatusTypeList.createNewStatusWithReason(objStatusTypes_data.strStatusNameInMulti3,
				objStatusTypes_data.strStatusColor, strReasonVal)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti3);	
		
		strstatusesValues[3] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti3);

		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpMSTStatusTypeName);
		
		// Shared status types
		objStatusTypeList.createSharedStatusTypeWithReason(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription, strReasonVal)
				
		.createNewStatusWithReason(objStatusTypes_data.strStatusNameInMulti4,
				objStatusTypes_data.strStatusColor, strReasonVal)
				
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti4);	
		
		strstatusesValues[4] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti4);
				
		
		objStatusTypeList.createNewStatusWithReason(objStatusTypes_data.strStatusNameInMulti5,
				objStatusTypes_data.strStatusColor, strReasonVal)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti5);	
		
		strstatusesValues[5] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti5);

		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);
		
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
		
		//Create New Sub-Resource' screen is displayed
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

		Resource_Page.verSubResourceInResourceListPage(objResource_data.strSubResourceName);
		
		strSubResourceValue[0]= Resource_Page.getSubResourceValue(objResource_data.strSubResourceName);
		
		UsersList_page
		.navigateToUsersNew()

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		
		.selectFirstRole()
						
		.selectUpdateStatusOfResource(objResource_data.strResourceName)

		.selectRunReportRight(objResource_data.strResourceName)
		
		.clickAdvancedOptionAndExpand()
		
		.selectReportStatusReasonSummaryOption()
		
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();

		objnNavigationToSubMenus.navigateToViews();
		
		String[] strStatusTypeNames = {
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName2};
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
//		objViewsList.clickCreateNewViewButton()
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);
//
//
//		
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//		
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
//	
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		UpdateStatus_page1.clickOnSelectAll();
				
		Thread.sleep(3000);
		    
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[0], strstatusesValues[0]);
	 
	    UpdateStatus_page1.selectMSTReasonValue(strReasonVal[0], strstatusTypeValues[0],
	    		strstatusesValues[0]);
		
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[1], strstatusesValues[2]);
	    
	    UpdateStatus_page1.selectMSTReasonValue(strReasonVal[0], strstatusTypeValues[1],
	    		strstatusesValues[2]);
	    
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[2], strstatusesValues[4]);
	    
	    UpdateStatus_page1.selectMSTReasonValue(strReasonVal[0], strstatusTypeValues[2],
	    		strstatusesValues[4]);
	    
	    UpdateStatus_page1.clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTime();
		
		String strCurrentYear = dts.timeNow("yyyy");
		
		strApplicationTime = strApplicationTime+" "+strCurrentYear;
		
		strApplicationTime = dts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy");
		
	    objnNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1.verifyResourceNameNotDisplayed(strSubResourceValue[0]);
		
		objReport1.enterReportStartDate(strApplicationTime)
		  .enterReportEndDate(strApplicationTime)
		  .selectResources(strResourceValue[0]).clickOnNextBtn()
		  .selStatusType(objStatusTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .selStatusReason(strReasonVal[0], strstatusesValues[0])
		  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

	    objnNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.enterReportStartDate(strApplicationTime)
		  .enterReportEndDate(strApplicationTime)
		  .selectDataFileCommaSepatatedCSVRadioBtn()
		  .selectResources(strResourceValue[0]).clickOnNextBtn()
		  .selStatusType(objStatusTypes_data.strpMSTStatusTypeName)
		  .clickOnNextBtn()
		  .selStatusReason(strReasonVal[0], strstatusesValues[2])
		  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		gstrResult = "PASS";
	}
	
	/*********************************************************************************
	'Description : Generate 'Status Reason Summary report' in PDF format and verify that
	 				the report displays correct data
	'Precondition:
	'Date	 	 : 11-Feb-2016
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Generate 'Status Reason Summary report' in PDF format and verify that"
			+ " the report displays correct data")
	public void testHappyDay103964() throws Exception {

		gstrTCID = "103964";
		gstrTO = "Generate 'Status Reason Summary report' in PDF format and verify that the "
				+ "report displays correct data";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		StatusReason_data objStatusReason_data = new StatusReason_data();

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[4];
		String strStatusReasonValues[] = new String[3];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

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
		String strDownloadName = file + "\\" + gstrTCID + "_1" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + gstrTCID + "_2" + strTimeText
				+ fileType;
		
		String strDownloadName2 = file + "\\" + gstrTCID + "_3" + strTimeText
				+ fileType;

		String strDownloadName3 = file + "\\" + gstrTCID + "_4" + strTimeText
				+ fileType;
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strStatusReasonValues[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);
		
		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);
		
		strStatusReasonValues[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);
	
		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName2,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);
		
		strStatusReasonValues[2] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName2);
		
		objStatusTypeList.navigateToStatusTypeListNew();
		
		//creating 'pMST' selecting reason 1, 2, 3
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strpMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectPrivateStatusTypeRadioBtn()
				.selectStatusReason(strStatusReasonValues[0])
				.selectStatusReason(strStatusReasonValues[1])
				.selectStatusReason(strStatusReasonValues[2])
				.clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.selectStatusReasonForStatus(strStatusReasonValues[1])
				.selectStatusReasonForStatus(strStatusReasonValues[2])
				.clickOnSaveButton();
		
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti2)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.selectStatusReasonForStatus(strStatusReasonValues[1])
				.selectStatusReasonForStatus(strStatusReasonValues[2])
				.clickOnSaveButton();
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpMSTStatusTypeName);
		
		// Shared MST

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strsMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectStatusReason(strStatusReasonValues[0])
				.selectStatusReason(strStatusReasonValues[1])
				.selectStatusReason(strStatusReasonValues[2])
				.clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti3)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.selectStatusReasonForStatus(strStatusReasonValues[1])
				.selectStatusReasonForStatus(strStatusReasonValues[2])
				.clickOnSaveButton();

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti4)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.selectStatusReasonForStatus(strStatusReasonValues[1])
				.selectStatusReasonForStatus(strStatusReasonValues[2])
				.clickOnSaveButton();

		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti4);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsMSTStatusTypeName);
		
		// RT
		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResource.navigateToResourceListPage();

		objResource.createResourceWithAddress(
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

		// user creation
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(
						objResource_data.strResourceName)
				.selectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.selectRunReportRight(
						objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
				
		System.out.println(objUserdata.strNewUserName);
		System.out.println("-----precondition ends, execution starts-----");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
			    .selectMSTUpdateValue(strStatusTypeValues[0],
			      strStatusesValues[0])
			    .selectMSTReasonValue(strStatusReasonValues[1],
			      strStatusTypeValues[0], strStatusesValues[0])
			    .selectMSTReasonValue(strStatusReasonValues[2],
			      strStatusTypeValues[0], strStatusesValues[0])
				.selectStatusTypes(strStatusTypeValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[3])
				.selectMSTReasonValue(strStatusReasonValues[0],
						strStatusTypeValues[1], strStatusesValues[3])
				.selectMSTReasonValue(strStatusReasonValues[1],
						strStatusTypeValues[1], strStatusesValues[3])
				.clickOnSaveButton();
		
		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = dts.timeNow("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap1
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti4);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		//wait for 3 minutes
		System.out.println("wait for 3 minutes started");
		TimeUnit.MINUTES.sleep(3);
		TimeUnit.SECONDS.sleep(30);
		System.out.println("wait for 3 minutes ended");
		
		objNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1
				.enterReportStartDate(strApplicationTime)
				.enterReportEndDate(strApplicationTime)
				.selectResources(strResourceValue[0])
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatusTypes_data.strsMSTStatusTypeName)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage3()
				.selStatusReason(strStatusReasonValues[0], strStatusesValues[3])
				.selStatusReason(strStatusReasonValues[1], strStatusesValues[3])
				.clickregionalAggregrate()
				.clickOnGenerateReportBtn();
		
		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strsMSTStatusTypeName, 
					objStatusReason_data.strReasonName,
					objStatusReason_data.strReasonName1,
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName, strRequiredAppEndTime, "", "",
					strApplicationTime, strApplicationTime, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1
				.enterReportStartDate(strApplicationTime)
				.enterReportEndDate(strApplicationTime)
				.selectResources(strResourceValue[0])
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatusTypes_data.strpMSTStatusTypeName)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage3()
				.selStatusReason(strStatusReasonValues[1], strStatusesValues[0])
				.selStatusReason(strStatusReasonValues[2], strStatusesValues[0])
				.clickregionalAggregrate()
				.clickOnGenerateReportBtn();
		
		strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		strFetchAppDateTime = objEventManagement1.getApplicationTime();

		strAppTime = strFetchAppDateTime.split(" ");

		strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		fltDurationDiff = (double) intDurationDiff / 3600;

		dRounded = dts.roundTwoDecimals(fltDurationDiff);

		strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file2 = new File(strDownloadName1);
		boolean strPdf2 = file2.exists();

		if (strPdf2) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strpMSTStatusTypeName, 
					objStatusReason_data.strReasonName,
					objStatusReason_data.strReasonName1,
					"", "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strApplicationTime, strApplicationTime, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
			    .selectMSTUpdateValue(strStatusTypeValues[0],
			      strStatusesValues[0])
			    .selectMSTReasonValue(strStatusReasonValues[0],
			      strStatusTypeValues[0], strStatusesValues[0])
			    .selectMSTReasonValue(strStatusReasonValues[1],
			      strStatusTypeValues[0], strStatusesValues[0])
				.selectStatusTypes(strStatusTypeValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[3])
				.selectMSTReasonValue(strStatusReasonValues[1],
						strStatusTypeValues[1], strStatusesValues[3])
				.selectMSTReasonValue(strStatusReasonValues[2],
						strStatusTypeValues[1], strStatusesValues[3])
				.clickOnSaveButton();
		
		strApplicationTime = objEventManagement1.getApplicationTime();

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		strUpdatedDateTime = objMap1
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti4);
		strTime = strUpdatedDateTime.split(" ");
		strDate = strTime[0].split("\\(");

		strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		//wait for 3 minutes
		System.out.println("wait for 3 minutes started");
		TimeUnit.MINUTES.sleep(3);
		TimeUnit.SECONDS.sleep(30);
		System.out.println("wait for 3 minutes ended");
		
		objNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1
				.enterReportStartDate(strApplicationTime)
				.enterReportEndDate(strApplicationTime)
				.selectResources(strResourceValue[0])
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatusTypes_data.strsMSTStatusTypeName)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage3()
				.selStatusReason(strStatusReasonValues[1], strStatusesValues[3])
				.selStatusReason(strStatusReasonValues[2], strStatusesValues[3])
				.clickregionalAggregrate()
				.clickOnGenerateReportBtn();
		
		strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		strFetchAppDateTime = objEventManagement1.getApplicationTime();

		strAppTime = strFetchAppDateTime.split(" ");

		strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		fltDurationDiff = (double) intDurationDiff / 3600;

		dRounded = dts.roundTwoDecimals(fltDurationDiff);

		strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file3 = new File(strDownloadName2);
		boolean strPdf3 = file3.exists();

		if (strPdf3) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strsMSTStatusTypeName, 
					objStatusReason_data.strReasonName1, 
					objStatusReason_data.strReasonName2,
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName2, strRequiredAppEndTime, "", "",
					strApplicationTime, strApplicationTime, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1
				.enterReportStartDate(strApplicationTime)
				.enterReportEndDate(strApplicationTime)
				.selectResources(strResourceValue[0])
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatusTypes_data.strpMSTStatusTypeName)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage3()
				.selStatusReason(strStatusReasonValues[0], strStatusesValues[0])
				.selStatusReason(strStatusReasonValues[1], strStatusesValues[0])
				.clickregionalAggregrate()
				.clickOnGenerateReportBtn();
		
		strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		strFetchAppDateTime = objEventManagement1.getApplicationTime();

		strAppTime = strFetchAppDateTime.split(" ");

		strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		fltDurationDiff = (double) intDurationDiff / 3600;

		dRounded = dts.roundTwoDecimals(fltDurationDiff);

		strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);

		File file4 = new File(strDownloadName3);
		boolean strPdf4 = file4.exists();

		if (strPdf4) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strpMSTStatusTypeName, 
					objStatusReason_data.strReasonName, 
					objStatusReason_data.strReasonName1,
					"", "", "", strRequiredUpdatedTime,
					strDownloadName3, strRequiredAppEndTime, "", "",
					strApplicationTime, strApplicationTime, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		if(strPdf1 && strPdf2 && strPdf3 && strPdf4) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
		System.out.println(gstrResult);
	}
	
	/*********************************************************************************
	'Description : Generate 'Status Reason Summary report' in CSV format and verify that
	 				the report displays correct data. 
	'Precondition:
	'Date	 	 : 12-Feb-2016
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Generate 'Status Reason Summary report' in CSV format and verify that "
			+ "the report displays correct data.")
	public void testHappyDay103965() throws Exception {

		gstrTCID = "103965";
		gstrTO = "Generate 'Status Reason Summary report' in CSV format and verify that the report"
				+ " displays correct data.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		StatusReason_data objStatusReason_data = new StatusReason_data();

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[4];
		String strStatusReasonValues[] = new String[3];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType2 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

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
		String strDownloadName1 = file + "\\" + gstrTCID + "_1" + strTimeText
				+ fileType2;

		String strDownloadName2 = file + "\\" + gstrTCID + "_2" + strTimeText
				+ fileType2;
		
		String strDownloadName3 = file + "\\" + gstrTCID + "_3" + strTimeText
				+ fileType2;
		
		String strDownloadName4 = file + "\\" + gstrTCID + "_4" + strTimeText
				+ fileType2;

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strStatusReasonValues[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);
		
		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);
		
		strStatusReasonValues[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);
	
		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName2,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);
		
		strStatusReasonValues[2] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName2);
		
		objStatusTypeList.navigateToStatusTypeListNew();
		
		//creating 'pMST' selecting reason 1, 2, 3
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strpMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectPrivateStatusTypeRadioBtn()
				.selectStatusReason(strStatusReasonValues[0])
				.selectStatusReason(strStatusReasonValues[1])
				.selectStatusReason(strStatusReasonValues[2])
				.clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.selectStatusReasonForStatus(strStatusReasonValues[1])
				.selectStatusReasonForStatus(strStatusReasonValues[2])
				.clickOnSaveButton();
		
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti2)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.selectStatusReasonForStatus(strStatusReasonValues[1])
				.selectStatusReasonForStatus(strStatusReasonValues[2])
				.clickOnSaveButton();
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpMSTStatusTypeName);
		
		// Shared MST

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strsMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectStatusReason(strStatusReasonValues[0])
				.selectStatusReason(strStatusReasonValues[1])
				.selectStatusReason(strStatusReasonValues[2])
				.clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti3)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.selectStatusReasonForStatus(strStatusReasonValues[1])
				.selectStatusReasonForStatus(strStatusReasonValues[2])
				.clickOnSaveButton();

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti4)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.selectStatusReasonForStatus(strStatusReasonValues[1])
				.selectStatusReasonForStatus(strStatusReasonValues[2])
				.clickOnSaveButton();

		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti4);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsMSTStatusTypeName);
		
		// RT
		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResource.navigateToResourceListPage();

		objResource.createResourceWithAddress(
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

		// user creation
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(
						objResource_data.strResourceName)
				.selectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.selectRunReportRight(
						objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
				
		System.out.println(objUserdata.strNewUserName);
		System.out.println("-----precondition ends, execution starts-----");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
			    .selectMSTUpdateValue(strStatusTypeValues[0],
			      strStatusesValues[0])
			    .selectMSTReasonValue(strStatusReasonValues[1],
			      strStatusTypeValues[0], strStatusesValues[0])
			    .selectMSTReasonValue(strStatusReasonValues[2],
			      strStatusTypeValues[0], strStatusesValues[0])
				.selectStatusTypes(strStatusTypeValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[3])
				.selectMSTReasonValue(strStatusReasonValues[0],
						strStatusTypeValues[1], strStatusesValues[3])
				.selectMSTReasonValue(strStatusReasonValues[1],
						strStatusTypeValues[1], strStatusesValues[3])
				.clickOnSaveButton();
		
		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = dts.timeNow("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap1
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti4);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		//wait for 3 minutes
		System.out.println("wait for 3 minutes started");
		TimeUnit.MINUTES.sleep(3);
		TimeUnit.SECONDS.sleep(30);
		System.out.println("wait for 3 minutes ended");
		
		objNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1
				.enterReportStartDate(strApplicationTime)
				.enterReportEndDate(strApplicationTime)
				.selectResources(strResourceValue[0])
				.selectCSVRadioBtn()
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatusTypes_data.strsMSTStatusTypeName)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage3()
				.selStatusReason(strStatusReasonValues[0], strStatusesValues[3])
				.selStatusReason(strStatusReasonValues[1], strStatusesValues[3])
				.clickregionalAggregrate()
				.clickOnGenerateReportBtn();
		
		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("CSV generation duration " + strDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		File file1 = new File(strDownloadName1);
		boolean strCsv1 = file1.exists();

		if (strCsv1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strsMSTStatusTypeName, 
					objStatusReason_data.strReasonName,
					objStatusReason_data.strReasonName1,
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strApplicationTime, strApplicationTime, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "CSVDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1
				.enterReportStartDate(strApplicationTime)
				.enterReportEndDate(strApplicationTime)
				.selectResources(strResourceValue[0])
				.selectCSVRadioBtn()
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatusTypes_data.strpMSTStatusTypeName)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage3()
				.selStatusReason(strStatusReasonValues[1], strStatusesValues[0])
				.selStatusReason(strStatusReasonValues[2], strStatusesValues[0])
				.clickregionalAggregrate()
				.clickOnGenerateReportBtn();
		
		strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		strFetchAppDateTime = objEventManagement1.getApplicationTime();

		strAppTime = strFetchAppDateTime.split(" ");

		strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		fltDurationDiff = (double) intDurationDiff / 3600;

		dRounded = dts.roundTwoDecimals(fltDurationDiff);

		strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("CSV generation duration " + strDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv2 = file2.exists();

		if (strCsv2) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strpMSTStatusTypeName, 
					objStatusReason_data.strReasonName,
					objStatusReason_data.strReasonName1,
					"", "", "", strRequiredUpdatedTime,
					strDownloadName2, strRequiredAppEndTime, "", "",
					strApplicationTime, strApplicationTime, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
			    .selectMSTUpdateValue(strStatusTypeValues[0],
			      strStatusesValues[0])
			    .selectMSTReasonValue(strStatusReasonValues[0],
			      strStatusTypeValues[0], strStatusesValues[0])
			    .selectMSTReasonValue(strStatusReasonValues[1],
			      strStatusTypeValues[0], strStatusesValues[0])
				.selectStatusTypes(strStatusTypeValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[3])
				.selectMSTReasonValue(strStatusReasonValues[1],
						strStatusTypeValues[1], strStatusesValues[3])
				.selectMSTReasonValue(strStatusReasonValues[2],
						strStatusTypeValues[1], strStatusesValues[3])
				.clickOnSaveButton();
		
		strApplicationTime = objEventManagement1.getApplicationTime();

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		strUpdatedDateTime = objMap1
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti4);
		strTime = strUpdatedDateTime.split(" ");
		strDate = strTime[0].split("\\(");

		strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		//wait for 3 minutes
		System.out.println("wait for 3 minutes started");
		TimeUnit.MINUTES.sleep(3);
		TimeUnit.SECONDS.sleep(30);
		System.out.println("wait for 3 minutes ended");
		
		objNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1
				.enterReportStartDate(strApplicationTime)
				.enterReportEndDate(strApplicationTime)
				.selectResources(strResourceValue[0])
				.selectCSVRadioBtn()
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatusTypes_data.strsMSTStatusTypeName)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage3()
				.selStatusReason(strStatusReasonValues[1], strStatusesValues[3])
				.selStatusReason(strStatusReasonValues[2], strStatusesValues[3])
				.clickregionalAggregrate()
				.clickOnGenerateReportBtn();
		
		strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		strFetchAppDateTime = objEventManagement1.getApplicationTime();

		strAppTime = strFetchAppDateTime.split(" ");

		strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		fltDurationDiff = (double) intDurationDiff / 3600;

		dRounded = dts.roundTwoDecimals(fltDurationDiff);

		strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("CSV generation duration " + strDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);

		File file3 = new File(strDownloadName3);
		boolean strCsv3 = file3.exists();

		if (strCsv3) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strsMSTStatusTypeName, 
					objStatusReason_data.strReasonName1, 
					objStatusReason_data.strReasonName2,
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName3, strRequiredAppEndTime, "", "",
					strApplicationTime, strApplicationTime, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "CSVDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnStatusReasonSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1
				.enterReportStartDate(strApplicationTime)
				.enterReportEndDate(strApplicationTime)
				.selectResources(strResourceValue[0])
				.selectCSVRadioBtn()
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatusTypes_data.strpMSTStatusTypeName)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage3()
				.selStatusReason(strStatusReasonValues[0], strStatusesValues[0])
				.selStatusReason(strStatusReasonValues[1], strStatusesValues[0])
				.clickregionalAggregrate()
				.clickOnGenerateReportBtn();
		
		strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		strFetchAppDateTime = objEventManagement1.getApplicationTime();

		strAppTime = strFetchAppDateTime.split(" ");

		strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		fltDurationDiff = (double) intDurationDiff / 3600;

		dRounded = dts.roundTwoDecimals(fltDurationDiff);

		strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("CSV generation duration " + strDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName4,
				strAutoITName);

		File file4 = new File(strDownloadName4);
		boolean strCsv4 = file4.exists();

		if (strCsv4) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strpMSTStatusTypeName, 
					objStatusReason_data.strReasonName, 
					objStatusReason_data.strReasonName1,
					"", "", "", strRequiredUpdatedTime,
					strDownloadName4, strRequiredAppEndTime, "", "",
					strApplicationTime, strApplicationTime, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		if(strCsv1 && strCsv2 && strCsv3 && strCsv4) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
		System.out.println("TC is : " + gstrResult);
	}
	
	
	
}
