package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

import java.util.Iterator;
import java.util.Set;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.Map;
import lib.page.OtherRegions;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayPrintViewsAndEvents extends TestNG_UI_EXTENSIONS{

	public HappyDayPrintViewsAndEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*******************************************************************************************
	'Description : Verify that user can generate snapshot of ‘Region-View’ providing past time
	'Precondition:
	'Date	 	 : 03-Mar-2015
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user can generate snapshot of ‘Region-View’ providing past time")
	public void testHappyDay144204() throws Exception {
		gstrTCID = "144204";
		gstrTO = "Verify that user can generate snapshot of ‘Region-View’ providing past time";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		System.out.println(objResourceType_data.strResourceTypeName);
		
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName);
		
		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};

		objNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
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
		
		System.out.println(objView_data.strViewName);
		
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);
		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)
				.clickOnSaveButton();
		
		Thread.sleep(60000);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[3],
						objStatuTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		String strTime[] = strUpdatedTime.split(" ");

		String strTime1 = strTime[2];
		
		String strTime2[] = strTime1.split(":");
		
		String strHours = strTime2[0];
		
		String strMinutes = strTime2[1];

		String strDate = dts.timeNow("MM/dd/yyyy");
		String strDate1 = dts.timeNow("yyyy-MM-dd");
		
		String strApplicationTime = strDate + " " + strTime1;
		
		String strApplicationTime1 = strDate1 + " " + strTime1;
		
		System.out.println("Application time" + strApplicationTime);
		
		Thread.sleep(120000);
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate1)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate1)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST1)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[1])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST1)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate1);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate1);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[3],
						objStatuTypes_data.strStatusNameInMulti1);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST1);
		
		String strNEDOCValue = objView_data.strNEDOCValue1 + " - " + objView_data.strNDSTValInExcel;

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);
		
		RegionDefault_page1.clickPrintOption();
		
		objRegionDefault1.selectAndEnterDateAndTime(strDate, strHours,
				strMinutes);

		Thread.sleep(2000);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				 "Comment" };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strValueForUpdate,
				objView_data.strValueForUpdate,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strUpdatedValForSST,
				objView_data.strNEDOCValue,
				objView_data.strDateUpdateValue,
				
				"" };			

		objReport1.verifyViewNameInRegionViewHtmlReport(
				objView_data.strViewName, strApplicationTime1)
				.verHTMLFormHeadersAndAnswersInRegionViewRep(strHeaderNames,
						strUpdatedValues);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}	
	
	/**************************************************************************************************
	'Description : Verify that user can generate snapshot of ‘Region Default view’ providing past time.
	'Precondition:
	'Date	 	 : 03-Mar-2015
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************************/
	@Test(description = "Verify that user can generate snapshot of ‘Region Default view’ providing past time.")
	public void testHappyDay144206() throws Exception {
		gstrTCID = "144206";
		gstrTO = "Verify that user can generate snapshot of ‘Region Default view’ providing past time.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		System.out.println(objResourceType_data.strResourceTypeName);
		
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName);
		
		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		
		// Create Region Default view
		
		objNavigationToSubMenus.navigateToViews();
		
		objViewsList.clickOnEditLinkOfView(objView_data.strRegionDefaultName)
		.clickNextButton()
		.selectRegionName(objTest_data.strRegionName)
		.clickNextButton()
		.selectResource(objResource_data.strResourceName)
		.clickOnSTTab()
		.selectStatusTypeForView(strstatusTypeValues)
		.clickNextButton()
		.clickNextButton()
		.deslectTimestampCol()
		.deslectUserCol()
		.deslectFutureResourceCol()
		.clickOnSaveOfCreateNewView();
		
		/*objViewsList.clickOnEditLinkOfView(objView_data.strRegionDefaultName);
		
		objViewsList.selectViewType(objView_data.strSummaryPlus);
		
		objViewsList.selectStatusTypeForView(strstatusTypeValues);
		
		objViewsList.selectResource(objResource_data.strResourceName)
		            .clickOnSaveOfCreateNewView()
		            .verViewInList(objView_data.strRegionDefaultName);
		*/
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);
		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToRegDefault();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)
				.clickOnSaveButton();
		
		Thread.sleep(60000);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[3],
						objStatuTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);

		objNavigationToSubMenus1
		.navigateToRegDefault();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		String strTime[] = strUpdatedTime.split(" ");

		String strTime1 = strTime[2];
		
		String strTime2[] = strTime1.split(":");
		
		String strHours = strTime2[0];
		
		String strMinutes = strTime2[1];

		String strDate = dts.timeNow("MM/dd/yyyy");
		String strDate1 = dts.timeNow("yyyy-MM-dd");
		
		String strApplicationTime = strDate + " " + strTime1;
		
		String strApplicationTime1 = strDate1 + " " + strTime1;
		
		System.out.println("Application time" + strApplicationTime);
		Thread.sleep(120000);
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate1)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate1)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST1)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[1])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST1)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate1);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate1);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[3],
						objStatuTypes_data.strStatusNameInMulti1);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST1);
		
		String strNEDOCValue = objView_data.strNEDOCValue1 + " - " + objView_data.strNDSTValInExcel;

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);
		
		RegionDefault_page1.clickPrintOption();
		
		objRegionDefault1.selectAndEnterDateAndTime(strDate, strHours,
				strMinutes);

	//	Thread.sleep(2000);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

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
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForUpdate,
				"" };			

		objReport1.verifyViewNameInRegionViewHtmlReport(
				objView_data.strRegionDefault, strApplicationTime1)
				.verHTMLFormHeadersAndAnswersInRegionDefaultRep(strHeaderNames,
						strUpdatedValues);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}	
	
	/**************************************************************************************************
	'Description : Verify that user with ‘Report-Snapshot’ right can generate snapshot of ‘Region-View’ 
	               of current date and time.
	'Date	 	 : 03-Mar-2015
	'Author		 : Rahul
	***************************************************************************************************/
	@Test(description = "Verify that user with ‘Report-Snapshot’ right can generate snapshot of ‘Region-View’ of current date and time.")
	public void testHappyDay144203() throws Exception {
		gstrTCID = "144203";
		gstrTO = "Verify that user with ‘Report-Snapshot’ right can generate snapshot of ‘Region-View’ of current date and time.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();


		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		System.out.println(objResourceType_data.strResourceTypeName);
		
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName);
		
		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};

		objNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
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
		
		System.out.println(objView_data.strViewName);
		
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);
		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)
				.clickOnSaveButton();
		
		Thread.sleep(60000);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[3],
						objStatuTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		String strTime[] = strUpdatedTime.split(" ");

		String strTime1 = strTime[2];
		
		String strTime2[] = strTime1.split(":");
		
		String strHours = strTime2[0];
		
		String strMinutes = strTime2[1];

		String strDate = dts.timeNow("MM/dd/yyyy");
		String strDate1 = dts.timeNow("yyyy-MM-dd");
		
		String strApplicationTime = strDate + " " + strTime1;
		
		String strApplicationTime1 = strDate1 + " " + strTime1;
		
		System.out.println("Application time" + strApplicationTime);
		
		RegionDefault_page1.clickPrintOption();
		
		objRegionDefault1.selectAndEnterDateAndTime(strDate, strHours,
				strMinutes);

		Thread.sleep(2000);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName, "Comment" };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strValueForUpdate, objView_data.strValueForUpdate,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strUpdatedValForSST, objView_data.strNEDOCValue, 
				objView_data.strDateUpdateValue,
				"" };			
//wrong order of STs passed, sometimes login page is displayed
		objReport1.verifyViewNameInRegionViewHtmlReport(
				objView_data.strViewName, strApplicationTime1)
				.verHTMLFormHeadersAndAnswersInRegionViewRep(strHeaderNames,
						strUpdatedValues);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}	
	
	/**********************************************************************************************************
	'Description : Verify that user can generate snapshot of ‘Region Default view’ with current date and time. 
	'Date	 	 : 04-Mar-2015
	'Author		 : Rahul
	**********************************************************************************************************/
	@Test(description = "Verify that user can generate snapshot of ‘Region Default view’ with current date and time. ")
	public void testHappyDay144205() throws Exception {
		gstrTCID = "144205";
		gstrTO = "Verify that user can generate snapshot of ‘Region Default view’ with current date and time. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		System.out.println(objResourceType_data.strResourceTypeName);
		
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName);
		
		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		
		// Create Region Default view
		
		objNavigationToSubMenus.navigateToViews();
		String[] STNames = {objStatuTypes_data.strNSTStatusTypeName, objStatuTypes_data.strNDSTStatusTypeName, objStatuTypes_data.strTSTStatusTypeName, objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strSSTStatusTypeName, objStatuTypes_data.strDateStatusTypeName};
		objViewsList.clickOnEditLinkOfView(objView_data.strRegionDefaultName)
		.clickNextButton()
		.selectRegionName(objTest_data.strRegionName)
		.clickNextButton()
		.selectResource(objResource_data.strResourceName)
		.clickOnSTTab()
		.selectStatusTypeForView(STNames)
		.clickNextButton()
		.clickNextButton()
		.deslectTimestampCol()
		.deslectUserCol()
		.deslectFutureResourceCol()
		.clickOnSaveOfCreateNewView();
		
	/*	objViewsList.selectViewType(objView_data.strSummaryPlus);
		
//		objViewsList.selectStatusTypeForView(strstatusTypeValues);
		
		objViewsList.selectResource(objResource_data.strResourceName)
		            .selectStatusTypeForView(strstatusTypeValues)
		            .clickOnSaveOfCreateNewView()
		            .verViewInList(objView_data.strRegionDefaultName);
		*/
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);
		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToRegDefault();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)
				.clickOnSaveButton();
		
		Thread.sleep(60000);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[3],
						objStatuTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);

		objNavigationToSubMenus1
		.navigateToRegDefault();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		String strTime[] = strUpdatedTime.split(" ");

		String strTime1 = strTime[2];
		
		String strTime2[] = strTime1.split(":");
		
		String strHours = strTime2[0];
		
		String strMinutes = strTime2[1];
		
		String strDate = dts.timeNow("MM/dd/yyyy");
		String strDate1 = dts.timeNow("yyyy-MM-dd");
		
		String strApplicationTime = strDate + " " + strTime1;
		
		String strApplicationTime1 = strDate1 + " " + strTime1;
		
		System.out.println("Application time" + strApplicationTime);
		
		RegionDefault_page1.clickPrintOption();
		
		objRegionDefault1.selectAndEnterDateAndTime(strDate, strHours,
				strMinutes);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

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
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForUpdate,
				"" };			

		objReport1.verifyViewNameInRegionViewHtmlReport(
				objView_data.strRegionDefault, strApplicationTime1)
				.verHTMLFormHeadersAndAnswersInRegionDefaultRep(strHeaderNames,
						strUpdatedValues);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
    /****************************************************************************************************
  	'Description : Verify that user can generate snapshot of ‘Event Status’ providing past time. 
  	'Date	 	 : 03-Mar-2015
  	'Author		 : Hanumegowda
  	'---------------------------------------------------------------
  	'Modified Date			                        	Modified By
  	'Date					                            Name
  	*****************************************************************************************************/
	@Test(description = "Verify that user can generate snapshot of ‘Event Status’ providing past time.")
	public void testHappyDay144209() throws Exception {

		gstrTCID = "144209";
		gstrTO = "Verify that user can generate snapshot of ‘Event Status’ providing past time.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);

		Report_data objReport_data = new Report_data();
		View_data objView_data = new View_data();
		Report objReport1 = new Report(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		Date_Time_settings objDts = new Date_Time_settings();

		System.out.println("-----Precondtion execution starts------");

		String strApplicationTime = "";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		objNavigationToSubmenus.navigateToUsers();
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.selectReportStatusSnapshotOption().clickSaveButton();
		System.out.println("user" + objUserdata.strNewUserName);
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);
		objEventSetUp.deselectSelectAllWebOption();

		System.out.println("templet " + objESetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		RegionDefault_page1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton();

		objEventManagement1.clickOnEventNameInEventBanner(
				objEvent_data.strEventName).clickOnUpdateStatusKey(
				objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForTST)

				.enterUpdateSSTValues(strstatusTypeValues[3],
						objView_data.strValueForSST)
				.enterNedocsUpdateValue(strstatusTypeValues[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)

				.clickOnSaveButton();

		strApplicationTime = objEventManagement1.getApplicationTime();

		String strAppTimeWithTimeZone = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String[] strTimeZone = strAppTimeWithTimeZone.split(" ");
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		String strApplicationTime1 = strApplicationTime;
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(
				strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");

		String strApplicationTime2 = objDts.converDateFormat(
				strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");
		
		Thread.sleep(180000);

		objEventManagement1.clickOnEventNameInEventBanner(
				objEvent_data.strEventName).clickOnUpdateStatusKey(
				objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate1)
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[1])
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForTST1)

				.enterUpdateSSTValues(strstatusTypeValues[3],
						objView_data.strValueForSST1)
				.enterNedocsUpdateValue(strstatusTypeValues[4],
						objView_data.strValueForNDST1)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateFutureValue)

				.clickOnSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		Thread.sleep(2000);

		RegionDefault_page1.clickPrintOption();
		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");
		String lastupdate = objDts.converDateFormat(strApplicationTime1,
				"MM/dd/yyyy HH:mm", "dd MMM HH:mm");

		Thread.sleep(2000);

		System.out.println(strDate);
		System.out.println(strHour);
		System.out.println(strMinutes);

		RegionDefault_page1.clickOnSelectDateAndTimeOption()
				.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objReport_data.comment, objReport_data.lastupdate,
				objReport_data.byuser };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"", lastupdate + " " + strTimeZone[3], objUserdata.strFullName };

		String[] summaryRow = { "Summary", "N/A", "N/A",
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, "N/A", "", "", "" };
		
		RegionDefault_page1.verSnapShotWindowOfEvent(
				objEvent_data.strEventName, strApplicationTime2 + " "
						+ strTimeZone[3]);
		
		objReport1.verHTMLFormHeadersAndAnswersInEventSnapshotReport(
				strHeaderNames, strUpdatedValues, summaryRow);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************
	'Description : Verify that appropriate past view is displayed in 'Custom View' snapshot.
	'Precondition:
	'Date	 	 : 05-Mar-2015
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************/
	@Test(description = "Verify that appropriate past view is displayed in 'Custom View' snapshot.")
	public void testHappyDay146898() throws Exception {
		gstrTCID = "146898";
		gstrTO = "Verify that appropriate past view is displayed in 'Custom View' snapshot.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		CustomUnderView ObjCustomUnderView1 = new CustomUnderView(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		System.out.println(objResourceType_data.strResourceTypeName);
		
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName);
		
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
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.selectReportStatusSnapshotOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption);

		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		// Custom View
		Thread.sleep(3000);
		objNavigationToSubMenus1.navigateToCustomInView();
		String[] strResource1Val = { strResourceValue[0] };
		ObjCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResource1Val)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strstatusTypeValues)
				.clickOnSave();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)
				.clickOnSaveButton();
		
		String ptrUpdatedTime = objEventManagement1.getApplicationTime();
		
		String strAppTimeWithTimeZone = objEventManagement1.getApplicationTimeWithCSTCDT();
		
		String[] strTimeZone = strAppTimeWithTimeZone.split(" ");
		
		System.out.println("Application time1 " + ptrUpdatedTime);
		
		Thread.sleep(60000);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[3],
						objStatuTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);

		objNavigationToSubMenus1.navigateToCustomInView();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		String strTime[] = strUpdatedTime.split(" ");

		String strTime1 = strTime[2];
		
		String strTime2[] = strTime1.split(":");
		
		String strHours = strTime2[0];
		
		String strMinutes = strTime2[1];
		
		String strDate = dts.timeNow("MM/dd/yyyy");
		String strDate1 = dts.timeNow("yyyy-MM-dd");
		
		String strApplicationTime = strDate + " " + strTime1;
		
		String strApplicationTime1 = strDate1 + " " + strTime1;
		
		System.out.println("Application time" + strApplicationTime);
		
		Thread.sleep(120000);
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate1)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate1)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST1)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[1])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST1)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate1);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate1);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[3],
						objStatuTypes_data.strStatusNameInMulti1);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST1);
		
		String strNEDOCValue = objView_data.strNEDOCValue1 + " - " + objView_data.strNDSTValInExcel;

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);
		
		RegionDefault_page1.clickPrintOption();
		
		objRegionDefault1.selectAndEnterDateAndTime(strDate, strHours,
				strMinutes);

		Thread.sleep(2000);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment", "Last Update", "By User"};

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForUpdate,
				"", ptrUpdatedTime+" "+strTimeZone[3], objUser_data.strFullName};			

		objReport1.verifyViewNameInRegionViewHtmlReport(
				objView_data.strCustom, strApplicationTime1)
				.verHTMLFormHeadersAndAnswersInRegionViewRep(strHeaderNames,
						strUpdatedValues);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}	

	
	 /****************************************************************************************************
  	'Description : Verify that appropriate past view is displayed in view snapshot .
  	'Date	 	 : 05-Mar-2015
  	'Author		 : Hanumegowda
  	'---------------------------------------------------------------
  	'Modified Date			                        	Modified By
  	'Date					                            Name
  	*****************************************************************************************************/
	@Test(description = "Verify that appropriate past view is displayed in view snapshot.")
	public void testHappyDay144212() throws Exception {
		gstrTCID = "144212";
		gstrTO = "Verify that appropriate past view is displayed in view snapshot.";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

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
		Report objReport1 = new Report(this.driver1);

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String strApplicationTime = "";

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

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		objViewsList
				.createView(objView_data.strViewName, objView_data.strViewDesc,
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
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(
				strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		
		String strApplicationTime1 = objDts.converDateFormat(
				strApplicationTime,"MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");
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

		Thread.sleep(5000);

		RegionDefault_page1.clickPrintOption();

		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");

		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour,
				strMinutes);

		Thread.sleep(2000);
		System.out.println(strDate);
		System.out.println(strHour);
		System.out.println(strMinutes);
		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

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
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"" };

		objReport1.verifyViewNameInRegionViewHtmlReport(
				objView_data.strViewName, strApplicationTime1)
				.verHTMLFormHeadersAndAnswersInRegionViewRep(strHeaderNames,
						strUpdatedValues);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}


	/********************************************************************************************
	 * 'Description : Verify that appropriate past view is displayed in ‘Event Status’ snapshot.
	 * 'Date        : 05-March-2015
	 * 'Author      : Rahul
	 *******************************************************************************************/
	@Test(description = "Verify that appropriate past view is displayed in ‘Event Status’ snapshot.")
	public void testHappyDay144214() throws Exception {

		gstrTCID = "144214";
		gstrTO = "Verify that appropriate past view is displayed in ‘Event Status’ snapshot.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		Report_data objReport_data = new Report_data();
		View_data objView_data = new View_data();
		Report objReport1 = new Report(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		Date_Time_settings objDts = new Date_Time_settings();

		System.out.println("-----Precondtion execution starts------");

		String strApplicationTime = "";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		System.out.println(objResource_data.strResourceName);
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		objNavigationToSubmenus.navigateToUsers();
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectReportStatusSnapshotOption()
				.selectReportEventSnapshotOption().clickSaveButton();
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);
		objEventSetUp.deselectSelectAllWebOption();

		System.out.println("templet " + objESetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		RegionDefault_page1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton();
		System.out.println(objEvent_data.strEventName);

		objEventManagement1.clickOnEventNameInEventBanner(
				objEvent_data.strEventName).clickOnUpdateStatusKey(
				objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForTST)

				.enterUpdateSSTValues(strstatusTypeValues[3],
						objView_data.strValueForSST)
				.enterNedocsUpdateValue(strstatusTypeValues[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)

				.clickOnSaveButton();

		String strApplicationTime1 = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		String strTimezone[] = strApplicationTime1.split(" ");
		Thread.sleep(60000);
		RegionDefault_page1.selectFrame();
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		strApplicationTime = objEventManagement1.getApplicationTime();
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(
				strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");

		Thread.sleep(180000);

		objEventManagement1.clickOnEventNameInEventBanner(
				objEvent_data.strEventName).clickOnUpdateStatusKey(
				objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate1)
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[1])
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForTST1)

				.enterUpdateSSTValues(strstatusTypeValues[3],
						objView_data.strValueForSST1)
				.enterNedocsUpdateValue(strstatusTypeValues[4],
						objView_data.strValueForNDST1)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateFutureValue)

				.clickOnSaveButton();

		RegionDefault_page1.selectFrame();
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		System.out.println(objEvent_data.strEventName);
		Thread.sleep(2000);

		RegionDefault_page1.clickPrintOption();
		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");

		String strApplicationTime2 = objDts.converDateFormat(
				strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");

		Thread.sleep(2000);

		System.out.println(strDate);
		System.out.println(strHour);
		System.out.println(strMinutes);

		RegionDefault_page1.clickOnSelectDateAndTimeOption()
				.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objReport_data.comment, objReport_data.lastupdate,
				objReport_data.byuser };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"", strApplicationTime1, objUserdata.strFullName };

		String[] summaryRow = { "Summary", "N/A", "N/A",
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, "N/A", "", "", "" };

		RegionDefault_page1.verSnapShotWindowOfEvent(
				objEvent_data.strEventName, strApplicationTime2 + " "
						+ strTimezone[3]);
		objReport1.verHTMLFormHeadersAndAnswersInEventSnapshotReport(
				strHeaderNames, strUpdatedValues, summaryRow);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************
	 * 'Description : Verify that user can generate snapshot of ‘Event Status’ of current date and time.
	 * 'Date        : 03-March-2015
	 * 'Author      : Anitha
	 ***************************************************************************************************/

	@Test(description = "Verify that user can generate snapshot of ‘Event Status’ of current date and time.")
	public void testHappyDay144208() throws Exception {

		gstrTCID = "144208";
		gstrTO = "Verify that user can generate snapshot of ‘Event Status’ of current date and time.";

		Date_Time_settings objDts = new Date_Time_settings();
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		Report_data objReport_data = new Report_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Map objMap1 = new Map(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		System.out.println("-----Precondtion execution starts------");

		String strApplicationTime = "";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		objNavigationToSubmenus.navigateToUsers();
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.selectReportStatusSnapshotOption().clickSaveButton();
		System.out.println("new user" + objUserdata.strNewUserName);
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);
		objEventSetUp.deselectSelectAllWebOption();

		System.out.println("templet " + objESetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		System.out
				.println("-----------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		RegionDefault_page1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton();

		objEventManagement1.clickOnEventNameInEventBanner(
				objEvent_data.strEventName).clickOnUpdateStatusKey(
				objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForTST)

				.enterUpdateSSTValues(strstatusTypeValues[3],
						objView_data.strValueForSST)
				.enterNedocsUpdateValue(strstatusTypeValues[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)

				.clickOnSaveButton();

		String strApplicationTime2 = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		String strTimezone[] = strApplicationTime2.split(" ");

		Thread.sleep(60000);

		objMap1.clickOnRefreshLink();

		Thread.sleep(5000);

		strApplicationTime = objEventManagement1.getApplicationTime();
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strApplicationTime1 = objDts.converDateFormat(
				strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");

		RegionDefault_page1.clickPrintOption();

		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");
		
		Thread.sleep(2000);

		System.out.println(strDate);
		System.out.println(strHour);
		System.out.println(strMinutes);

		RegionDefault_page1.clickOnSelectDateAndTimeOption()
				.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objReport_data.comment, objReport_data.lastupdate,
				objReport_data.byuser };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"", strApplicationTime2, objUserdata.strFullName };

		String[] summaryRow = { "Summary", "N/A", "N/A",
				"N/A", objView_data.strValueForUpdate,
				"N/A", "N/A", "", "", "" };

		RegionDefault_page1.verSnapShotWindowOfEvent(
				objEvent_data.strEventName, strApplicationTime1 + " "
						+ strTimezone[3]);

		objReport1.verHTMLFormHeadersAndAnswersInEventSnapshotReport(
				strHeaderNames, strUpdatedValues, summaryRow);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that user can generate snapshot of ‘Other Region Event Detail View’ providing past time.  
	 * 'Date        : 24-Mar-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that user can generate snapshot of ‘Other Region Event Detail View’ providing past time.")
	public void testHappyDay144468() throws Exception {
		gstrTCID = "144468";
		gstrTO = "Verify that user can generate 'excel' snapshot of ‘Other Region Event Detail View’ providing past time.";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
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
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Report objReport1 = new Report(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strArkansasReg);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

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
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
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
				.selectReportStatusSnapshotOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
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

		String strUpdateTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		System.out.println(strUpdateTime);

		String strApplicationTime = objEventManagement1.getApplicationTime();
		String strCurrentYear = objDate_Time_settings.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDate_Time_settings.converDateFormat(
				strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		// String strApplicationTime1 = strApplicationTime;
		strApplicationTime = objDate_Time_settings
				.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, 1,
						"MM/dd/yyyy HH:mm");

		String strApplicationTime2 = objDate_Time_settings.converDateFormat(
				strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");

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

		String strUpdateTime2 = objEventManagement1.getApplicationTime();
		System.out.println(strUpdateTime2);

		String[] strDateTime = strUpdateTime.split(" ");
		String[] strHourAndMin = strDateTime[2].split(":");
		String strMinute = objDate_Time_settings.addTimetoExisting(
				strHourAndMin[1], 1, "mm");
		String strCureentDate = objDate_Time_settings
				.getCurrentDate("MM/dd/yyyy");
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		System.out.println(objUserdata.strNewUserName1);
		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToRegUnderOtherRegions(objTest_data.strArkansasReg);

		objRegionDefault1
				.verifyParticularRegPageIsDisplayed(objTest_data.strArkansasReg);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyEventStatus();

		objRegionDefault1.clickPrintOption();
		Thread.sleep(2000);

		objRegionDefault1.selectAndEnterDateAndTime(strCureentDate,
				strHourAndMin[0], strMinute).clickOnGenerateReportOption();

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strHeaderNames1 = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment",
				"Last Update", "By User" };

		String[] strUpdatedValues1 = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strHyphen,
				objView_data.strHyphen, objView_data.strHyphen, "",
				strUpdateTime, objUserdata.strFullName };

		String[] summaryRow = { "Summary", "N/A", "N/A",
				objView_data.strNEDOCVal, objView_data.strZero,
				objView_data.strZero, "N/A", "", "", "" };

		objRegionDefault1.verSnapShotWinOfEvent(objEvent_data.strEventName,
				strApplicationTime2);

		objReport1.verHTMLFormHeadersAndAnswersInEventSnapshotReport(
				strHeaderNames1, strUpdatedValues1, summaryRow);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that event name is displayed along with the resource name (if a resource present in the 
	 * 				  region view that is participating in an active event)on other region view snapshot.  
	 * 'Date        : 24-Mar-2015
	 * 'Author      : Pallavi
	 ***************************************************************************************************************/

	@Test(description = "Verify that event name is displayed along with the resource name (if a resource present in the "
			+ "region view that is participating in an active event)on other region view snapshot.")
	public void testHappyDay144867() throws Exception {
		
		gstrTCID = "144867";
		gstrTO = "Verify that event name is displayed along with the resource name (if a resource present in the region view "
				+ "that is participating in an active event)on other region view snapshot.";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);

		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		OtherRegions objOtherRegions1 = new OtherRegions(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strAmariloTXReg);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// Shared status types
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
		Resource_Page.navigateToResourceListPage().createSharedResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

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

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strstatusTypeValues)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verEveTemplateIcon(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempIcon);

		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectReportEventSnapshotOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strSouthTexasReg);

		objRegionDefault.selectFrame();

		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewOtherRegView(objTest_data.strAmariloTXRegVal)
				.clickAdvancedOptionAndExpand()
				.selectReportEventSnapshotOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1
				.navigateToRegUnderOtherRegions(objTest_data.strAmariloTXReg);

		objOtherRegions1.verEventIconDispCorrespondingToRes(
				objResource_data.strResourceName,
				objEventSetUp_data.strEventTempIcon);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/***************************************************************************************************************
	 * 'Description : Verify that user can generate snapshot of ‘Other Region View’ providing past time.  
	 * 'Date        : 23-Mar-2015 
	 * 'Author      : Hanumegowda
	 ***************************************************************************************************************/

	@Test(description = "Verify that user can generate snapshot of ‘Other Region View’ providing past time. ")
	public void testHappyDay144467() throws Exception {
		gstrTCID = "144467";
		gstrTO = "Verify that user can generate snapshot of ‘Other Region View’ providing past time. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
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
		Report objReport1 = new Report(this.driver1);

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		System.out.println("-----Precondtion execution starts------");

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
		
		System.out.println(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickSaveButton();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.clickOnEditOfRegDefault();
		
		objViewsList.selectViewType(objView_data.strSummaryPlus);

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

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();
		
		System.out.println(objResource_data.strResourceName);

		objLogin.clickLogOut();

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		// objRegionDefault.clickRegionLink();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strSetracReg);

		objRegionDefault.selectFrame();
		Thread.sleep(10000);

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

		RegionDefault_page1.clickPrintOption();

		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strDate1 = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");
		// String strCurrentDate = objDts.getCurrentDate("yyyy-MM-dd");
		
		System.out.println(strHour);
		System.out.println(strMinutes);
		
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour,
				strMinutes);

		Thread.sleep(2000);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment"};
		String resource = objResource_data.strResourceName;

		String[] strUpdatedValues = { resource, objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST, "" };

		objReport1.verifyViewNameInRegionViewHtmlReport(
				objView_data.strRegionDefault, strDate1);
		
		objReport1.verHTMLFormHeadersAndAnswersInRegionDefaultRep(
				strHeaderNames, strUpdatedValues);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************
	 * 'Description : Verify that appropriate past view is displayed in region default snapshot.
	 * 'Date        : 06-March-2015
	 * 'Author      : Sangappa.k
	 ***************************************************************************************************/

	@Test(description = "Verify that appropriate past view is displayed in region default snapshot.")
	public void testHappyDay144213() throws Exception {
		gstrTCID = "144213";
		gstrTO = "Verify that appropriate past view is displayed in region default snapshot.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String ApplicationTime = "";

		Views objViews1 = new Views(this.driver1);
		Report objReport1 = new Report(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);

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
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1);

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
						strStatusesValues[0]).clickOnSaveButton();

		ApplicationTime = objEventManagement1.getApplicationTime();
		String strCurrentYear = objDate_Time_settings.getCurrentDate("yyyy");

		System.out.println("fisrt time uptaed time  " + ApplicationTime);

		ApplicationTime = ApplicationTime + " " + strCurrentYear;

		ApplicationTime = objDate_Time_settings.converDateFormat(
				ApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		ApplicationTime = objDate_Time_settings
				.AddTimeToExistingTimeHourAndMin(ApplicationTime, 0, 1,
						"MM/dd/yyyy HH:mm");
		String ApplicationTime1 = objDate_Time_settings.converDateFormat(
				ApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");

		Thread.sleep(180000);

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

		Thread.sleep(60000);

		objRegionDefault1.clickPrintOption();
		String strDate = objDate_Time_settings.converDateFormat(
				ApplicationTime, "MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDate_Time_settings.converDateFormat(
				ApplicationTime, "MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDate_Time_settings.converDateFormat(
				ApplicationTime, "MM/dd/yyyy HH:mm", "mm");

		System.out.println(strDate);
		objRegionDefault1.selectAndEnterDateAndTime(strDate, strHour,
				strMinutes);
		System.out.println(strDate);
		System.out.println(strHour);
		System.out.println(strMinutes);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

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
				objView_data.strNEDOCValue, "--", "--", "--", "" };

		System.out.println(ApplicationTime1);

		objReport1.verifyRegionDefaultHtmlReport(ApplicationTime1)
				.verHTMLFormHeadersAndAnswersInRegionDefaultRep(
						strHeaderNames1, strUpdatedValues1);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Edit a view add few more status types and verify that
	                snapshot displays the newly added status type.
	'Date	 	 : 03-Mar-2015
	'Author		 : Sangappa.k
	********************************************************************/
	@Test(description = "Edit a view add few more status types and verify that snapshot displays the newly added status type.")
	public void testHappyDay144865() throws Exception {

		gstrTCID = "144865";
		gstrTO = "Edit a view add few more status types and verify that snapshot displays the newly added status type.";
		
		Login login_page1 = new Login(this.driver1);
        RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1_page1 = new StatusTypeList(driver);
		ResourceType objResourceType_page1 = new ResourceType(driver);
		Resource objResource_page1 = new Resource(driver);
		UsersList objUsersList_page1 = new UsersList(driver);
		ViewsList objviewsList_page1 = new ViewsList(driver);
		
		ViewsList objviewsList_page2 = new ViewsList(driver1);
		NavigationToSubMenus objNavigationToSubmenus2 = new NavigationToSubMenus(
				this.driver1);
		Login login_page2 = new Login(this.driver1);
		RegionDefault objRegionDefault_page2 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page2 = new SelectRegion(this.driver1);
		UpdateStatus Updatestatus_page2 = new UpdateStatus(driver1);
		EventManagement obgEventManagement_page2 = new EventManagement(driver1);
		Report objReport_page2 = new Report(driver1);
		Date_Time_settings objDTS = new Date_Time_settings();
		
		// data
		Login_data login_data = new Login_data();
		Resource_data objResourcedata_page1 = new Resource_data();
		ResourceType_data objResourceTypedata_page1 = new ResourceType_data();
		StatusTypes_data objStatusTypesdata_page1 = new StatusTypes_data();
		View_data objViewdata_page1 = new View_data();
		User_data objUserdata_page1 = new User_data();

		// array of String for all sources
		String strStatusTypeValues1[] = new String[6];
		String strMultiStatusesTypeValues2[] = new String[2];
		
		String strResourceTypeValue[] = new String[1];
		
		String[] Resvalue=new String[1];
		
		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1
				.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page1.selectFrame();
		
		objStatusTypeList1_page1.navigateToStatusTypeList();

	
		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strNumberStatusType,
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);
				

		strStatusTypeValues1[0] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strNSTStatusTypeName);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strTextStatusType,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);
				

		strStatusTypeValues1[1] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strTSTStatusTypeName);


		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strMultiStatusType,
				objStatusTypesdata_page1.strMSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);
				
		 
		objStatusTypeList1_page1.createNewStatus(objStatusTypesdata_page1.strStatusNameInMulti,
				objStatusTypesdata_page1.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypesdata_page1.strStatusNameInMulti);	
		
		objStatusTypeList1_page1.createNewStatus(objStatusTypesdata_page1.strStatusNameInMulti1,
				objStatusTypesdata_page1.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypesdata_page1.strStatusNameInMulti1);	
		
		strMultiStatusesTypeValues2[0] = objStatusTypeList1_page1.getStatusesValue(
				objStatusTypesdata_page1.strStatusNameInMulti);

		strMultiStatusesTypeValues2[1] = objStatusTypeList1_page1.getStatusesValue(
				objStatusTypesdata_page1.strStatusNameInMulti1);
		
		objStatusTypeList1_page1.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[2] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strMSTStatusTypeName);
		
		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strDateStatusType,
				objStatusTypesdata_page1.strDateStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription);
			
		strStatusTypeValues1[3] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strDateStatusTypeName1);


		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strSaturationScoreStatusType,
				objStatusTypesdata_page1.strSSTStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription);
				

		strStatusTypeValues1[4] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strSSTStatusTypeName1);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strNedocCalculationStatusType,
				objStatusTypesdata_page1.strNDSTStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription);
				
		strStatusTypeValues1[5] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strNDSTStatusTypeName1);

		objResourceType_page1.navigateToResourceTypePage().createResourceType(
				objResourceTypedata_page1.strResourceTypeName,
				strStatusTypeValues1);
		

		strResourceTypeValue[0] = objResourceType_page1
				.getResourceTypeValue(objResourceTypedata_page1.strResourceTypeName);

		objResource_page1.navigateToResourceListPage().createResource(
				objResourcedata_page1.strResourceName,
				objResourcedata_page1.strResourceAbbrivation1,
				objResourceTypedata_page1.strResourceTypeName,
				objResourcedata_page1.strStandardResourceTypename,
				objResourcedata_page1.strResourceFirstName,
				objResourcedata_page1.strResourceLastName);
		
		Resvalue[0] = objResource_page1
				.getResourceValue(objResourcedata_page1.strResourceName);

//		objviewsList_page1
//				.clickCreateNewViewButton()
//				.enterViewName(objViewdata_page1.strViewName)
//				.enterViewDesc(objViewdata_page1.strViewDesc);
//
		String[] selectStatusTypesInView = {
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strMSTStatusTypeName,
				objStatusTypesdata_page1.strSSTStatusTypeName1 };
//
//		for (int k = 0; k < selectStatusTypesInView.length; k++) {
//			objviewsList_page1.selectStatusType(selectStatusTypesInView[k]);
//		}
//
//		objviewsList_page1
//				.selectResource(objResourcedata_page1.strResourceName)
//				.clickOnSaveOfCreateNewView()
		objviewsList_page1.navigateToViewsList()
						  .createView(objViewdata_page1.strViewName, objViewdata_page1.strViewDesc,
				objResourcedata_page1.strResourceName, selectStatusTypesInView);

		objUsersList_page1
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName2,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResourcedata_page1.strResourceName)
				.selectRunReportsCheckBox(objResourcedata_page1.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption().clickSaveButton();

		login_page1.clickLogOut();

		login_page2.loginAsNewUser(objUserdata_page1.strNewUserName2,
				objUserdata_page1.strNewPassword);

		objRegionDefault_page2.selectFrame();
		Thread.sleep(5000);
			
			System.out.println(objResourcedata_page1.strResourceName);

		objNavigationToSubmenus2.clickOnViewMenu();

		objNavigationToSubmenus2
				.navigateToParticularViewUnderViewMenu(objViewdata_page1.strViewName);

		objviewsList_page2
				.clickOnUpdateStatus(objResourcedata_page1.strResourceName);

		Updatestatus_page2.clickOnSelectAll();

		Updatestatus_page2.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
				objViewdata_page1.strValueForUpdate);

		Updatestatus_page2.enterNSTAndTSTUpdateValue(strStatusTypeValues1[1],
				objViewdata_page1.strValueForTST);

		Updatestatus_page2.selectMSTUpdateValue(strStatusTypeValues1[2],
				strMultiStatusesTypeValues2[0]);

		Updatestatus_page2.enterUpdateSSTValues(strStatusTypeValues1[4],
				objViewdata_page1.strValueForSST);

		Updatestatus_page2.clickOnSaveButton();

		Updatestatus_page2
				.verifyUpdatedStatusValues(Resvalue[0],
						strStatusTypeValues1[0],
						objViewdata_page1.strValueForUpdate)

				.verifyUpdatedStatusValues(Resvalue[0],
						strStatusTypeValues1[1],
						objViewdata_page1.strValueForTST)

				.verifyUpdatedStatusValues(Resvalue[0],
						strStatusTypeValues1[2],
						objStatusTypesdata_page1.strStatusNameInMulti)

				.verifyUpdatedStatusValues(Resvalue[0],
						strStatusTypeValues1[4],
						objViewdata_page1.strUpdatedValForSST);
			
			System.out.println(objViewdata_page1.strViewName);

		login_page2.clickLogOut();

		login_page2.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page2.selectRegionAndNavigate(login_data.strRegionName);
		objRegionDefault_page2.selectFrame();

		objNavigationToSubmenus2.navigateToViews();

		objviewsList_page2.clickOnEditLinkOfView(objViewdata_page1.strViewName)
		.clickOnSTTab();

		
		String[] selectREmStatusTypesInView = {
				objStatusTypesdata_page1.strDateStatusTypeName1,
				objStatusTypesdata_page1.strNDSTStatusTypeName1 };

		for (int i = 0; i < selectREmStatusTypesInView.length; i++) {
			objviewsList_page2.selectStatusType(selectREmStatusTypesInView[i]);
		}

		objviewsList_page2.clickOnSave();

		login_page2.clickLogOut();

		login_page2.loginToApplication(objUserdata_page1.strNewUserName2,
				objUserdata_page1.strNewPassword);
		System.out.println(objUserdata_page1.strNewUserName2);
		System.out.println(objUserdata_page1.strNewPassword);
		System.out.println(objViewdata_page1.strViewName);
		objRegionDefault_page2.selectFrame();

		objNavigationToSubmenus2
				.navigateToParticularViewUnderViewMenu(objViewdata_page1.strViewName);

		objviewsList_page2
				.clickOnUpdateStatus(objResourcedata_page1.strResourceName);

		Updatestatus_page2.selectStatusTypes(strStatusTypeValues1[5]);

		Updatestatus_page2.enterNedocsUpdateValue(strStatusTypeValues1[5],
				objViewdata_page1.strValueForNDST);

		Updatestatus_page2.selectStatusTypes(strStatusTypeValues1[3]);

		Updatestatus_page2.enterNSTAndTSTUpdateValue(strStatusTypeValues1[3],
				objViewdata_page1.strDateUpdateValue);
		Updatestatus_page2.clickOnSaveButton();
		Thread.sleep(60000);

		String strApplicationTime1 = obgEventManagement_page2
				.getApplicationTime();
		String strCurrentYear1 = objDTS.getCurrentDate("yyyy");

		strApplicationTime1 = strApplicationTime1 + " " + strCurrentYear1;

		System.out.println("app time & current year" + strApplicationTime1);

		strApplicationTime1 = objDTS.converDateFormat(strApplicationTime1,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime1 = objDTS.AddTimeToExistingTimeHourAndMin(
				strApplicationTime1, 0, 1, "MM/dd/yyyy HH:mm");

		String strApplicationTime2 = objDTS.converDateFormat(
				strApplicationTime1, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");

		String strDate = objDTS.converDateFormat(strApplicationTime1,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDTS.converDateFormat(strApplicationTime1,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDTS.converDateFormat(strApplicationTime1,
				"MM/dd/yyyy HH:mm", "mm");
		System.out.println("date" + strDate);
		System.out.println("hour" + strHour);
		System.out.println("minut" + strMinutes);

		Updatestatus_page2.verifyUpdatedStatusValues(Resvalue[0],
				strStatusTypeValues1[5], objViewdata_page1.strNEDOCValue)

		.verifyUpdatedStatusValues(Resvalue[0], strStatusTypeValues1[3],
				objViewdata_page1.strDateUpdateValue);

		objRegionDefault_page2.clickPrintOption()
				.clickOnSelectDateAndTimeOption();

		objRegionDefault_page2.selectAndEnterDateAndTime(strDate, strHour,
				strMinutes);

		Thread.sleep(2000);
		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objReport_page2.verifyViewNameInRegionViewHtmlReport(
				objViewdata_page1.strViewName, strApplicationTime2);

		String[] strHeaderNames = {
				objResourceTypedata_page1.strResourceTypeName,
				objStatusTypesdata_page1.strMSTStatusTypeName,
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strSSTStatusTypeName1,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strDateStatusTypeName1,
				objStatusTypesdata_page1.strNDSTStatusTypeName1, "Comment" };

		String[] strUpdatedValues = { objResourcedata_page1.strResourceName,
				objStatusTypesdata_page1.strStatusNameInMulti,
				objViewdata_page1.strValueForUpdate,
				objViewdata_page1.strUpdatedValForSST,
				objViewdata_page1.strValueForTST,
				objViewdata_page1.strDateUpdateValue,
				objViewdata_page1.strNEDOCValue, "" };

		objReport_page2.verHTMLFormHeadersAndAnswersInRegionViewRep(
				strHeaderNames, strUpdatedValues);
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault_page2.switchToDefaultFrame().selectFrame();

		login_page2.clickLogOut();

		gstrResult = "PASS";
	}
}