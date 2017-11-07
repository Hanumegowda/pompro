package requirementGroup.Reports;

import static org.testng.Assert.*;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import lib.dataObject.*;
import lib.module.NavigationToSubMenus;
import lib.page.*;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.*;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayEventDetailReport extends TestNG_UI_EXTENSIONS {

	public HappyDayEventDetailReport() throws Exception {
		super();
	}
	
	/*************************************************************************************************
	'Description : Verify that sub-resources are not available while generating 'Event Detail Report' 
	'Date	 	 : 10-Dec-2014
	'Author		 : Renushree
	'------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************************/
	@Test(description = "Verify that sub-resources are not available while generating 'Event Detail Report' ")
	public void testHappyDay151044() throws Exception {

		gstrTCID = "151044";
		gstrTO = "Verify that sub-resources are not available while generating 'Event Detail Report'";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		Resource_data objResource_data = new Resource_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventStatus objEventStatus = new EventStatus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		boolean blnTest = false;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + "TC"+ gstrTCID + "_" + strTimeText
				+ fileType;

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValues2[] = new String[3];
		String strStatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[2];
		String strEventTemplateValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResourceType.createResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypeValues2);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		objResourceType
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

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

		objResource
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.verSubResourceInResourceListPage(
						objResource_data.strSubResourceName);

		strResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList
				.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strResourceTypeValue[1]);

		for (int i = 0; i < strStatusTypeValues2.length; i++) {

			objViewsList.selectSubResourceCheckBox(strStatusTypeValues2[i]);
		}

		objViewsList.clickOnSaveButton();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().selectReportEventDetailOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = {strResourceTypeValue[0]};
		
		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault_page1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();
				
		String[] strResVal = {strResourceValue[0]};
		
		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus.clickOnResource(strResourceValue[0])
				.clickOnUpdateStatusKey(objResource_data.strSubResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues2[0],
						objView_data.strValueForUpdate1)
				.enterNedocsUpdateValue(strStatusTypeValues2[1],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues2[2],
						objView_data.strDateUpdateValue).clickOnSaveButton();

		objEventStatus.clickOnbackToView().clickOnUpdateStatusKey(
				objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0])
				.enterUpdateSSTValues(strStatusTypeValues[2],
						objView_data.strValueForSST).clickOnSaveButton();

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
				.verSubResourceIsNotDisplayed(strResourceValue[1])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		objLogin1.clickLogOut();

		String strUpdatedTime = strEventStartTime;
		String strUpdate = objReport_data.strUpdate;

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					"151044",
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
					objView_data.strValueForUpdate + ", "
							+ objView_data.strValueForUpdate1 + ", "
							+ objStatusTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strNEDOCValue + ", "
							+ objView_data.strDateUpdateValue };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score) added
	               at the resource level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights
                   on RS and with a role WITH only view right for these status types CAN view these statustypes in the Event Detail report.	               
	'Date	 	 : 03-Mar-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                                	Modified By
	'Date					                                                                    Name
	********************************************************************************************************************/
	@Test(description = "Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score)"
			+ " added at the resource level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource' "
			+ "rights on RS and with a role WITH only view right for these status types CAN view these status types in "
			+ "the Event Detail report. ")
	
	public void testHappyDay48939() throws Exception {
		gstrTCID = "48939";
		gstrTO = "Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score)"
				+ " added at the resource level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource' "
				+ "rights on RS and with a role WITH only view right for these status types CAN view these status types in "
				+ "the Event Detail report. ";

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
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Roles_data objRolesData = new Roles_data();
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
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

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
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];
		String strRoleValue[] = new String[1];
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

		String[] strStatusTypeValues1 = { strStatusTypeValues[0] };

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		String[] strStatusTypeValues2 = { strStatusTypeValues[1],
				strStatusTypeValues[2], strStatusTypeValues[3],
				strStatusTypeValues[4],strStatusTypeValues[5] };

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

		objResource_Page
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues2).clickOnSaveButton();

		// role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayViewsec()
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues2)
				
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User
		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectReportEventDetailOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objUsersList_page.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)		
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);
		
		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		Thread.sleep(10000);

		objLogin1.clickLogOut();
		
	System.out.println("-----Precondtion ends and test execution starts------");

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
				.selectEvent(strEventVal).selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

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
					objView_data.strValueForUpdate + ", "
							+ objView_data.strValueForTST + ", "
							+ objStatusTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strNEDOCValue + ", "
							+ objView_data.strDateUpdateValue };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		gstrResult = "PASS";
	}
		
	/*********************************************************************************************************************
	'Description : Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score) added 
	               at the resource type level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource' 
	               rights on RS and with a role WITH only view right for these status types CAN view these status types in the Event Detail report.               
	'Date	 	 : 03-Mar-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                     Modified By
	'Date					                                                                 Name
	********************************************************************************************************************/
	@Test(description = "Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score)"
			+ " added at the resource type level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource'"
			+ " rights on RS and with a role WITH only view right for these status types CAN view these status types in "
			+ "the Event Detail report. ")
	
	public void testHappyDay48953() throws Exception {
		gstrTCID = "48953";
		gstrTO = "Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score)"
				+ " added at the resource type level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource'"
				+ " rights on RS and with a role WITH only view right for these status types CAN view these status types in "
				+ "the Event Detail report. ";

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
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Roles_data objRolesData = new Roles_data();
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
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

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
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];
		String strRoleValue[] = new String[1];
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

		// role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayViewsec()
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User
		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectReportEventDetailOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objUsersList_page.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)		
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);
		
		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		Thread.sleep(10000);

		objLogin1.clickLogOut();
		
	System.out.println("-----Precondtion ends and test execution starts------");

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
				.selectEvent(strEventVal).selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

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
					objView_data.strValueForUpdate + ", "
							+ objView_data.strValueForTST + ", "
							+ objStatusTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strNEDOCValue + ", "
							+ objView_data.strDateUpdateValue };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score) added 
	               at the resource type level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource' 
	               rights on RS and with a role WITHOUT view/update rights for these status types CANNOT view these status types in the Event Detail report.
	'Date	 	 : 03-Mar-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                     Modified By
	'Date					                                                                 Name
	********************************************************************************************************************/
	@Test(description = "Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score)"
			+ " added at the resource type level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource'"
			+ " rights on RS and with a role WITHOUT view/update rights for these status types CANNOT view these status "
			+ "types in the Event Detail report.")
	
	public void testHappyDay48948() throws Exception {
		gstrTCID = "48948";
		gstrTO = "Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score)"
				+ " added at the resource type level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource'"
				+ " rights on RS and with a role WITHOUT view/update rights for these status types CANNOT view these status "
				+ "types in the Event Detail report.";

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
		View_data objView_data = new View_data();
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
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

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
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
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

		// User
		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportEventDetailOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objUsersList_page.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)	
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);
		
		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		Thread.sleep(10000);

		objLogin1.clickLogOut();
		
	System.out.println("-----Precondtion ends and test execution starts------");

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
				.selectEvent(strEventVal).selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

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
					objView_data.strValueForUpdate + ", "
							+ objView_data.strValueForTST + ", "
							+ objStatusTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strNEDOCValue + ", "
							+ objView_data.strDateUpdateValue };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		gstrResult = "PASS";
	}
		
	/*********************************************************************************************************************
	'Description : Update statuses of private status types NST(number), MST(multi), TST(text) and SST(saturation score) 
	               added at the resource level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource'
	                rights on RS and without any role CAN view these status types in the Event Detail report.               
	'Date	 	 : 03-Mar-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                                	Modified By
	'Date					                                                                    Name
	********************************************************************************************************************/
	@Test(description = "Update statuses of private status types NST(number), MST(multi), TST(text) and SST(saturation "
			+ "score) added at the resource level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource'"
			+ " rights on RS and without any role CAN view these status types in the Event Detail report. ")
	
	public void testHappyDay48954() throws Exception {
		gstrTCID = "48954";
		gstrTO ="Update statuses of private status types NST(number), MST(multi), TST(text) and SST(saturation "
				+ "score) added at the resource level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource'"
				+ " rights on RS and without any role CAN view these status types in the Event Detail report. ";

		Login_data objTest_data = new Login_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		String strTimeText = objDate_Time_settings.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

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
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
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

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList
				.createPrivateStatusType(objStatusTypes_data.strMultiStatusType,
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

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
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

		objResource_Page
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues)
				.clickOnSaveButton();

		// User
		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportEventDetailOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objUsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);
		
		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		Thread.sleep(10000);

		objLogin1.clickLogOut();
		
	System.out.println("-----Precondtion ends and test execution starts------");

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
				.selectEvent(strEventVal).selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

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
					objView_data.strValueForUpdate + ", "
							+ objView_data.strValueForTST + ", "
							+ objStatusTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strNEDOCValue + ", "
							+ objView_data.strDateUpdateValue };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score) added 
	               at the resource level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights 
	               on RS and with a role WITHOUT view/update rights for these status types CANNOT view these status types
	               in the Event Detail report. 	               
	'Date	 	 : 03-Mar-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                                	Modified By
	'Date					                                                                    Name
	********************************************************************************************************************/
	@Test(description = "Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score) "
			+ "added at the resource level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights"
			+ " on RS and with a role WITHOUT view/update rights for these status types CANNOT view these status types "
			+ "in the Event Detail report. ")
	
	public void testHappyDay48888() throws Exception {
		gstrTCID = "48888";
		gstrTO = "Update statuses of status types NST (number), MST (multi), TST (text) and SST (saturation score) "
				+ "added at the resource level for a resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights"
				+ " on RS and with a role WITHOUT view/update rights for these status types CANNOT view these status types "
				+ "in the Event Detail report. ";

		Login_data objTest_data = new Login_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		String strTimeText = objDate_Time_settings.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

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
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
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

		String[] strStatusTypeValues1 = { strStatusTypeValues[0] };

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		String[] strStatusTypeValues2 = { strStatusTypeValues[1],
				strStatusTypeValues[2], strStatusTypeValues[3],
				strStatusTypeValues[4],strStatusTypeValues[5] };

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

		objResource_Page
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues2)
				.clickOnSaveButton();

		// User
		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportEventDetailOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objUsersList_page.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);
		
		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);
		
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		Thread.sleep(10000);

		objLogin1.clickLogOut();
		
	System.out.println("-----Precondtion ends and test execution starts------");

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
				.selectEvent(strEventVal).selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

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
					objView_data.strValueForUpdate + ", "
							+ objView_data.strValueForTST + ", "
							+ objStatusTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strNEDOCValue + ", "
							+ objView_data.strDateUpdateValue };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description :  Update a status value of a status type ST that was added for a resource RS at the resource level, verify
	                that the data is displayed appropriately in the generated ‘Event Detail Report’
	'Author		 : Sangappa.k                              	
	'Date		 :	 08-Apr-2015		                                                                   
	********************************************************************************************************************/
	@Test(description = " Update a status value of a status type ST that was added for a resource RS at the resource level,"
			          +" verify that the data is displayed appropriately in the generated ‘Event Detail Report")
	
	public void testHappyDay37654() throws Exception {
		gstrTCID = "37654";
		gstrTO = " Update a status value of a status type ST that was added for a resource RS at the resource level,"
			       +" verify that the data is displayed appropriately in the generated ‘Event Detail Report";

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
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Roles_data objRolesData = new Roles_data();
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
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
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

		String strResourceValue[] = new String[2];
		String strStatusTypeValues[] = new String[5];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];
		String strRoleValue[] = new String[1];
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

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		String[] strStatusTypeValues1 = { strStatusTypeValues[0] };

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		String[] strStatusTypeValues2 = { strStatusTypeValues[1],
				strStatusTypeValues[2], strStatusTypeValues[3],
				strStatusTypeValues[4] };

		// Resource1
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

		objResource_Page
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues2).clickOnSaveButton();
		// Resource2

		objResource_Page.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename1,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[1] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		// role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName).clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User
		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName1)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().selectReportEventDetailOption()
				.clickSaveButton();

		System.out.println("New User name  " + objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues2).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		System.out.println("Event Templet Name  "
				+ objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondtion ends and test execution starts------");

		// login as new user

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		System.out.println("Event name   " + objEvent_data.strEventName);
		System.out.println("Event Tittle " + objEvent_data.strEventDescription);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);
		
		System.out.println("Event Drill  " + strDrill);
		System.out.println("Event Start time " + strEventStartTime);
		System.out.println("Event End time  " + strEventEndTime);

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		// Update St

		objUpdateStatus.clickOnSelectAll();

		objUpdateStatus.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);

		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForUpdate);

		objUpdateStatus.enterUpdateSSTValues(strStatusTypeValues[3],
				objView_data.strValueForSST);

		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[4],
				objView_data.strValueForTST)

		.clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		System.out.println("Updated time  " + strUpdatedTime);

		objNavigationToSubMenus1.navigateToEventReports();

		String strDate = dts.timeNow("MM/dd/yyyy");

		System.out.println("Start date & end Date  " + strDate);

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed().enterStartDate(strDate)
				.enterEndDate(strDate)
				.selectEventTemplate(strEventTemplateValue[0]).clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.verEnteredDatesAndPgeDetails(strDate)
				.enterReportStartDate(strDate).enterReportEndDate(strDate)
				.selectEvent(strEventVal).selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

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
					objStatusTypes_data.strNSTStatusTypeName + ","
							+ objStatusTypes_data.strDateStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName + ", "
							+ objStatusTypes_data.strTSTStatusTypeName,
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
					objView_data.strValueForUpdate + ", "
							+ objView_data.strDateUpdateValue + ", "
							+ objStatusTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strValueForTST };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		gstrResult = "PASS";
	}
	
	/*********************************************************************************
	'Description : Verify that user can generate 'Event Detail report' providing mandatory data.  ' 
	'Precondition:
	'Date	 	 : 25-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that user can generate 'Event Detail report' providing mandatory data.")
	public void testHappyDay103971() throws Exception {

		gstrTCID = "103971";
		gstrTO = "Verify that user can generate 'Event Detail report' providing mandatory data.";

		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Event_data objEvent_data = new Event_data();

		String strTimeText = objDate_Time_settings
				.getCurrentDate(objReport_data.dateFormat1);
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

		Report objReport1 = new Report(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		boolean blnTest = false;

		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

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

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectRunReportRight(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().selectReportEventDetailOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		objNavigationToSubMenus1.navigateToEventReports();
		String strDate = objDate_Time_settings.timeNow("MM/dd/yyyy");

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed()
				.selectEventTemplate(strEventTemplateValue[0])
				.enterStartDate(strDate).enterEndDate(strDate).clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.verEnteredDatesAndPgeDetails(strDate)
				.enterReportStartDate(strDate).enterReportEndDate(strDate)
				.selectEvent(strEventVal).selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		objLogin1.clickLogOut();

		String strUpdate = objReport_data.strUpdate;

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objTest_data.strRegionName,
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
					objView_data.strValueForUpdate + ", "
							+ objView_data.strValueForTST + ", "
							+ objStatusTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strNEDOCValue + ", "
							+ objView_data.strDateUpdateValue };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		gstrResult = "PASS";
	}
	
	/*********************************************************************************
	'Description : Verify that user can generate 'Event Snapshot report' providing mandatory data.
	'Precondition:
	'Date	 	 : 25-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that user can generate 'Event Snapshot report' providing mandatory data. ")
	public void testHappyDay118659() throws Exception {

		gstrTCID = "118659";
		gstrTO = "Verify that user can generate 'Event Snapshot report' providing mandatory data. ";

		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Event_data objEvent_data = new Event_data();
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

		String filePath = file + "\\";

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

		Report objReport1 = new Report(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

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

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectRunReportRight(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().selectReportEventSnapshotOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		String strEventStartDateAndTime = objEventManagement1.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement1.getEventEndTime(objEvent_data.strEventName);

		strEventStartDateAndTime = objDate_Time_settings.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH:mm",
				"dd MMM yyyy HH:mm");

		strEventEndTime = objDate_Time_settings.converDateFormat(strEventEndTime,
				"yyyy-MM-dd HH:mm", "dd MMM yyyy HH:mm");

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue).clickOnSaveButton();
		
		String strEventStartTime = objEventManagement1.getApplicationTime();

		String strStartTime[] = strEventStartTime.split(":");

		String strStartTi[] = strEventStartTime.split(" ");

		String strStartTime1[] = strStartTime[0].split(" ");

		String strDate = strStartTime1[0];

		String strMonth = strStartTime1[1];

		String strHour = strStartTime1[2];

		String strMinute = strStartTime[1];

		String oneMinuteAdded1 = objDate_Time_settings
				.addTimetoExisting(strStartTi[2], 1, "H:mm");
		String oneMinuteAdded = objDate_Time_settings
				.addTimetoExisting(strStartTi[2], 1, "HH:mm");

		String strStartTim1[] = oneMinuteAdded.split(":");
		String strStartTim2[] = oneMinuteAdded1.split(":");
		String strHour1 = strStartTim1[0];
		String strHourFrExcel = strStartTim2[0];
		String strMinute1 = strStartTim1[1];

		String strCurrentDate1 = objDate_Time_settings.getCurrentDate("MM/dd/yyyy HH:mm");

		String strStartTime2[] = strCurrentDate1.split(" ");

		String strCurrentDate = strStartTime2[0];

		String strYear[] = strCurrentDate.split("/");

		String strYear1 = strYear[2];

		String strTime = strDate + " " + strMonth + " " + strYear1;

		objNavigationToSubMenus1.navigateToEventReports();
		
		Thread.sleep(60000);

		objReport1.clickOnEventSnapshot().verifyEventSnapshotReport1stPage()
				.verifySearchStartDate().verifySearchEndDate()
				.enterStartDate(strCurrentDate).enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEventTemplateValue[0]);

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.verifySnapshotDateAndTimeShouldFallBetweenOption()
				.verifySnapshotDateOption().verifySnapshotTimeHourOption()
				.verifySnapshotTimeMinutesOption()
				.enterSnapshotDate(strCurrentDate)
				.selectSnapshotTimeHour(strHour1)
				.selectSnapshotTimeMinutes(strMinute1);

		String mainWindowHandle = driver1.getWindowHandle();

		objReport1.clickOnGenerateReportBtn();

		System.out.println(objEvent_data.strEventName);

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		String TitleName = driver1.getTitle();
		assertTrue(TitleName.contains("Event Snapshot Report"));

		String strHeaderName[] = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment",
				"Last Update", "By User" };

		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName);

		String[] strData = new String[] { objResource_data.strResourceName,
				strCurrentDate,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST, " ",
				strTime + " " + strHour + ":" + strMinute,
				objUserdata.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);
		
		objReport1.verifSummaryTable(objStatusTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot()
				  .selectExcelReportRadioBtn()
				  .enterStartDate(strCurrentDate1)
				  .enterEndDate(strCurrentDate1)
				  .selectEventTemplate(strEventTemplateValue[0])
				  .clickOnNextBtn()
				  .selectEventRadioBtn(objEvent_data.strEventName)
				  .enterSnapshotDate(strCurrentDate1)
				  .selectSnapshotTimeHour(strHour1)
				  .selectSnapshotTimeMinutes(strMinute1)
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

		String strValue = "";

		String[] strUpdatedStatusTypeNames = { "Resource Type", "Resource",
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objTest_data.strComment, objTest_data.strLastUpdate,
				objTest_data.strUpdatedBy };
		
		String strUpdateTime1 = strTime + " " + strStartTi[2];
		
		String strUpdateTime2 = strTime + " " + strHour + ":" + strStartTim1[1];

		String[] strUpdatedExcelValues = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"", strUpdateTime1,
				objUserdata.strFullName };

		/*summary part need to verify*/
		String[] strSummaryValue = { objTest_data.strSummary,
				"", "",
				"", objView_data.strValueForUpdate,
				"", "",
				"", "", ""};
		
		strValue = objOffCommonFunc.readInfoExcel(
				"Event Snapshot", 1, 1,
				strDownloadName1);
		assertEquals("Event Snapshot for " + objEvent_data.strEventName + " - "
				+ strCurrentDate + " " + strHourFrExcel + ":" + strMinute1
				+ " Central Standard Time. Event Start: "
				+ strEventStartDateAndTime + ". Event End: "+ strEventEndTime+". ", strValue);

		for (intCount = 1; intCount <= strUpdatedStatusTypeNames.length; intCount++) {
			if(intCount == 10) {
				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
						intCount, strDownloadName1);
				assertEquals(strUpdatedStatusTypeNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
						intCount, strDownloadName1);
				assertTrue(strUpdatedExcelValues[intCount - 1].equals(strValue) 
						|| strUpdateTime2.equals(strValue));
			} else {
				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
						intCount, strDownloadName1);
				assertEquals(strUpdatedStatusTypeNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
						intCount, strDownloadName1);
				assertEquals(strUpdatedExcelValues[intCount - 1], strValue);
			}
			
			/*summary part need to verify - refer bug id EMS-5027*/
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}