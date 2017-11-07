package requirementGroup.Reports;

import java.io.File;
import java.util.Properties;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.UpdateStatus_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
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
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseEventDetailReport extends TestNG_UI_EXTENSIONS {
	public EdgeCaseEventDetailReport() throws Exception {
		super();
	}
	
	/*************************************************************************************
	'Description :  Update a status value of a status type ST that was added for a resource RS, 
	                verify that the ‘Event Detail Report’ generated for the time that is before association
	                of status type ST with resource RS do not display status type ST. 
	'Precondition:
	'Date	 	 : 07-Apr-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Update a status value of a status type ST that was added for a resource RS,"
			+ "verify that the ‘Event Detail Report’ generated for the time that is before association "
			+ "of status type ST with resource RS do not display status type ST.")
	public void testEdgecase37663() throws Exception {

		gstrTCID = "37663";
		gstrTO = "Update a status value of a status type ST that was added for a resource RS,"
				+ "verify that the ‘Event Detail Report’ generated for the time that is before association"
				+ "of status type ST with resource RS do not display status type ST ";

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
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();

		Login objLogin = new Login(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		EventStatus EventStatus_page1 = new EventStatus(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		Resource objResource_Page1 = new Resource(this.driver1);
		
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

		String strResourceValue[] = new String[3];
		String strStatusTypeValues[] = new String[5];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strEventTemplateValue[] = new String[1];
		String strRoleValue[] = new String[1];
		Date_Time_settings objDts = new Date_Time_settings();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		boolean blnTest = false;

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName2);

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

		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName1,
				strStatusTypeValues2);

		strResourceTypeValue[1] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objResource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource_Page
				.getResourceValue(objResource_data.strResourceName1);

		objResource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[2] = objResource_Page
				.getResourceValue(objResource_data.strResourceName2);

		String[] strResourceValue1 = { strResourceValue[0], strResourceValue[2] };

		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName).clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplate(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues)

		.deselectSelectAllWebOption();
		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName2)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName1)
				.selectRunReportsCheckBox(objResource_data.strResourceName2)
				.clickAdvancedOptionAndExpand().selectReportEventDetailOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objResource_Page.navigateToResourceListPage();
		objResource_Page
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues2).clickOnSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()

		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objResource_Page1.clickResource(strResourceValue1);

		EventManagement_page1.clickOnSaveButton();

		String strDrill = EventManagement_page1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = EventManagement_page1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = EventManagement_page1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = EventManagement_page1
				.getEventValue(objEvent_data.strEventName);
		
		EventManagement_page1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		EventStatus_page1.clickOnUpdateStatusKey(
				objResource_data.strResourceName).clickOnShowAllStatuses();

		UpdateStatus_page1.clickOnSelectAll();
		UpdateStatus_page1.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
				objUpdateStatus_data.strNSTUpdateValue);
		UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValues[3],
				objUpdateStatus_data.strSSTUpdateValue);
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[4],
				objUpdateStatus_data.strTSTUpdateValue);
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue);
		UpdateStatus_page1.clickOnSaveButton();
		String strUpdatedTime = EventManagement_page1.getApplicationTime();

		String strApplicationDate = EventManagement_page1
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

		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed()
				.enterStartDate(strStartDate).enterEndDate(strStartDate)
				.selectEventTemplate(strEventTemplateValue[0]).clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.verEnteredDatesAndPgeDetails(strStartDate)
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strStartDate).selectEvent(strEventVal)
				.selectResources(strResourceValue[0])

				.selectResources(strResourceValue[2])
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
							+ objUserdata.strNewPassword + ","
							+ objTest_data.strRegionName,
					objEvent_data.strEventName,
					objEventSetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResource_data.strResourceName2,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNumberStatusType + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName + ", "
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
					objUpdateStatus_data.strNSTUpdateValue + ", "
							+ objUpdateStatus_data.strTSTUpdateValue + ", "
							+ objStatusTypes_data.strStatusNameInMulti + ", "
							+ objUpdateStatus_data.strSSTUpdateValue + ", "
							+ objView_data.strDateUpdateValue };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		gstrResult = "PASS";
	}
	
	/*********************************************************************************
	'Description : Verify that ‘Event Detail’ report displays resource for which user
	               has 'Run-Report' right on Event Detail Report (Step 2 of 2) screen. 
	'Date	 	 : 03-Mar-2014
	'Author		 : Anil
	'---------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that ‘Event Detail’ report displays resource for which user has 'Run-Report' "
			+ "right on Event Detail Report (Step 2 of 2) screen.")
	public void testEdgeCase136043() throws Exception {
		gstrTCID = "136043";
		gstrTO = "Verify that ‘Event Detail’ report displays resource for which user has 'Run-Report' right"
				+ " on Event Detail Report (Step 2 of 2) screen.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Date_Time_settings dts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		Map objMap = new Map(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];

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
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectReportEventDetailOption()
				.selectReportStatusSnapshotOption().clickSaveButton();

		objUsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectFirstRole()
				.selectMaintainEventsOption()
				.selectReportStatusSnapshotOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

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

		String[] strResVal = { strResourceValue[0] };

		objEventManagement
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		objNavigationToSubMenus.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		objUpdateStatus.clickOnStatusType(strStatusTypeValues[0]);

		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue).clickOnSaveButton();

		objLogin.clickLogOut();

		System.out.println("---------Precondition ends and test execution starts--------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();
		
		String strDate = dts.timeNow("MM/dd/yyyy");

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed()
				.enterStartDate(strDate)
				.enterEndDate(strDate)
				.selectEventTemplate(strEventTemplateValue[0])
				.clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objLogin1.clickLogOut();
	
		gstrResult = "PASS";
	}
}
