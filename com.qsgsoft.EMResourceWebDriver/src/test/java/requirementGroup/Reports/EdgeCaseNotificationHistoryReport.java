package requirementGroup.Reports;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;
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
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.FileFormatConverter;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseNotificationHistoryReport extends TestNG_UI_EXTENSIONS {
	
//Disgine change Web content is not displayed in Notification histry report need to Modify

	public EdgeCaseNotificationHistoryReport() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***************************************************************************************************************
	 * 'Description :Verify that details about normal event creation (immediate,scheduled)are displayed appropriately in the 'Notification History' report. 
	 * 'Date : 25-May-2014 
	 * 'Author : Sangappa.k    
	 ***************************************************************************************************************/

	@Test(description ="Verify that details about normal event creation (immediate,scheduled)are displayed appropriately in the 'Notification History' report.")
	public void testEdgeCase162295() throws Exception {

		gstrTCID = "162295";
		gstrTO = "Verify that details about normal event creation (immediate,scheduled)are displayed appropriately in the 'Notification History' report. ";

		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login_data login_data = new Login_data();
		User_data objUserdata_page1 = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login login_page = new Login(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		UsersList objUsersList_page = new UsersList(driver);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);

		Login objLogin1 = new Login(driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);

		Report objReport1 = new Report(driver1);
		AutoIT objAutoIT = new AutoIT(driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Date_Time_settings dts= new Date_Time_settings();

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

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;


		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page.selectFrame();


		objUsersList_page
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata_page1.strNewUserName,
				objUserdata_page1.strNewPassword,
				objUserdata_page1.strFullName).selectFirstRole()
				.enterEmail(objUserdata_page1.strPrimaryMailId)	
				.enterPrimaryEmailId(objUserdata_page1.strPrimaryMailId)
				.entertextPagerId(objUserdata_page1.strPrimaryMailId)
				.clickSaveButton();

		System.out.println(" new user name" + objUserdata_page1.strNewUserName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();
		objEventSetUp.clickOncreateEventTemplate()
		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton()
				.deselectSelectAllWebOptionChkBox()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.clickOnWebCheckBox(objUserdata_page1.strNewUserName)
				.clickOnPagerCheckBox(objUserdata_page1.strNewUserName)
				.clickOnEmailCheckBox(objUserdata_page1.strNewUserName)
				.clickSaveButton();

		System.out.println("Template"+ objEventSetUp_data.strEventTemplate);

		String strApplTimeD1 = dts.getFutureDay(1, "M/d/yyyy");

		String[] strDate = strApplTimeD1.split("/");

		System.out.println(strDate[1]);

		EventManagement_page.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.clickEventEndRadioButton()

		.selectEventEndDay(strDate[1]);

		EventManagement_page.clickOnSaveButton();//.verifyEventName(objEvent_data.strEventName);
		String eventStartdate=EventManagement_page.getEventStartDateAndTime(objEvent_data.strEventName);    

		String strCurrentYear1 = dts.getCurrentDate("yyyy");

		String year=strCurrentYear1.substring(2);

		String[] date=eventStartdate.split(" ");

		System.out.println("current year" + year);

		System.out.println("current time" + date[1]);


		System.out.println("Event "  +    objEvent_data.strEventName);

		login_page.clickLogOut();

		// login as new user
		objLogin1.loginAsNewUser(objUserdata_page1.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		EventManagement_page1
		.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
				objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications();

		EventManagement_page1 .selectFrame();

		String strAckTime = EventManagement_page1.getApplicationTime();

		System.out.println("strAckTime"+ strAckTime);
		String[] strAck =strAckTime.split(" ");

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToAdminReports();
		String strApplicationTime = EventManagement_page1.getApplicationTime();

		String strCurrentYear = dts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strStartDate = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		String[] splitdate =strStartDate.split("/");

		String Xldate=splitdate[0]+"/"+splitdate[1]+"/"+year+" "+date[1];
		
		String acktime=dts.AddTimeToExistingTimeHourAndMin(strAck[2], 0, 1, "HH:mm");
		
		String AckTime=splitdate[0]+"/"+splitdate[1]+"/"+year+" "+strAck[2];
		
		String AckTime2=splitdate[0]+"/"+splitdate[1]+"/"+year+" "+acktime;

		System.out.println("Event started date with time" + Xldate);

		System.out.println("Ackcnowledged date with time" + acktime);

		objReport1.verifyAdminReportPage().clickOnNotificationHistory()
		.verifyNotificationHistoryPage()
		.enterNotificationHistoryStartDate(strStartDate)
		.enterNotificationHistoryEndDate(strStartDate)
		.clickOnGenerateReportBtn();
		// excel verfication

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;

		objFileFormatConverter.convertXlsxToXls(strDownloadName,
				strDownloadName1);

		assertTrue(new File(strDownloadName1).exists());

		String strValue = objOffCommonFunc.readInfoExcel(
				"Notification History", 1, 1, strDownloadName1);

		String[] strHeaderNames = objReport_data.NotificationHistoryReportHeader;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					2, intCount, strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

		}

		String[] strNotificationWEBData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				"", "EVENT",
				"EMResource"+" "+objEvent_data.strEventName, objEvent_data.strEventDescription,
				"WEB", Xldate, login_data.strRegionName,
				objEvent_data.strEventName, "","", "N", "Y",AckTime};

		String mailContent ="Event Notice for: "+objUserdata_page1.strFullName+"\n"
				+"Information: "+objEvent_data.strEventDescription+"\n\n"+
				"From: "+login_data.strQSGFullName+"\n\n"+
				"Regions: "+login_data.strRegionName+"\n\n"+
				"Please do not reply to this email message. You must log into EMResource to take any action that may be required.";

		System.out.println("mail content"+ mailContent);

		String[] strNotificationMailData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				objUserdata_page1.strPrimaryMailId, "EVENT",
				"EMResource"+" "+objEvent_data.strEventName, mailContent,
				"EMAIL", Xldate, login_data.strRegionName,
				objEvent_data.strEventName, "","", "N", "N/A","--" };


		String pagerContent="Information: "+objEvent_data.strEventDescription+"\n"+
				"From: "+login_data.strQSGFullName+"\n"+
				"Regions: "+login_data.strRegionName;

		System.out.println("pager content"+ pagerContent);

		String[] strNotificationPagerData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				objUserdata_page1.strPrimaryMailId, "EVENT",
				objEvent_data.strEventName, pagerContent,
				"PAGER", Xldate, login_data.strRegionName,
				objEvent_data.strEventName, "","", "N", "N/A","--" };
		
		boolean strPager = false, strMAil = false, strWeb = false;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					2, intCount, strDownloadName1);

			assertEquals(strHeaderNames[intCount - 1], strValue);

		}

		int rowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, "Notification History");

		System.out.println("row count" + rowCount);

	for (int mainCount = 1; mainCount <= rowCount; mainCount++) {

		strValue = objOffCommonFunc.readInfoExcel("Notification History",
				mainCount, 1, strDownloadName1);

		if (objUserdata_page1.strNewUserName.equals(strValue)) {
			
			strValue = objOffCommonFunc.readInfoExcel(
					"Notification History", mainCount, 7, strDownloadName1);
			
			System.out.println(strValue);
			
	
			
				switch (strValue) {
				
			/*	//Disgine change Web content is not displayed in Notification histry report need to Modify			

				case "WEB": {

					for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
						if (intCount == 15) {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1); 
							System.out.println(strValue);
 
							assertTrue(strNotificationWEBData[intCount - 1]
									.contains(strValue)
									|| strValue.contains(AckTime2));
						

						} else {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);

							System.out.println("NOtificaton Capture WEB  data"
									+ strValue);

							assertEquals(strNotificationWEBData[intCount - 1],
									strValue);
						}

					}

					strWeb = true;
				}
					break;*/

				case "EMAIL": {

					for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

						if (intCount == 6) {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);
							System.out.println("NOtificaton Mail Capture  data"
									+ strValue);

							assertTrue(strValue
									.contains(strNotificationMailData[intCount - 1]));

						} else {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);

							System.out.println("NOtificaton Capture  Mail data"
									+ strValue);

							assertEquals(strNotificationMailData[intCount - 1],
									strValue);
						}

					}
					strMAil = true;
				}
					break;

				case "PAGER": {

					for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

						if (intCount == 6) {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);
							System.out
									.println("NOtificaton Pager Capture  data"
											+ strValue);

							assertTrue(strValue
									.contains(strNotificationPagerData[intCount - 1]));

						}

						else {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);

							System.out.println("NOtificaton Pager  data"
									+ strValue);

							assertEquals(
									strNotificationPagerData[intCount - 1],
									strValue);
						}

					}

					strPager = true;

				}
					break;

				default: {
					System.out.println("No Emil,Pager,Web");
				}

				}
			}

			if (strMAil && strPager) {

				Thread.sleep(5000);
				objRegionDefault1.switchToDefaultFrame().selectFrame();
				objLogin1.clickLogOut();
				gstrResult = "PASS";
				break;

			}

		}

	}

	/***************************************************************************************************************
	 * 'Description :Verify that details about adhoc event creation (immediate,scheduled)are displayed appropriately in the 'Notification History' report.. 
	 * 'Date : 29-June-2015
	 * 'Author : Sangappa.k
	 ***************************************************************************************************************/

	@Test(description ="Verify that details about adhoc event creation (immediate,scheduled)are displayed appropriately in the 'Notification History' report.")
	public void testEdgeCase162297() throws Exception {

		gstrTCID ="162297";
		gstrTO = "Verify that details about adhoc event creation (immediate,scheduled)are displayed appropriately in the 'Notification History' report. ";

		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login_data login_data = new Login_data();
		User_data objUserdata_page1 = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
	

		Login login_page = new Login(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		UsersList objUsersList_page = new UsersList(driver);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);

		Report objReport1 = new Report(driver1);
		AutoIT objAutoIT = new AutoIT(driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Date_Time_settings dts= new Date_Time_settings();

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

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];


		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page.selectFrame();
		
		
		objStatusTypeList.navigateToStatusTypeList()

		.createEventStatusType(objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		System.out.println(" RESTyp name"
				+ objResourceType_data.strResourceTypeName);

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

		System.out.println(" RES name" + objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName).selectFirstRole()
				.enterEmail(objUserdata_page1.strPrimaryMailId)
				.enterPrimaryEmailId(objUserdata_page1.strPrimaryMailId)
				.entertextPagerId(objUserdata_page1.strPrimaryMailId)
				.clickSaveButton();

		System.out.println(" new user name" + objUserdata_page1.strNewUserName);

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strAdHocEventTemplate)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOptionChkBox()
				.clickOnEmailNotification(objUserdata_page1.strNewUserName,
						true)
				.clickOnPagerNotification(objUserdata_page1.strNewUserName,
						true)
				.clickOnWebNotification(objUserdata_page1.strNewUserName, true)
				.clickSaveButton();

		String strApplTimeD1 = dts.getFutureDay(1, "M/d/yyyy");

		String[] strDate = strApplTimeD1.split("/");

		EventManagement_page.navigateToEventManagement()

	/*	.verifyEventManagementPage().verifyCreateEventButtonDisplayed()
				.verifyCreateEventButtonsDisplayed()*/
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickEventEndRadioButton().selectEventEndDay(strDate[1])
				.clickOnNextButton().verifySelectResourcesDisplayed();

		objResource.clickResource(strResourceValue);

		EventManagement_page.clickOnNextButton()
				.verifySelectStatusTypesDisplayed();

		String[] strStatusTypeNames = { objStatuTypes_data.streTSTStatusTypeName };

		EventManagement_page
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);

		objResourceType.clickStatusType(strstatusTypeValues);

		EventManagement_page.clickOnNextButton()
				.verifyAdHocEventConfirmationDisplayed().clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName);

		String eventStartdate = EventManagement_page
				.getEventStartDateAndTime(objEvent_data.strEventName);

		System.out.println("Event start date  " + eventStartdate);

		String strCurrentYear1 = dts.getCurrentDate("yyyy");

		String year = strCurrentYear1.substring(2);

		String[] date = eventStartdate.split(" ");

		System.out.println("current year" + year);

		System.out.println("current time" + date[1]);

		System.out.println("Event " + objEvent_data.strEventName);

		login_page.clickLogOut();

		// login as new user
		objLogin1.loginAsNewUser(objUserdata_page1.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		EventManagement_page1
		.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
				objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications();

		EventManagement_page1 .selectFrame();

		String strAckTime = EventManagement_page1.getApplicationTime();

		System.out.println("strAckTime"+ strAckTime);
		String[] strAck =strAckTime.split(" ");

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToAdminReports();
		String strApplicationTime = EventManagement_page1.getApplicationTime();

		String strCurrentYear = dts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strStartDate = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		String[] splitdate =strStartDate.split("/");

		String Xldate=splitdate[0]+"/"+splitdate[1]+"/"+year+" "+date[1];
		
		String acktime=dts.AddTimeToExistingTimeHourAndMin(strAck[2], 0, 1, "HH:mm");
		
		String AckTime=splitdate[0]+"/"+splitdate[1]+"/"+year+" "+strAck[2];
		
		String AckTime2=splitdate[0]+"/"+splitdate[1]+"/"+year+" "+acktime;

		System.out.println("Event started date with time" + Xldate);

		System.out.println("Ackcnowledged date with time" + acktime);

		objReport1.verifyAdminReportPage().clickOnNotificationHistory()
		.verifyNotificationHistoryPage()
		.enterNotificationHistoryStartDate(strStartDate)
		.enterNotificationHistoryEndDate(strStartDate)
		.clickOnGenerateReportBtn();
		
		// excel verfication

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;

		objFileFormatConverter.convertXlsxToXls(strDownloadName,
				strDownloadName1);

		assertTrue(new File(strDownloadName1).exists());

		String strValue = objOffCommonFunc.readInfoExcel(
				"Notification History", 1, 1, strDownloadName1);

		String[] strHeaderNames = objReport_data.NotificationHistoryReportHeader;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					2, intCount, strDownloadName1);

			System.out
					.println("Passed Headers " + strHeaderNames[intCount - 1]);

			System.out.println("Captured headers " + strValue);

			assertEquals(strHeaderNames[intCount - 1], strValue);

		}

		String[] strNotificationWEBData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName, "", "EVENT",
				objEvent_data.strEventName, objEvent_data.strEventDescription,
				"WEB", Xldate, login_data.strRegionName,
				objEvent_data.strEventName, "", "", "N", "Y", AckTime };

		String mailContent = "Event Notice for: "
				+ objUserdata_page1.strFullName
				+ "\n"
				+ "Information: "
				+ objEvent_data.strEventDescription
				+ "\n\n"
				+ "From: "
				+ login_data.strQSGFullName
				+ "\n\n"
				+ "Regions: "
				+ login_data.strRegionName
				+ "\n\n"
				+ "Please do not reply to this email message. You must log into EMResource to take any action that may be required.";

		System.out.println("mail content" + mailContent);

		String[] strNotificationMailData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				objUserdata_page1.strPrimaryMailId, "EVENT",
				"EMResource"+" "+objEvent_data.strEventName, mailContent, "EMAIL", Xldate,
				login_data.strRegionName, objEvent_data.strEventName, "", "",
				"N", "N/A", "--" };

		String pagerContent = "Information: "
				+ objEvent_data.strEventDescription + "\n" + "From: "
				+ login_data.strQSGFullName + "\n" + "Regions: "
				+ login_data.strRegionName;

		System.out.println("pager content" + pagerContent);

		String[] strNotificationPagerData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				objUserdata_page1.strPrimaryMailId, "EVENT",
				"EMResource"+" "+objEvent_data.strEventName, pagerContent, "PAGER", Xldate,
				login_data.strRegionName, objEvent_data.strEventName, "", "",
				"N", "N/A", "--" };

		boolean strPager = false, strMAil = false, strWeb = false;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					2, intCount, strDownloadName1);

			assertEquals(strHeaderNames[intCount - 1], strValue);

		}

		System.out.println("row count");

		int rowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, "Notification History");

		System.out.println("row count" + rowCount);

		for (int mainCount = 1; mainCount <= rowCount; mainCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					mainCount, 1, strDownloadName1);

			if (objUserdata_page1.strNewUserName.equals(strValue)) {

				strValue = objOffCommonFunc.readInfoExcel(
						"Notification History", mainCount, 7, strDownloadName1);

				switch (strValue)

				{

				case "EMAIL": {

					for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
						if (intCount == 6) {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);
							System.out.println("NOtificaton Mail Capture  data"
									+ strValue);

							assertTrue(strValue
									.contains(strNotificationMailData[intCount - 1]));
						} else {
							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);

							System.out.println("NOtificaton Capture  Mail data"
									+ strValue);

							assertEquals(strNotificationMailData[intCount - 1],
									strValue);
						}

					}
					strMAil = true;

				}
					break;

				case "PAGER": {

					for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

						if (intCount == 6) {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);
							System.out
									.println("NOtificaton Pager Capture  data"
											+ strValue);

							assertTrue(strValue
									.contains(strNotificationPagerData[intCount - 1]));

						} else {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);

							System.out.println("NOtificaton Pager  data"
									+ strValue);

							assertEquals(
									strNotificationPagerData[intCount - 1],
									strValue);
						}

					}

					strPager = true;

				}
					break;
					
		//Disgine change Web content is not displayed in Notification histry report need to Modify			

				/*case "WEB": {

					for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
						if (intCount == 15) {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);

							assertTrue(strNotificationWEBData[intCount - 1]
									.contains(strValue)
									|| strValue.contains(AckTime2));

						} else {

							strValue = objOffCommonFunc.readInfoExcel(
									"Notification History", mainCount,
									intCount, strDownloadName1);

							System.out.println("NOtificaton Capture WEB  data"
									+ strValue);

							assertEquals(strNotificationWEBData[intCount - 1],
									strValue);
						}
						
						

					}
					strWeb = true;*/

			/*	}
					break;*/

				default: {

					System.out.println("No Emil,Pager");

				}

				}

			}
		

			if (strMAil && strPager) {

				Thread.sleep(5000);
				objRegionDefault1.switchToDefaultFrame().selectFrame();
				objLogin1.clickLogOut();
				gstrResult = "PASS";
				break;

			}

		}

	}
	
	/***************************************************************************************************************
	 * 'Description :Verify that details about event update are (editing the details,adding new resources)are displayed appropriately in the 'Notification History' report. 
	 * 'Date : 1-July-2015
	 * 'Author : Sangappa.k
	 ***************************************************************************************************************/

	@Test(description ="Verify that details about event update are (editing the details,adding new resources)are displayed appropriately in the 'Notification History' report.")
	public void testEdgeCase162314() throws Exception {

		gstrTCID ="162314";
		gstrTO = "Verify that details about event update are (editing the details,adding new resources)are displayed appropriately in the 'Notification History' report.";

		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login_data login_data = new Login_data();
		User_data objUserdata_page1 = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
	

		Login login_page = new Login(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		UsersList objUsersList_page = new UsersList(driver);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		
		
		//ie driver1

		Login objLogin1 = new Login(driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);

		Report objReport1 = new Report(driver1);
		AutoIT objAutoIT = new AutoIT(driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Date_Time_settings dts= new Date_Time_settings();

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

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];


		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page.selectFrame();
		
		
		objStatusTypeList.navigateToStatusTypeList()

		.createEventStatusType(objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		System.out.println(" RESTyp name"
				+ objResourceType_data.strResourceTypeName);

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

		System.out.println(" RES name" + objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName).selectFirstRole()
				.enterEmail(objUserdata_page1.strPrimaryMailId)
				.enterPrimaryEmailId(objUserdata_page1.strPrimaryMailId)
				.entertextPagerId(objUserdata_page1.strPrimaryMailId)
				.clickSaveButton();

		System.out.println(" new user name" + objUserdata_page1.strNewUserName);

		// create Event template
				objEventSetUp.navigateToEventSetUp();
				objEventSetUp.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
						.clickSaveButton()
						.deselectSelectAllWebOptionChkBox()
						.deselectSelectAllEmailOption()
						.deselectSelectAllPagerOption()
						.clickOnWebCheckBox(objUserdata_page1.strNewUserName)
						.clickOnPagerCheckBox(objUserdata_page1.strNewUserName)
						.clickOnEmailCheckBox(objUserdata_page1.strNewUserName)
						.clickSaveButton();

				System.out.println("Template"+ objEventSetUp_data.strEventTemplate);

				String strApplTimeD1 = dts.getFutureDay(1, "M/d/yyyy");

				String[] strDate = strApplTimeD1.split("/");

				System.out.println(strDate[1]);

				EventManagement_page.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)

				.clickEventEndRadioButton()

				.selectEventEndDay(strDate[1]);

				EventManagement_page.clickOnSaveButton().verifyEventName(objEvent_data.strEventName);
				

				System.out.println("Event "+ objEvent_data.strEventName);

		login_page.clickLogOut();

		// login as new user(1St login)
		objLogin1.loginAsNewUser(objUserdata_page1.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		EventManagement_page1
		.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
				objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications();

		EventManagement_page1 .selectFrame();

		objLogin1.clickLogOut();
		
		
		
		//login to application (edit eve)

		objLogin1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		EventManagement_page1.navigateToEventManagement();
		
		System.out.println("dfg");
		
		EventManagement_page1.clickOnEditLink(objEvent_data.strEventName)
		
		     .enterAdHocEventName(objEvent_data.strEditedEventName)
		    
			.enterAdHocEventDescription(objEvent_data.strEditedEventDescription)
			.selectResource(strResourceValue);
		EventManagement_page1.clickOnSaveButton().verifyEventName(objEvent_data.strEditedEventName);
		String eventStartdate2=EventManagement_page1.getEventStartDateAndTime(objEvent_data.strEditedEventName);  
		
		System.out.println("Template edited"+ objEvent_data.strEditedEventName);
		
		System.out.println("Event 2nd start time"  + eventStartdate2 );
		
		
		String strCurrentYear2 = dts.getCurrentDate("yyyy");

		String year2=strCurrentYear2.substring(2);

		String[] date2=eventStartdate2.split(" ");

		System.out.println("current year" + year2);

		System.out.println("current time" + date2[1]);
			
		objLogin1.clickLogOut();
		
		
	objLogin1.loginToApplication(objUserdata_page1.strNewUserName,
			objUserdata.strNewPassword);

	objRegionDefault1.selectFrame();
	
	String editedEvent="Update 1: "+objEvent_data.strEditedEventName;

	Thread.sleep(10000);

	EventManagement_page1
	.verWebNotificationframe()

	.verWebNotificationAndAcknowledge(editedEvent,
			objEvent_data.strEditedEventDescription)

			.clickAcknowledgeAllNotifications();

	EventManagement_page1 .selectFrame();

	String strAckTime2 = EventManagement_page1.getApplicationTime();

	System.out.println("strAckTime2"+ strAckTime2);
	String[] strAck2 =strAckTime2.split(" ");

	objLogin1.clickLogOut();
	
		//admin login	
		
	objLogin1.loginToApplication(login_data.strUserName,
			login_data.strPassword);

	objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);

	objRegionDefault1.selectFrame();


	objNavigationToSubMenus1.navigateToAdminReports();
	String strApplicationTime = EventManagement_page1.getApplicationTime();

	String strCurrentYear = dts.getCurrentDate("yyyy");

	strApplicationTime = strApplicationTime + " " + strCurrentYear;

	String strStartDate = dts.converDateFormat(strApplicationTime,
			"dd MMM HH:mm yyyy", "MM/dd/yyyy");

	String[] splitdate =strStartDate.split("/");

	String Xldate=splitdate[0]+"/"+splitdate[1]+"/"+year2+" "+strAck2[2];
	
	String acktime=dts.AddTimeToExistingTimeHourAndMin(strAck2[2], 0, 1, "HH:mm");
	
	String AckTime=splitdate[0]+"/"+splitdate[1]+"/"+year2+" "+strAck2[2];
	
	String AckTime2=splitdate[0]+"/"+splitdate[1]+"/"+year2+" "+acktime;

	System.out.println("Event started date with time" + Xldate);

	System.out.println("Ackcnowledged date with time" + AckTime2);

	objReport1.verifyAdminReportPage().clickOnNotificationHistory()
	.verifyNotificationHistoryPage()
	.enterNotificationHistoryStartDate(strStartDate)
	.enterNotificationHistoryEndDate(strStartDate)
	.clickOnGenerateReportBtn();
	
		// excel verfication

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;

		objFileFormatConverter.convertXlsxToXls(strDownloadName,
				strDownloadName1);

		assertTrue(new File(strDownloadName1).exists());

		String strValue = objOffCommonFunc.readInfoExcel(
				"Notification History", 1, 1, strDownloadName1);

		String[] strHeaderNames = objReport_data.NotificationHistoryReportHeader;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					2, intCount, strDownloadName1);

			System.out
					.println("Passed Headers " + strHeaderNames[intCount - 1]);

			System.out.println("Captured headers " + strValue);

			assertEquals(strHeaderNames[intCount - 1], strValue);

		}

		String[] strNotificationWEBData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				"", "EVENT","EMResource"+" "+editedEvent
				, objEvent_data.strEditedEventDescription,
				"WEB", Xldate, login_data.strRegionName,
				objEvent_data.strEditedEventName, "","", "N", "Y",AckTime};

		String mailContent ="Event Notice for: "+objUserdata_page1.strFullName+"\n"
				+"Information: "+objEvent_data.strEditedEventDescription+"\n\n"+
				"From: "+login_data.strQSGFullName+"\n\n"+
				"Regions: "+login_data.strRegionName+"\n\n"+
				"Please do not reply to this email message. You must log into EMResource to take any action that may be required.";

		System.out.println("mail content"+ mailContent);

		String[] strNotificationMailData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				objUserdata_page1.strPrimaryMailId, "EVENT",
				"EMResource"+" "+editedEvent, mailContent,
				"EMAIL", Xldate, login_data.strRegionName,
				objEvent_data.strEditedEventName, "","", "N", "N/A","--" };


		String pagerContent="Information: "+objEvent_data.strEditedEventDescription+"\n"+
				"From: "+login_data.strQSGFullName+"\n"+
				"Regions: "+login_data.strRegionName;

		System.out.println("pager content"+ pagerContent);

		String[] strNotificationPagerData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				objUserdata_page1.strPrimaryMailId, "EVENT",
				"EMResource"+" "+editedEvent, pagerContent,
				"PAGER", Xldate, login_data.strRegionName,
				objEvent_data.strEditedEventName, "","", "N", "N/A","--" };

		boolean strPager = false, strMAil = false, strWeb = false;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					2, intCount, strDownloadName1);

			assertEquals(strHeaderNames[intCount - 1], strValue);

		}

		int rowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, "Notification History");

		System.out.println("row count" + rowCount);

		for (int mainCount = 1; intCount <= rowCount; mainCount++) {

		strValue = objOffCommonFunc.readInfoExcel("Notification History",
					                         mainCount, 1, strDownloadName1);

		String strValue1 = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
				                                                       5, strDownloadName1);
            if (objUserdata_page1.strNewUserName.equals(strValue)
					                     && editedEvent.equals(strValue1)) {
            	
			strValue = objOffCommonFunc.readInfoExcel(
						"Notification History", mainCount, 7, strDownloadName1);

switch (strValue){

case "EMAIL": {

				for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
				if (intCount == 6 || intCount == 8) {

				strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
									                           intCount, strDownloadName1);
				System.out.println("NOtificaton Mail Capture  data"+ strValue);

						assertTrue(strValue.contains(strNotificationMailData[intCount - 1]));
						} else {
				strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
									                          intCount, strDownloadName1);

					System.out.println("NOtificaton Capture  Mail data"+ strValue);

					assertEquals(strNotificationMailData[intCount - 1],strValue);
					}}
					strMAil = true;

				     }
					break;

case "PAGER": {

					for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

					if (intCount == 6 || intCount == 8) {

					strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
									                                  intCount, strDownloadName1);
					System.out.println("NOtificaton Pager Capture  data"+ strValue);

					assertTrue(strValue.contains(strNotificationPagerData[intCount - 1]));

					} else {

					strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
									                                intCount, strDownloadName1);
                          System.out.println("NOtificaton Pager  data"+ strValue);
                assertEquals(strNotificationPagerData[intCount - 1],  strValue);
									                       
					}}
					strPager = true;
                     }
					break;
					
		//Disgine change Web content is not displayed in Notification histry report need to Modify			

/*case "WEB": {

					for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
						if (intCount == 15||intCount==8) {

						strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
			                                                          intCount, strDownloadName1);
                                 assertTrue(strNotificationWEBData[intCount - 1].contains(strValue)
		           			                                || strValue.contains(AckTime2));

						} else {

						strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
									                                intCount, strDownloadName1);
						System.out.println("NOtificaton Capture WEB  data"+ strValue);
						
                        assertEquals(strNotificationWEBData[intCount - 1],strValue);
						}}
					strWeb = true;
					}
					break;
*/
default: {

					System.out.println("No Emil,Pager");

				            }}
               }

			if (strMAil && strPager) {

				Thread.sleep(5000);
				objRegionDefault1.switchToDefaultFrame().selectFrame();
				objLogin1.clickLogOut();
				gstrResult = "PASS";
				break;

			}

		}

	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that details about adhoc event update are (editing the details,adding new resources)are displayed appropriately in the 'Notification History' report.  
	 * 'Date : 6-July-2015
	 * 'Author : Sangappa.k
	 ***************************************************************************************************************/

	@Test(description ="Verify that details about adhoc event update are (editing the details,adding new resources)are displayed appropriately in the 'Notification History' report.")
	public void testEdgeCase162318() throws Exception {

		gstrTCID ="162318";
		gstrTO ="Verify that details about adhoc event update are (editing the details,adding new resources)are displayed appropriately in the 'Notification History' report.";

		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login_data login_data = new Login_data();
		User_data objUserdata_page1 = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
	

		Login login_page = new Login(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		UsersList objUsersList_page = new UsersList(driver);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
	

		Report objReport1 = new Report(driver1);
		AutoIT objAutoIT = new AutoIT(driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Date_Time_settings dts= new Date_Time_settings();

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

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];


		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page.selectFrame();
		
		
		objStatusTypeList.navigateToStatusTypeList()

		.createEventStatusType(objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		System.out.println(" RESTyp name"
				+ objResourceType_data.strResourceTypeName);

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

		System.out.println(" RES name" + objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName).selectFirstRole()
				.enterEmail(objUserdata_page1.strPrimaryMailId)
				.enterPrimaryEmailId(objUserdata_page1.strPrimaryMailId)
				.entertextPagerId(objUserdata_page1.strPrimaryMailId)
				.clickSaveButton();

		System.out.println(" new user name" + objUserdata_page1.strNewUserName);

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strAdHocEventTemplate)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOptionChkBox()
				.clickOnEmailNotification(objUserdata_page1.strNewUserName,
						true)
				.clickOnPagerNotification(objUserdata_page1.strNewUserName,
						true)
				.clickOnWebNotification(objUserdata_page1.strNewUserName, true)
				.clickSaveButton();

		String strApplTimeD1 = dts.getFutureDay(1, "M/d/yyyy");

		String[] strDate = strApplTimeD1.split("/");

		EventManagement_page.navigateToEventManagement()

		.verifyEventManagementPage().verifyCreateEventButtonDisplayed()
				.verifyCreateEventButtonsDisplayed()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickEventEndRadioButton().selectEventEndDay(strDate[1])
				.clickOnNextButton().verifySelectResourcesDisplayed();


		EventManagement_page.clickOnNextButton()
				.verifySelectStatusTypesDisplayed();

		EventManagement_page.clickOnNextButton()
				.verifyAdHocEventConfirmationDisplayed().clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName);

		String eventStartdate = EventManagement_page
				.getEventStartDateAndTime(objEvent_data.strEventName);

		System.out.println("Event start date  " + eventStartdate);

		String strCurrentYear1 = dts.getCurrentDate("yyyy");

		String year = strCurrentYear1.substring(2);

		String[] date = eventStartdate.split(" ");

		System.out.println("current year" + year);

		System.out.println("current time" + date[1]);

		System.out.println("Event " + objEvent_data.strEventName);

		login_page.clickLogOut();

		// login as new user
		objLogin1.loginAsNewUser(objUserdata_page1.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		EventManagement_page1
		.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
				objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications();

		EventManagement_page1 .selectFrame();

		String strAckTime = EventManagement_page1.getApplicationTime();

		System.out.println("strAckTime"+ strAckTime);
		String[] strAck =strAckTime.split(" ");

		objLogin1.clickLogOut();
		
		
		objLogin1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		EventManagement_page1.navigateToEventManagement();
		
		EventManagement_page1.clickOnEditLink(objEvent_data.strEventName)
		
		     .enterAdHocEventName(objEvent_data.strEditedEventName)
		    
			.enterAdHocEventDescription(objEvent_data.strEditedEventDescription)
				.clickOnNextButton();

		objResource1.clickResource(strResourceValue);

		EventManagement_page1.clickOnNextButton()
				.verifySelectStatusTypesDisplayed();

		String[] strStatusTypeNames = { objStatuTypes_data.streTSTStatusTypeName };

		EventManagement_page1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);

		objResourceType1.clickStatusType(strstatusTypeValues);

		EventManagement_page1.clickOnNextButton()
				.verifyAdHocEventConfirmationDisplayed().clickOnYesButton()
				.verifyEventName(objEvent_data.strEditedEventName);

		String eventStartdate2=EventManagement_page1.getEventStartDateAndTime(objEvent_data.strEditedEventName);  
		
		System.out.println("Edited event"+ objEvent_data.strEditedEventName);
		
		System.out.println("Event edited time"  + eventStartdate2 );
		
		
		String strCurrentYear2 = dts.getCurrentDate("yyyy");

		String year2=strCurrentYear2.substring(2);

		String[] date2=eventStartdate2.split(" ");

		System.out.println("current year" + year2);

		System.out.println("current time" + date2[1]);
			
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata_page1.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		String editedEvent="Update 1: "+objEvent_data.strEditedEventName;

		Thread.sleep(10000);

		EventManagement_page1
		.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(editedEvent,
				objEvent_data.strEditedEventDescription)

				.clickAcknowledgeAllNotifications();

		EventManagement_page1 .selectFrame();

		String strAckTime2 = EventManagement_page1.getApplicationTime();

		System.out.println("strAckTime2"+ strAckTime2);
		String[] strAck2 =strAckTime2.split(" ");

		objLogin1.clickLogOut();
		
	 //admin login	
			
		objLogin1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault1.selectFrame();


		objNavigationToSubMenus1.navigateToAdminReports();
		String strApplicationTime = EventManagement_page1.getApplicationTime();

		String strCurrentYear = dts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strStartDate = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		String[] splitdate =strStartDate.split("/");

		String Xldate=splitdate[0]+"/"+splitdate[1]+"/"+year2+" "+strAck2[2];
		
		String acktime=dts.AddTimeToExistingTimeHourAndMin(strAck2[2], 0, 1, "HH:mm");
		
		String AckTime=splitdate[0]+"/"+splitdate[1]+"/"+year2+" "+strAck2[2];
		
		String AckTime2=splitdate[0]+"/"+splitdate[1]+"/"+year2+" "+acktime;

		System.out.println("Event started date with time" + Xldate);

		System.out.println("Ackcnowledged date with time" + AckTime2);

		objReport1.verifyAdminReportPage().clickOnNotificationHistory()
		.verifyNotificationHistoryPage()
		.enterNotificationHistoryStartDate(strStartDate)
		.enterNotificationHistoryEndDate(strStartDate)
		.clickOnGenerateReportBtn();
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;

		objFileFormatConverter.convertXlsxToXls(strDownloadName,
				strDownloadName1);

		assertTrue(new File(strDownloadName1).exists());

		String strValue = objOffCommonFunc.readInfoExcel(
				"Notification History", 1, 1, strDownloadName1);

		String[] strHeaderNames = objReport_data.NotificationHistoryReportHeader;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					2, intCount, strDownloadName1);

			assertEquals(strHeaderNames[intCount - 1], strValue);

		}

		String[] strNotificationWEBData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				"", "EVENT",
				editedEvent, objEvent_data.strEditedEventDescription,
				"WEB", Xldate, login_data.strRegionName,
				objEvent_data.strEditedEventName, "","", "N", "Y",AckTime};

		String mailContent ="Event Notice for: "+objUserdata_page1.strFullName+"\n"
				+"Information: "+objEvent_data.strEditedEventDescription+"\n\n"+
				"From: "+login_data.strQSGFullName+"\n\n"+
				"Regions: "+login_data.strRegionName+"\n\n"+
				"Please do not reply to this email message. You must log into EMResource to take any action that may be required.";

		System.out.println("mail content"+ mailContent);

		String[] strNotificationMailData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				objUserdata_page1.strPrimaryMailId, "EVENT",
				"EMResource"+" "+editedEvent, mailContent,
				"EMAIL", Xldate, login_data.strRegionName,
				objEvent_data.strEditedEventName, "","", "N", "N/A","--" };


		String pagerContent="Information: "+objEvent_data.strEditedEventDescription+"\n"+
				"From: "+login_data.strQSGFullName+"\n"+
				"Regions: "+login_data.strRegionName;

		System.out.println("pager content"+ pagerContent);

		String[] strNotificationPagerData = { objUserdata_page1.strNewUserName,
				objUserdata_page1.strFullName,
				objUserdata_page1.strPrimaryMailId, "EVENT",
				"EMResource"+" "+editedEvent, pagerContent,
				"PAGER", Xldate, login_data.strRegionName,
				objEvent_data.strEditedEventName, "","", "N", "N/A","--" };

		boolean strPager = false, strMAil = false, strWeb = false;
		int v = 0;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					2, intCount, strDownloadName1);

			assertEquals(strHeaderNames[intCount - 1], strValue);

		}

		int rowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, "Notification History");

		System.out.println("row count" + rowCount);

		for (int mainCount = 1; mainCount <= rowCount; mainCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					mainCount, 1, strDownloadName1);

			String strValue1 = objOffCommonFunc.readInfoExcel(
					"Notification History", mainCount, 5, strDownloadName1);

			if (objUserdata_page1.strNewUserName.equals(strValue)
					&& editedEvent.equals(strValue1)) {

		System.out.println(strValue1);

				strValue = objOffCommonFunc.readInfoExcel(
						"Notification History", mainCount, 7, strDownloadName1);

  switch (strValue){

		
      case "EMAIL": {

						for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
							
						if (intCount == 6 || intCount == 8) {
                        strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
										                            intCount, strDownloadName1);
						System.out.println("NOtificaton Mail Capture  data"+ strValue);
						
							assertTrue(strValue.contains(strNotificationMailData[intCount - 1])
									            || strNotificationMailData[intCount - 1]
											                    .contains(strValue));
						} 
						else 
						{
						strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
										                               intCount, strDownloadName1);
					   System.out.println("NOtificaton Capture  Mail data"+ strValue);
						assertEquals(strNotificationMailData[intCount - 1],
										strValue);
						}}
						strMAil = true;}
						break;

	case "PAGER": {

						for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

					    if (intCount == 6 || intCount == 8) {
                        strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
										                             intCount, strDownloadName1);
                       
					    System.out.println("NOtificaton Pager Capture  data"+ strValue);

							assertTrue(strValue.contains(strNotificationPagerData[intCount - 1])
				  			                      || strNotificationPagerData[intCount - 1]
											                        .contains(strValue));
                        }
					    else 
                        {

						strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
										                             intCount, strDownloadName1);
						
                        System.out.println("NOtificaton Pager  data"+ strValue);
                        assertEquals(strNotificationPagerData[intCount - 1],strValue);
						}}

						strPager = true;}
						break;
						
		//Disgine change Web content is not displayed in Notification histry report need to Modify		

	/*case "WEB": {

						for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
							
						if (intCount == 15||intCount==8) {

						strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
										                             intCount, strDownloadName1);
							assertTrue(strValue.contains(strNotificationWEBData[intCount - 1])
									                          || strValue.contains(AckTime2)
									                           || strNotificationWEBData[intCount - 1]
											                      .contains(strValue));
                        } else {

						strValue = objOffCommonFunc.readInfoExcel("Notification History", mainCount,
										                           intCount, strDownloadName1);
                        System.out.println("NOtificaton Capture WEB  data"+ strValue);

						assertEquals(strNotificationWEBData[intCount - 1],strValue);
						}}
						strWeb = true;
                        }
						break;
*/
		default: {

				 System.out.println("No Emil,Pager");

				 }}}
			
				  if (strMAil && strPager) {

					Thread.sleep(5000);
					objRegionDefault1.switchToDefaultFrame().selectFrame();
					objLogin1.clickLogOut();
					gstrResult = "PASS";
					break;

				}

			}

		}
}
	








