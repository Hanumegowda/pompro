package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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
import lib.page.AutoIT;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
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

public class EdgeCaseExcelViewsAndEvents  extends TestNG_UI_EXTENSIONS {

	public EdgeCaseExcelViewsAndEvents() throws Exception {
		super();
	}
	
	/***********************************************************************************************
	 * 'Description : Verify that user without ‘Report-Snapshot’ cannot generate 'excel' snapshot of 
	 *                view screens. 
	 * 'Date		: 14-Nov-2014 
	 * 'Author 		: sangappa.k
	 ************************************************************************************************/

	@Test(description = " Verify that user without ‘Report-Snapshot’ cannot generate 'excel' snapshot"
			+ " of view screens")
	public void testEdgeCase148765() throws Exception {

		gstrTCID = "148765";
		gstrTO = "Verify that user without ‘Report-Snapshot’ cannot generate 'excel' snapshot of view screens";

		Login login_page1 = new Login(this.driver1);// pre con fire driver
		Login login_page2 = new Login(this.driver1);// new user ie driver1
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		RegionDefault objRegionDefault_page2 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		SelectRegion objSelectRegion_page2 = new SelectRegion(this.driver1);
		UsersList objUsersList_page1 = new UsersList(driver);
		UsersList objUsersList_page2 = new UsersList(driver1);

		// data Objects
		User_data objUserdata_page1 = new User_data();
		Login_data login_data = new Login_data();
		  
		// login to App
		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1
				.selectRegionAndNavigate(login_data.strRegionName1);

		objRegionDefault_page1.selectFrame();

		objUsersList_page1
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption().clickSaveButton();

		login_page1.clickLogOut();
		
		System.out.println(objUserdata_page1.strNewUserName);
		// login with new user

		login_page2.loginAsNewUser(objUserdata_page1.strNewUserName,
				objUserdata_page1.strNewPassword);

		objRegionDefault_page2.selectFrame().clickExcelOption()
				.verSnapshotWindowDisplayed();
		
		login_page2.clickLogOut();

		// login as system admin

		login_page2.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objRegionDefault_page2.selectFrame();

		objSelectRegion_page2
				.selectRegionAndNavigate(login_data.strRegionName1);

		objRegionDefault_page2.selectFrame();

		objUsersList_page2
				.navigateToUsers()
				.enterUsernameInSearchInputField(
						objUserdata_page1.strNewUserName).clickSearchButton()
				.editUserDetails(objUserdata_page1.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption() 
				.clickSaveButton();
		login_page2.clickLogOut();

		login_page2.loginToApplication(objUserdata_page1.strNewUserName,
				objUserdata_page1.strNewPassword);

		objRegionDefault_page2.selectFrame();

		objRegionDefault_page2.clickExcelOption();
		
		objRegionDefault_page2.verSnapshotWindowNotDisplayed();

		login_page2.clickLogOut();

	}
	
	/***********************************************************************************************
	 * 'Description : Verify that appropriate validation message is displayed when attempted to generate
	                   excel snapshot providing future time.
	 * 'Date		: 14-Nov-2014 
	 * 'Author 		: sangappa.k
	 ************************************************************************************************/
	@Test(description = "Verify that appropriate validation message is displayed when attempted to generate"
			+ "excel snapshot providing future time")
	public void testEdgeCase146590() throws Exception {

		gstrTCID = "146590";
		gstrTO = "Verify that appropriate validation message is displayed when attempted to generate"
				+ "excel snapshot providing future time";
		// login page
		Login_data login_data = new Login_data();
		Login login_page1 = new Login(this.driver1);// pre con fire driver
		Login login_page2 = new Login(this.driver1);// new user ie driver1

		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		RegionDefault objRegionDefault_page2 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);

		UsersList objUsersList_page1 = new UsersList(driver);

		EventManagement objEventManagement_page2 = new EventManagement(
				this.driver1);

		// data Objects
		User_data objUserdata_page1 = new User_data();
		Date_Time_settings objDateTimesetting_page1 = new Date_Time_settings();

		// login to App & navigate to users pre condtion fire

		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName1);

		objRegionDefault_page1.selectFrame();

		// users

		objUsersList_page1
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata_page1.strNewUserName2,
				objUserdata_page1.strNewPassword,
				objUserdata_page1.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption().clickSaveButton();

		login_page1.clickLogOut();

		// login same user post condtion
		login_page2.loginAsNewUser(objUserdata_page1.strNewUserName2,
				objUserdata_page1.strNewPassword);

		objRegionDefault_page2.selectFrame();

		String strApplicationTime1 = objEventManagement_page2
				.getApplicationTime();

		String strCurrentYear = objDateTimesetting_page1.getCurrentDate("yyyy");

		strApplicationTime1 = strApplicationTime1 + " " + strCurrentYear;

		strApplicationTime1 = objDateTimesetting_page1.converDateFormat(
				strApplicationTime1, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime1 = objDateTimesetting_page1.AddDaytoExistingDate(
				strApplicationTime1, 2, "MM/dd/yyyy HH:mm");

		String[] strdate = strApplicationTime1.split(" ");

		String[] strhour = strdate[1].split(":");

		objRegionDefault_page2.clickExcelOption();

		// inserting date & time& minute
		objRegionDefault_page2.selectAndEnterDateAndTime(strdate[0],
				strhour[0], strhour[1]);

		// switch to Error page

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		// ver for error page
		objRegionDefault_page2.verSnapShotWindowErrorPage()
		
		.clickOnCloseSnapShotWindowError();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault_page2.selectFrame();

		login_page2.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : 	Verify that user can generate excel snapshot of ‘Region views’ of type 'Summary Plus' providing past and current time. 
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that user can generate excel snapshot of ‘Region views’ of type 'Summary Plus' providing past and current time.")
	public void testEdgecase146595() throws Exception {
		gstrTCID = "146595";
		gstrTO = "Verify that user can generate excel snapshot of ‘Region views’ of type 'Summary Plus' providing past and current time. ";

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
		
		
		String strDownloadName2 = file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		
		String strCSVFileNameRenamed2 =  "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath2 =  file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName3 = file + "\\" 
		        + "TC1"+ gstrTCID
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
		
		objViewsList.clickCreateNewViewButton()
		.enterViewName(objView_data.strViewName)
		.enterViewDesc(objView_data.strViewDesc)
		.selectViewType(objView_data.strSummaryPlus);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
		
			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();
	
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objView_data.strViewName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnViewMenu();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

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

		String strApplicationTime = objEventManagement1.getApplicationTime();
		    
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		Thread.sleep(120000);
		
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
	    
		String strApplicationTime1 = objEventManagement1.getApplicationTime();
	    
	    
		strApplicationTime1 = strApplicationTime1+" "+strCurrentYear;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		
		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1,  "MM/dd/yyyy HH:mm","yyyy-MM-dd HH:mm");
		
		String strViewHeader = strApplicationTime1+" "+objView_data.strViewName+" View Snapshot";
		
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
		
//		String strViewHeader = "Region "+objView_data.strViewName+" snapshot";
		

		
		String strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName1);
		
		System.out.println(strViewHeader);
		System.out.println(strValue);
		assertEquals(strViewHeader, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName1);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName1);
		assertEquals(objResource_data.strResourceName, strValue);
				
		
		String[] strUpdatedValues1 = { objView_data.strDateUpdateFutureValue,
				objStatusTypes_data.strStatusNameInMulti1,
				objView_data.strNEDOCValue1,
				objView_data.strValueForUpdate1,
				objView_data.strUpdatedValForSST1,
				objView_data.strValueForTST1};
		
		for( intCount = 2; intCount<=(strStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName1);
			assertEquals(strStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName1);
			assertEquals(strUpdatedValues1[intCount-2], strValue);
		}

		
	    Thread.sleep(5000);
	    
		RegionDefault_page1.clickExcelOption();
		
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		
		String strDate = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,  "MM/dd/yyyy HH:mm","mm");
		
		System.out.println(strDate);
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		Thread.sleep(2000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2, strAutoITName);
		intCount = 0;
		intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed2);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath2)
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
		
		
//		strViewHeader = "Region "+objView_data.strViewName+" snapshot";
		strApplicationTime = objDts.converDateFormat(strApplicationTime,  "MM/dd/yyyy HH:mm","yyyy-MM-dd HH:mm");
		
		strViewHeader = strApplicationTime+" "+objView_data.strViewName+" View Snapshot";
		
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName3);
		System.out.println(strViewHeader);
		System.out.println(strValue);
		assertEquals(strViewHeader, strValue);

		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName3);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName3);
		assertEquals(objResource_data.strResourceName, strValue);
		
		String[] strUpdatedValues = { objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST};
		
		for( intCount = 2; intCount<=(strStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName3);
			assertEquals(strStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName3);
			assertEquals(strUpdatedValues[intCount-2], strValue);
		}

		gstrResult = "PASS";
	}

	

	/***************************************************************************************************************
	 * 'Description :Verify that user can generate excel snapshot of ‘Region views’ of type 'Summary' providing past and current time.
	 * 'Date        : 28-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that user can generate excel snapshot of ‘Region views’ of type 'Summary' providing past and current time.")
	public void testEdgecase146594() throws Exception {
		gstrTCID = "146594";
		gstrTO = "Verify that user can generate excel snapshot of ‘Region views’ of type 'Summary' providing past and current time.";

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
		
		
		String strDownloadName2 = file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		
		String strCSVFileNameRenamed2 =  "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath2 =  file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName3 = file + "\\" 
		        + "TC1"+ gstrTCID
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
		
		objViewsList.clickCreateNewViewButton()
		.enterViewName(objView_data.strViewName)
		.enterViewDesc(objView_data.strViewDesc)
		.selectViewType(objView_data.strSummary);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
		
			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();
	
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objView_data.strViewName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnViewMenu();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

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

		String strApplicationTime = objEventManagement1.getApplicationTime();
		    
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		
		Thread.sleep(120000);
		
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
	    
		String strApplicationTime1 = objEventManagement1.getApplicationTime();
			    
		strApplicationTime1 = strApplicationTime1+" "+strCurrentYear;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1, "dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		
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
		
//		String strViewHeader = "Region "+objView_data.strViewName+" snapshot";
		String strViewHeader = strApplicationTime1+" "+objView_data.strViewName+" View Snapshot";
		
		String strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName1);
		System.out.println(strViewHeader);
		System.out.println(strValue);
		assertEquals(strViewHeader, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName1);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName1);
		assertEquals(objResource_data.strResourceName, strValue);
				
		
		String[] strUpdatedValues1 = { objView_data.strDateUpdateFutureValue,
				objStatusTypes_data.strStatusNameInMulti1,
				objView_data.strNEDOCValue1,
				objView_data.strValueForUpdate1,
				objView_data.strUpdatedValForSST1,
				objView_data.strValueForTST1};
		
		for( intCount = 2; intCount<=(strStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName1);
			assertEquals(strStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName1);
			assertEquals(strUpdatedValues1[intCount-2], strValue);
		}

		
	    Thread.sleep(5000);
	    
		RegionDefault_page1.clickExcelOption();
		
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		
		String strDate = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,  "MM/dd/yyyy HH:mm","mm");
		
		strApplicationTime = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");
		
		System.out.println(strDate);
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		Thread.sleep(2000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2, strAutoITName);
		intCount = 0;
		intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed2);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath2)
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
		
		
//		strViewHeader = "Region "+objView_data.strViewName+" snapshot";
		strViewHeader = strApplicationTime+" "+objView_data.strViewName+" View Snapshot";
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName3);

		System.out.println(strViewHeader);
		System.out.println(strValue);
		assertEquals(strViewHeader, strValue);
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName3);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName3);
		assertEquals(objResource_data.strResourceName, strValue);
		
		String[] strUpdatedValues = { objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST};
		
		for( intCount = 2; intCount<=(strStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName3);
			assertEquals(strStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName3);
			assertEquals(strUpdatedValues[intCount-2], strValue);
		}

		gstrResult = "PASS";
	}

	

	/***************************************************************************************************************
	 * 'Description : 	Verify that user can generate excel snapshot of ‘Region views’ of type 'Resource' providing past and current time. 
	 * 'Date        : 1-Dec-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = " 	Verify that user can generate excel snapshot of ‘Region views’ of type 'Resource' providing past and current time. ")
	public void testEdgecase146596() throws Exception {
		gstrTCID = "146596";
		gstrTO = "Verify that user can generate excel snapshot of ‘Region views’ of type 'Summary' providing past and current time.";

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
		
		
		String strDownloadName2 = file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		
		String strCSVFileNameRenamed2 =  "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath2 =  file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName3 = file + "\\" 
		        + "TC1"+ gstrTCID
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
		
		objViewsList.clickCreateNewViewButton()
		.enterViewName(objView_data.strViewName)
		.enterViewDesc(objView_data.strViewDesc)
		.selectViewType(objView_data.strResource);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
		
			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();
	
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objView_data.strViewName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnViewMenu();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypesInRows(
					objResource_data.strResourceName,
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

		String strApplicationTime = objEventManagement1.getApplicationTime();
		    
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		Thread.sleep(120000);
		
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
	    
		String strApplicationTime1 = objEventManagement1.getApplicationTime();
	   
			    
		strApplicationTime1 = strApplicationTime1+" "+strCurrentYear;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1, "dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		
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
		
//		String strViewHeader = "Region "+objView_data.strViewName+" snapshot";

		String strViewHeader = strApplicationTime1+" "+objView_data.strViewName+" View Snapshot";
		
		String strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName1);
		System.out.println(strViewHeader);
		System.out.println(strValue);
		assertEquals(strViewHeader, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName1);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName1);
		assertEquals(objResource_data.strResourceName, strValue);
				
		
		String[] strUpdatedValues1 = { objView_data.strDateUpdateFutureValue,
				objStatusTypes_data.strStatusNameInMulti1,
				objView_data.strNEDOCValue1,
				objView_data.strValueForUpdate1,
				objView_data.strUpdatedValForSST1,
				objView_data.strValueForTST1};
		
		for( intCount = 3; intCount<=(strStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, intCount, 2,  strDownloadName1);
			assertEquals(strStatusTypeNames[intCount-3], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName,intCount, 3, strDownloadName1);
			assertEquals(strUpdatedValues1[intCount-3], strValue);
		}

		
	    Thread.sleep(5000);
	    
		RegionDefault_page1.clickExcelOption();
		
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		
		String strDate = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,  "MM/dd/yyyy HH:mm","mm");
		
		System.out.println(strDate);
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		Thread.sleep(2000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2, strAutoITName);
		intCount = 0;
		intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed2);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath2)
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
		
		strApplicationTime = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");
//		strViewHeader = "Region "+objView_data.strViewName+" snapshot";
		strViewHeader = strApplicationTime+" "+objView_data.strViewName+" View Snapshot";
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName3);
		System.out.println(strViewHeader);
		System.out.println(strValue);
		assertEquals(strViewHeader, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName3);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName3);
		assertEquals(objResource_data.strResourceName, strValue);
		
		String[] strUpdatedValues = { objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST};
		
		for( intCount = 3; intCount<=(strStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName,  intCount,2, strDownloadName3);
			assertEquals(strStatusTypeNames[intCount-3], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName,  intCount,3, strDownloadName3);
			assertEquals(strUpdatedValues[intCount-3], strValue);
		}

		gstrResult = "PASS";
	}



	/***************************************************************************************************************
	 * 'Description :Verify that user can generate excel snapshot of ‘Region views’ of type 'Hybrid' providing past and current time..
	 * 'Date        : 28-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that user can generate excel snapshot of ‘Region views’ of type 'Hybrid' providing past and current time.")
	public void testEdgecase146597() throws Exception {
		gstrTCID = "146597";
		gstrTO = "Verify that user can generate excel snapshot of ‘Region views’ of type 'Hybrid' providing past and current time.";

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
		
		
		String strDownloadName2 = file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		
		String strCSVFileNameRenamed2 =  "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath2 =  file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName3 = file + "\\" 
		        + "TC1"+ gstrTCID
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
		
		objViewsList.clickCreateNewViewButton()
		.enterViewName(objView_data.strViewName)
		.enterViewDesc(objView_data.strViewDesc)
		.selectViewType(objView_data.strHybrid);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
		
			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();
	
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objView_data.strViewName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnViewMenu();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

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

		String strApplicationTime = objEventManagement1.getApplicationTime();
		    
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		
		Thread.sleep(120000);
		
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
	    
		String strApplicationTime1 = objEventManagement1.getApplicationTime();
		  
	    
		strApplicationTime1 = strApplicationTime1+" "+strCurrentYear;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		
//		String strViewHeader = "Region "+objView_data.strViewName+" snapshot";
		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1,  "MM/dd/yyyy HH:mm","yyyy-MM-dd HH:mm");
		
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
		

		String strViewHeader = strApplicationTime1+" "+objView_data.strViewName+" View Snapshot";
		
		String strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName1);
	
		System.out.println(strViewHeader);
		System.out.println(strValue);
		assertEquals(strViewHeader, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName1);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName1);
		assertEquals(objResource_data.strResourceName, strValue);
				
		
		String[] strUpdatedValues1 = { objView_data.strDateUpdateFutureValue,
				objStatusTypes_data.strStatusNameInMulti1,
				objView_data.strNEDOCValue1,
				objView_data.strValueForUpdate1,
				objView_data.strUpdatedValForSST1,
				objView_data.strValueForTST1};
		
		for( intCount = 2; intCount<=(strStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName1);
			assertEquals(strStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName1);
			assertEquals(strUpdatedValues1[intCount-2], strValue);
		}

		
	    Thread.sleep(5000);
	    
		RegionDefault_page1.clickExcelOption();
		
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		
		String strDate = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,  "MM/dd/yyyy HH:mm","mm");
		
		System.out.println(strDate);
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		Thread.sleep(2000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2, strAutoITName);
		intCount = 0;
		intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed2);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath2)
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
		
		
//		strViewHeader = "Region "+objView_data.strViewName+" snapshot";
		strApplicationTime = objDts.converDateFormat(strApplicationTime,  "MM/dd/yyyy HH:mm","yyyy-MM-dd HH:mm");
		
		strViewHeader = strApplicationTime+" "+objView_data.strViewName+" View Snapshot";
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName3);
		System.out.println(strViewHeader);
		System.out.println(strValue);
		
		assertEquals(strViewHeader, strValue);

		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName3);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName3);
		assertEquals(objResource_data.strResourceName, strValue);
		
		String[] strUpdatedValues = { objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST};
		
		for( intCount = 2; intCount<=(strStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName3);
			assertEquals(strStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName3);
			assertEquals(strUpdatedValues[intCount-2], strValue);
		}

		gstrResult = "PASS";
	}

	/***************************************************************************************************************
	 * 'Description :Verify that user without ‘Report-Event Snapshot’ cannot generate 'excel' snapshot of event status screen. 
	 * 'Date        : 14-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that user without ‘Report-Event Snapshot’ cannot generate 'excel' snapshot of event status screen. ")
	public void testEdgeCase146305() throws Exception {
		gstrTCID = "146305";
		gstrTO = "Verify that user without ‘Report-Event Snapshot’ cannot generate 'excel' snapshot of event status screen. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();

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
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

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

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

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

				.selectReportStatusSnapshotOption()

				.clickSaveButton()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()
				
				.selectMaintainEventsOption()
				
				.selectMaintainAdHocEventsOption()

				.clickSaveButton();

		
		objLogin.clickLogOut();

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
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName};
		
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

		UpdateStatus_page1.clickOnSaveButton();

		RegionDefault_page1.clickExcelOption();

		RegionDefault_page1.verSnapshotWindowNotDisplayed();
		
		gstrResult = "PASS";
	}
		
	/*************************************************************************************
	'Description 	:Verify that 'excel' option is not available on 'Custom View-Map' screen
	'Precondition	: None
	'Date		 	: 03-Dec-2014 
	'Author 		: Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that 'excel' option is not available on 'Custom View-Map' screen")
	public void testEdgeCase146896() throws Exception {

		gstrTCID = "146896";
		gstrTO = "Verify that 'excel' option is not available on 'Custom View-Map' screen";

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Roles_data objRolesData = new Roles_data();
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objViewData = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView ObjCustomUnderView1 = new CustomUnderView(this.driver1);
		
		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objViewData.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// create status types

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Create Resource Type
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

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption);

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objEventManagement1.selectFrame();

		// Custom View
		Thread.sleep(3000);
		objNavigationToSubMenus1.navigateToCustomInView();
		String[] strResource1Val = { strResourceValue[0] };
		ObjCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResource1Val)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strstatusTypeValues)
				.clickOnSave();
		ObjCustomUnderView1.clickOnCustomeViewMap();
		objRegionDefault1.verifyExcelOptionNotDisplayed();
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";

	}
	
	/***************************************************************************************************************
	 * 'Description : 	Verify that user can generate excel snapshot of ‘Custom View -Table’ providing past and current time. 
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that user can generate excel snapshot of ‘Custom View -Table’ providing past and current time. ")
	public void testEdgeCase146897() throws Exception {
		gstrTCID = "146897";
		gstrTO = "Verify that user can generate excel snapshot of ‘Custom View -Table’ providing past and current time. ";

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
		
		
		String strDownloadName2 = file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		
		String strCSVFileNameRenamed2 =  "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath2 =  file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName3 = file + "\\" 
		        + "TC1"+ gstrTCID
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
		CustomUnderView ObjCustomUnderView1 = new CustomUnderView(this.driver1);
		
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

		.selectConfigureRegionViewsOption()
		
		.selectViewcustomViewOption()
				
		.clickSaveButton();
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		// Custom View
		Thread.sleep(8000);
		objnNavigationToSubMenus1.navigateToCustomInView();
		String[] strResource1Val = { strResourceValue[0] };
		ObjCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResource1Val)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strstatusTypeValues)
				.clickOnSave();
		
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

		String strApplicationTime4 = objEventManagement1.getApplicationTimeWithCSTCDT();
		
		String strApplicationTime = objEventManagement1.getApplicationTime();
		    
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		Thread.sleep(120000);
		
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
	    

		String strApplicationTime3 = objEventManagement1.getApplicationTimeWithCSTCDT();
		
		RegionDefault_page1.clickExcelOption();
		
		Thread.sleep(2000);
		RegionDefault_page1.clickOnGenerateReportOption();
		Thread.sleep(2000);
		
		strApplicationTime = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd hhmm");
		
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
		
		strApplicationTime = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HHmm");
		
		String strApplicationTime1 = objEventManagement1.getApplicationTime();
	    			    
		strApplicationTime1 = strApplicationTime1+" "+strCurrentYear;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1, "dd MMM HH:mm yyyy","yyyy-MM-dd HH:mm");
		
		String strViewHeader = strApplicationTime1+" Custom View Snapshot";
		
			String strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName1);
		
//		assertTrue(strViewHeader.equals(strValue));
			System.out.println(strValue);
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName1);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName1);
		assertEquals(objResource_data.strResourceName, strValue);
				

		String[] strUpdatedStatusTypeNames = { objResourceType_data.strResourceTypeName, 
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, 
				objTest_data.strComment, objTest_data.strLastUpdate, objTest_data.strUpdatedBy};
		
		
		String[] strUpdatedValues1 = {objResource_data.strResourceName,
				objView_data.strDateUpdateFutureValue,
				objStatusTypes_data.strStatusNameInMulti1,
				objView_data.strNEDOCValue1,
				objView_data.strValueForUpdate1,
				objView_data.strUpdatedValForSST1,
				objView_data.strValueForTST1,
				"",strApplicationTime3, objUserdata.strFullName};
		
		String[] strSummaryValue = { objTest_data.strSummary, objView_data.strZeroValue,
				objView_data.strZeroValue,objView_data.strNEDOCValue1,
				objView_data.strValueForUpdate1,objView_data.strUpdatedValForSST1,
				objView_data.strZeroValue,"", "", ""};
		
		for( intCount = 1; intCount<=strUpdatedStatusTypeNames.length; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName1);
			assertEquals(strUpdatedStatusTypeNames[intCount-1], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName1);
			assertEquals(strUpdatedValues1[intCount-1], strValue);
						
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 4, intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount-1], strValue);
		}

		String[] strSummaryStatusTypeNames = {objView_data.strStatusTypeSummary,  objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName};
		
		String[] strSummaryStatusTypeUpdatedValues = {objView_data.strTotal, objView_data.strNEDOCValue1,
				objView_data.strValueForUpdate1,objView_data.strUpdatedValForSST1};
		
		strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable, 1, 1, strDownloadName1);
		
		for( intCount = 2; intCount<=(strSummaryStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount,1, strDownloadName1);
			assertEquals(strSummaryStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount,2, strDownloadName1);
			assertEquals(strSummaryStatusTypeUpdatedValues[intCount-2], strValue);
		}	
		
	    Thread.sleep(5000);
	    
		RegionDefault_page1.clickExcelOption();
		
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, 1, "yyyy-MM-dd HHmm");
		
		String strDate = objDts.converDateFormat(strApplicationTime, "yyyy-MM-dd HHmm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,"yyyy-MM-dd HHmm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,  "yyyy-MM-dd HHmm","mm");
		strApplicationTime = objDts.converDateFormat(strApplicationTime,  "yyyy-MM-dd HHmm","yyyy-MM-dd HH:mm");
		System.out.println(strDate);
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		Thread.sleep(2000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2, strAutoITName);
		intCount = 0;
		intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed2);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath2)
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
		
		
		strViewHeader = strApplicationTime+" Custom View Snapshot";
		
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName3);
//		assertEquals(strViewHeader, strValue);
		System.out.println(strValue);
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName3);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName3);
		assertEquals(objResource_data.strResourceName, strValue);
		
		String[] strUpdatedValues2 = {objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST,
				"",strApplicationTime4, objUserdata.strFullName};
		
		String[] strSummaryValue1 = { objTest_data.strSummary, objView_data.strZeroValue,
				objView_data.strZeroValue,objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,objView_data.strUpdatedValForSST,
				objView_data.strZeroValue,"", "", ""};
		
		for( intCount = 1; intCount<=strUpdatedStatusTypeNames.length; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName3);
			assertEquals(strUpdatedStatusTypeNames[intCount-1], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName3);
			assertEquals(strUpdatedValues2[intCount-1], strValue);
						
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 4, intCount, strDownloadName3);
			assertEquals(strSummaryValue1[intCount-1], strValue);
		}

		String[] strSummaryStatusTypeNames1 = {objView_data.strStatusTypeSummary,  objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,};
		
		String[] strSummaryStatusTypeUpdatedValues1 = {objView_data.strTotal, objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,objView_data.strUpdatedValForSST};
		
		for( intCount = 2; intCount<=(strSummaryStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount,1, strDownloadName3);
			assertEquals(strSummaryStatusTypeNames1[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objView_data.strSummaryTable,  intCount,2, strDownloadName3);
			assertEquals(strSummaryStatusTypeUpdatedValues1[intCount-2], strValue);
		}	
	
		gstrResult = "PASS";
	}


	/***************************************************************************************************************
	 * 'Description :Verify that ‘ N/A’ is displayed in excel snapshot for status types which are refined for a user. 
	 * 'Date        : 05-Dec-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that ‘ N/A’ is displayed in excel snapshot for status types which are refined for a user. ")
	public void testEdgeCase146601() throws Exception {
		gstrTCID = "146601";
		gstrTO = "Verify that ‘ N/A’ is displayed in excel snapshot for status types which are refined for a user. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		
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
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[1];
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
		
//		objUserdata.strNewUserName = "Auto1418017787292";
//		 
//		objLogin1.loginToApplication(objTest_data.strUserName,
//				objTest_data.strPassword);
//
//		objRegionDefault1.selectFrame();
//		
//		objSelectRegion1
//				.selectRegionAndNavigate(objTest_data.strRegionName);
//
//		objRegionDefault1.selectFrame();
//
//		UsersList_page1
//		.navigateToUsers();
//		
//		UsersList_page1.searchUserName(objUserdata.strNewUserName,
//				objUserdata.strRole, objUserdata.strResourceType,
//				objUserdata.strUsername, objUserdata.strsearchOption);
//		
//		UsersList_page1.editUserDetails(objUserdata.strNewUserName);	
	
//		UsersList_page1.clickRefineLinkOfViewResource(objResource_data.strResourceName);

		
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
				
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

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
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
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
		
//		objEventStatus1.verResourceTypeAndResourceName(
//				objResourceType_data.strResourceTypeName,
//				objResource_data.strResourceName);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//			objEventStatus1.verStatusTypes(
//					objResourceType_data.strResourceTypeName,
//					strStatusTypeNames[i]);
//		}

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

		String strApplicationTime = objEventManagement1.getApplicationTime();
		    
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;
			    
		strApplicationTime = objDts.converDateFormat(strApplicationTime, "yyyy-MM-dd HHmm", "MM/dd/yyyy HH:mm");
			  
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		UsersList_page1
		.navigateToUsers();
		
		UsersList_page1.searchUserName(objUserdata.strNewUserName,
				objUserdata.strRole, objUserdata.strResourceType,
				objUserdata.strUsername, objUserdata.strsearchOption);
		
		UsersList_page1.editUserDetails(objUserdata.strNewUserName);	
	
		UsersList_page1.clickRefineLinkOfViewResource(objResource_data.strResourceName);
		
		String[] strstatusTypeValue = {strstatusTypeValues[1], strstatusTypeValues[2]};

		UsersList_page1.selectFrameOfRefineVisibleStatusTypes();
		
		Thread.sleep(3000);
		
		UsersList_page1.deselectStatusTypesInRefine(strstatusTypeValue)
				     .clickSaveChangesButtonInRefine().selectFrame()
				     .clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnViewMenu();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		String strApplicationTime1 = objEventManagement1.getApplicationTime();
		strApplicationTime1 = strApplicationTime1+" "+strCurrentYear;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1, "dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println(strApplicationTime1);
		
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
		
		String strHeader = strApplicationTime1+" "+objView_data.strViewName+" View Snapshot";
		
		String strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName1);
		assertEquals(strHeader, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName1);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName1);
		assertEquals(objResource_data.strResourceName, strValue);
		

		String[] strStatusTypeNames1 = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName};
		
		String[] strUpdatedValues = { objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST};
		
		for( intCount = 2; intCount<=(strStatusTypeNames1.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName1);
			assertEquals(strStatusTypeNames1[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName1);
			assertEquals(strUpdatedValues[intCount-2], strValue);
		}
		gstrResult = "PASS";
	}

	

	/***************************************************************************************************************
	 * 'Description : Verify that reactivated status type are displayed in the excel snapshot generated when snapshot time provided is after the status type reactivation 
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that reactivated status type are displayed in the excel snapshot generated when snapshot time provided is after the status type reactivation ")
	public void testEdgeCase146600() throws Exception {
		gstrTCID = "146600";
		gstrTO = "Verify that reactivated status type are displayed in the excel snapshot generated when snapshot time provided is after the status type reactivation ";

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

		String strDownloadName2 = file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		String strCSVFileNameRenamed2 =  "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath2 =  file + "\\" 
		        + "TC1"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName3 = file + "\\" 
		        + "TC1"+ gstrTCID
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
		String strstatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
	
		Login objLogin1 = new Login(this.driver1);
		
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
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

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		
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
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
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
		
//		objEventStatus1.verResourceTypeAndResourceName(
//				objResourceType_data.strResourceTypeName,
//				objResource_data.strResourceName);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//			objEventStatus1.verStatusTypes(
//					objResourceType_data.strResourceTypeName,
//					strStatusTypeNames[i]);
//		}

		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		UpdateStatus_page1.clickOnSelectAll();
				
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate);
	     
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[1], objView_data.strValueForTST);
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strDateUpdateValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();
		
	    objLogin1.clickLogOut();
	    
	    Thread.sleep(3000);
	    
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);
		
		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.clickOnEditOfStatusType(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.deselectActiveCheckBox();
		
		objStatusTypeList.clickOnSaveButton();
		
		String strApplicationTime = objEventManagement.getApplicationTime();
		
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;
			    
//		strApplicationTime = objDts.converDateFormat(strApplicationTime, "yyyy-MM-dd HHmm", "MM/dd/yyyy HH:mm");
			        
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, 1, "dd MMM HH:mm yyyy");
		
		Thread.sleep(120000);
	
		objStatusTypeList.selectInactiveStatusTypesCheckBox();
		
		objStatusTypeList.clickOnEditOfStatusType(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.selectActiveCheckBox();
		
		objStatusTypeList.clickOnSaveButton();

	    objLogin.clickLogOut();
	    
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnViewMenu();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		UpdateStatus_page1.clickOnSelectAll();
				
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate1);
	     
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[1], objView_data.strValueForTST);
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strDateUpdateValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();
	    
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
		
		
		String strApplicationTime2 = objEventManagement1.getApplicationTime();
			    
		strApplicationTime2 = strApplicationTime2+" "+strCurrentYear;
		
		strApplicationTime2 = dts.converDateFormat(strApplicationTime2, "dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		 
		String strHeader = strApplicationTime2+" "+objView_data.strViewName+" View Snapshot";
	
		String strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName1);
		System.out.println(strHeader);
		System.out.println(strValue);
		assertEquals(strHeader, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName1);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName1);
		assertEquals(objResource_data.strResourceName, strValue);
		
		String[] strUpdatedValues = { objView_data.strDateUpdateValue,
				objView_data.strValueForUpdate1,
				objView_data.strValueForTST};
		
		for( intCount = 2; intCount<=(strStatusTypeNames.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName1);
			assertEquals(strStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName1);
			assertEquals(strUpdatedValues[intCount-2], strValue);
		}
		
		
		RegionDefault_page1.clickExcelOption();
		
		String strDate = objDts.converDateFormat(strApplicationTime,"dd MMM HH:mm yyyy", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,"dd MMM HH:mm yyyy", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,  "dd MMM HH:mm yyyy","mm");
		
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour, strMinutes);

		Thread.sleep(2000);

		Thread.sleep(2000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2, strAutoITName);
		intCount = 0;
		intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed2);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath2)
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
		
		strValue  = "";
		strApplicationTime = dts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		
		String strHeader1 = strApplicationTime+" "+objView_data.strViewName+" View Snapshot";
	
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName3);
		System.out.println(strHeader1);
		System.out.println(strValue);
		assertEquals(strHeader1, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName3);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName3);
		assertEquals(objResource_data.strResourceName, strValue);
		
		String[] strUpdatedValues1 = { objView_data.strDateUpdateValue,objView_data.strHyphen,
				objView_data.strValueForTST};
		String[] strStatusTypeName1 = {objStatusTypes_data.strDateStatusTypeName, objStatusTypes_data.strTSTStatusTypeName };
		
		for( intCount = 2; intCount<=(strStatusTypeName1.length)+1; intCount++){
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, intCount, strDownloadName3);
			assertEquals(strStatusTypeNames[intCount-2], strValue);
			
			strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, intCount, strDownloadName3);
			assertEquals(strUpdatedValues1[intCount-2], strValue);
		}

		gstrResult = "PASS";
	}


	/***************************************************************************************************************
	 * 'Description : Verify that appropriate validation message is displayed when attempted to generate excel snapshot of past time (before creation of view / event). 
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/
	
	@Test(description = "Verify that appropriate validation message is displayed when attempted to generate excel snapshot of past time (before creation of view / event). ")
	public void testEdgeCase146591() throws Exception {
		gstrTCID = "146591";
		gstrTO = "Verify that appropriate validation message is displayed when attempted to generate excel snapshot of past time (before creation of view / event). ";
	
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
		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
	
		Login objLogin1 = new Login(this.driver1);
		
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		
		ViewsList objViewsList1 = new ViewsList(this.driver1);
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
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		File file = new File(System.getProperty("user.dir") + fileDownloadPath) ;
		
		File autoItFiles = new File(System.getProperty("user.dir")+autoItFilesPath);
		String filePath = file+"\\";
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
		
		System.out.println("-----Precondtion execution starts------");
		
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
	
		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
	
		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
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
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);
	
		String[] strStatusTypeNames = {objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//		
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//	
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strStatusTypeNames);
		
		String strApplicationTime = objEventManagement.getApplicationTime();
		
		String  strCurrentYear = objDts.getCurrentDate("yyyy");
			    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;
			    
	
			        
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(strApplicationTime, 0, -1, "dd MMM HH:mm yyyy");
		
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
				
		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate);
	     
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[1], objView_data.strValueForTST);
	       
	    UpdateStatus_page1.clickOnSaveButton();
		
		RegionDefault_page1.clickExcelOption();
		
		String strDate = objDts.converDateFormat(strApplicationTime,"dd MMM HH:mm yyyy", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,"dd MMM HH:mm yyyy", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,  "dd MMM HH:mm yyyy","mm");
		
		
		strApplicationTime = objDts.converDateFormat(strApplicationTime,  "dd MMM HH:mm yyyy","yyyy-MM-dd HH:mm");
		
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
		
		String strViewHeader = strApplicationTime+" "+objView_data.strViewName+" View Snapshot";	
		
		String strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 1, 1, strDownloadName1);
		System.out.println(strValue);
		
		assertEquals(strViewHeader, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 1, strDownloadName1);
		assertEquals(objResourceType_data.strResourceTypeName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 1, strDownloadName1);
		assertEquals(objResource_data.strResourceName, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 2, strDownloadName1);
		assertEquals(objTest_data.strComment, strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 2, 3, strDownloadName1);
		assertEquals("", strValue);
		
		strValue = objOffCommonFunc.readInfoExcel(objResourceType_data.strResourceTypeName, 3, 2, strDownloadName1);
		assertEquals("", strValue);
		
	    objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
}
