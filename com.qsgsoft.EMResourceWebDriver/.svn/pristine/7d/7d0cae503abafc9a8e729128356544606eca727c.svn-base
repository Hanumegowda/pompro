package requirementGroup.CreatingAndManagingStatusTypes;

import java.util.Iterator;
import java.util.Set;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusReason_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusReasonList;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class CreatingAndManagingStatusTypes extends TestNG_UI_EXTENSIONS {

	public CreatingAndManagingStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/******************************************************************************
	'Description : Verify that status reasons selected while updating multi status type are displayed in generated 'view snapshots' report. 
	'Date	 	 : 27-Oct-2015
	'Author		 : Sangappa.K
	'------------------------------------------------------------------------------
	'Modified Date			                        	          Modified By
	'Date					                                      Name
	*******************************************************************************/
	@Test(description ="Verify that status reasons selected while updating multi status type are displayed in generated 'view snapshots' report. ")
	public void testHappyDay168827() throws Exception {

		gstrTCID ="168827";
		gstrTO ="Verify that status reasons selected while updating multi status type are displayed in generated 'view snapshots' report.";

		Login_data objLogindata = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		View_data objView_data = new View_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Report_data objReport_data = new Report_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource Resource_page = new Resource(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		Report objReport1 = new Report(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();

		String strStatusTypeValues[] = new String[4];
		String strStatusesValues[] = new String[8];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strApplicationTime = "";

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		String strReasonVal = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		String strReasonVal1 = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName2,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		String strReasonVal2 = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName2);

		objStatusTypeList.navigateToStatusTypeListNew();

		// Roled MST

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal)
				.selectStatusReason(strReasonVal1)
				.selectStatusReason(strReasonVal2).clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strReasonVal)
				.selectStatusReasonForStatus(strReasonVal1)
				.selectStatusReasonForStatus(strReasonVal2).clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strReasonVal)
				.selectStatusReasonForStatus(strReasonVal1)
				.selectStatusReasonForStatus(strReasonVal2).clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// Event MSt

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName1)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectEventOnlyOption().selectStatusReason(strReasonVal)
				.selectStatusReason(strReasonVal1)
				.selectStatusReason(strReasonVal2).clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti2)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strReasonVal)
				.selectStatusReasonForStatus(strReasonVal1)
				.selectStatusReasonForStatus(strReasonVal2).clickOnSaveButton();

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti3)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strReasonVal)
				.selectStatusReasonForStatus(strReasonVal1)
				.selectStatusReasonForStatus(strReasonVal2).clickOnSaveButton();

		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		// Private MST

		objStatusTypeList

				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName2)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription2)
				.selectPrivateStatusTypeRadioBtn()
				.selectStatusReason(strReasonVal)
				.selectStatusReason(strReasonVal1)
				.selectStatusReason(strReasonVal2).clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti4)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strReasonVal)
				.selectStatusReasonForStatus(strReasonVal1)
				.selectStatusReasonForStatus(strReasonVal2).clickOnSaveButton();

		strStatusesValues[4] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti4);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti5)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strReasonVal)
				.selectStatusReasonForStatus(strReasonVal1)
				.selectStatusReasonForStatus(strReasonVal2).clickOnSaveButton();

		strStatusesValues[5] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti5);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);

		// Shared MST

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName3)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectSharedStatusTypeRadioBtn()
				.selectStatusReason(strReasonVal)
				.selectStatusReason(strReasonVal1)
				.selectStatusReason(strReasonVal2).clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti6)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strReasonVal)
				.selectStatusReasonForStatus(strReasonVal1)
				.selectStatusReasonForStatus(strReasonVal2).clickOnSaveButton();

		strStatusesValues[6] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti6);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti7)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strReasonVal)
				.selectStatusReasonForStatus(strReasonVal1)
				.selectStatusReasonForStatus(strReasonVal2).clickOnSaveButton();

		strStatusesValues[7] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti7);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName3);

		// RT
		ResourceType_page.navigateToResourceTypePage();

		ResourceType_page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = ResourceType_page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		Resource_page.navigateToResourceListPage();

		Resource_page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		System.out.println(objResource_data.strResourceName);

		strResourceValue[0] = Resource_page
				.getResourceValue(objResource_data.strResourceName);

		// user creation

		objNavigationToSubmenus.navigateToUsers();

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.selectReportStatusSnapshotOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		
		System.out.println(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		// Event

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		// View

		objNavigationToSubmenus.navigateToViews();

		String[] strStatusTypes = { objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strMSTStatusTypeName3 };

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypes);
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatusTypes.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypes[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		System.out.println(objView_data.strViewName);
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue).clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);

		System.out.println(objEvent_data.strEventName);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		UpdateStatus_page1.clickOnSelectAll();

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[0],
						strStatusesValues[0])

				.selectMSTUpdateValue(strStatusTypeValues[2],
						strStatusesValues[4])
				.selectMSTReasonValue(strReasonVal2, strStatusTypeValues[2],
						strStatusesValues[4])

				.selectMSTUpdateValue(strStatusTypeValues[3],
						strStatusesValues[7])
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[3],
						strStatusesValues[7]).clickOnSaveButton();

		strApplicationTime = objEventManagement1.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strTime[0] + " " + strTime[1] + " " + strTime[2]
				+ " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(
				strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");

		String strApplicationTime1 = objDts.converDateFormat(
				strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");

		System.out.println(strApplicationTime);
		System.out.println(strApplicationTime1);
		Thread.sleep(180000);
		System.out.println("dsf");

		String strViewReasons = "" + objStatusReason_data.strReasonName + " | "
				+ objStatusReason_data.strReasonName2 + " | "
				+ objStatusReason_data.strReasonName + "";

		objUpdateStatus1.verifyUpdatedStatusreasons(
				objResource_data.strResourceName, strViewReasons);

		objRegionDefault1.clickPrintOption();

		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");
		objRegionDefault1.selectAndEnterDateAndTime(strDate, strHour,
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
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strMSTStatusTypeName3, "Comment" };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusNameInMulti4,
				objStatusTypes_data.strStatusNameInMulti7, strViewReasons };

		objReport1.verifyViewNameInRegionViewHtmlReport(
				objView_data.strViewName, strApplicationTime1);

		objReport1.verHTMLFormHeadersAndAnswersInRegionViewRep(strHeaderNames,
				strUpdatedValues);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToEventList();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		UpdateStatus_page1.clickOnSelectAll();

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal2, strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[3])
				.selectMSTReasonValue(strReasonVal1, strStatusTypeValues[1],
						strStatusesValues[3])
				.selectMSTUpdateValue(strStatusTypeValues[2],
						strStatusesValues[4])
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[2],
						strStatusesValues[4])
				.selectMSTUpdateValue(strStatusTypeValues[3],
						strStatusesValues[7])
				.selectMSTReasonValue(strReasonVal2, strStatusTypeValues[3],
						strStatusesValues[7]).clickOnSaveButton();

		strApplicationTime = objEventManagement1.getApplicationTime();

		String strAppTimeWithTimeZone = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String[] strTimeZone = strAppTimeWithTimeZone.split(" ");
		String strCurrentYear1 = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear1;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		String strApplicationTime2 = strApplicationTime;
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(
				strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");

		String strApplicationTime3 = objDts.converDateFormat(
				strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");

		System.out.println(" With Time zoon " + strApplicationTime3 + " "
				+ strTimeZone[3]);

		Thread.sleep(180000);
		
		System.out.println("dsf");

		objRegionDefault1.clickPrintOption();

		String strDate1 = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour1 = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes1 = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");
		String lastupdate = objDts.converDateFormat(strApplicationTime2,
				"MM/dd/yyyy HH:mm", "dd MMM HH:mm");

		System.out.println("lastupdate" + lastupdate);

		objRegionDefault1.clickOnSelectDateAndTimeOption()
				.selectAndEnterDateAndTime(strDate1, strHour1, strMinutes1);

		Thread.sleep(2000);

		String mainWindowHandle3 = driver1.getWindowHandle();
		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strEventHeaderNames = {
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strMSTStatusTypeName3,
				objReport_data.comment, objReport_data.lastupdate,
				objReport_data.byuser };

		String[] summaryRow = { "Summary", "N/A", "N/A", "N/A", "N/A", "", "",
				"" };

		String strEventReasons = "" + objStatusReason_data.strReasonName2
				+ " | " + objStatusReason_data.strReasonName1 + " | "
				+ objStatusReason_data.strReasonName + " | "
				+ objStatusReason_data.strReasonName2 + "";

		String[] strEventUpdatedValues = { objResource_data.strResourceName,
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusNameInMulti3,
				objStatusTypes_data.strStatusNameInMulti4,
				objStatusTypes_data.strStatusNameInMulti7, strEventReasons,
				lastupdate + " " + strTimeZone[3], objUser_data.strFullName };

		objRegionDefault1.verEventSnapShotWindow(objEvent_data.strEventName,
				strApplicationTime3 + " " + strTimeZone[3]);

		objReport1.verHTMLFormHeadersAndAnswersInEventSnapshotReport(
				strEventHeaderNames, strEventUpdatedValues, summaryRow);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	

}
