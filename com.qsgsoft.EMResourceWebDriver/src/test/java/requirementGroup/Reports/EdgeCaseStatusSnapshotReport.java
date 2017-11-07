package requirementGroup.Reports;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Properties;

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

public class EdgeCaseStatusSnapshotReport extends TestNG_UI_EXTENSIONS {
	public EdgeCaseStatusSnapshotReport() throws Exception {
		super();
	}
	
	/***************************************************************************************************************
	 * 'Description : Update a status value of a status type ST that was added for a resource RS at the resource level, verify
	 *                that the data is displayed appropriately in the generated ‘Status Snapshot Report’	
	 * 'Date        : 30-Apr-2015 
	 * 'Author      : Hanumegowda
	 ***************************************************************************************************************/

	@Test(description = "Update a status value of a status type ST that was added for a resource RS at the resource level, verify "
			             + "that the data is displayed appropriately in the generated ‘Status Snapshot Report’")
	public void testHappyDay37551() throws Exception {
		gstrTCID = "37551";
		gstrTO = "Update a status value of a status type ST that was added for a resource RS at the resource level, verify"
				  + " that the data is displayed appropriately in the generated ‘Status Snapshot Report’";

		// Objects for data
				Login_data objTest_data = new Login_data();
				UsersList objUsersList_page = new UsersList(this.driver1);
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

				User_data objUserdata = new User_data();
				StatusTypes_data objStatusTypes_data = new StatusTypes_data();
				View_data objView_data = new View_data();
				ResourceType_data objResourceType_data = new ResourceType_data();
				Resource_data objResource_data = new Resource_data();
				OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Roles_data objRoles_data = new Roles_data();

		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strResourceValue[] = new String[2];
		String strStatusValue[] = new String[2];
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

//		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		String[] str1 = {strStatusTypeValues[0]};
		
		
		objStatusTypeList
		.createStatusType(objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);

		strStatusValue[0] = objStatusTypeList
		.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

objStatusTypeList.createNewStatus(
		objStatusTypes_data.strStatusNameInMulti1,
		objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);

strStatusValue[1] = objStatusTypeList
		.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

objStatusTypeList.clickOnReturnToStatusTypeList();

strStatusTypeValues[1] = objStatusTypeList
		.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);


		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		
		String[] str2 = {strStatusTypeValues[1],strStatusTypeValues[2],strStatusTypeValues[3],strStatusTypeValues[4],strStatusTypeValues[5]};


		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				str1);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource_Page
				.navigateToResourceListPage()
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
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn()
				.clickOnSaveButton().clickOnSaveButton();
		
		objResource
		.clickOnStatusTypeLinkInResourcePage(
				objResource_data.strResourceName)
		.selectStatusType(str2).clickOnSaveButton();

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);
		
		objResource_Page
		.navigateToResourceListPage()
		.clickOnCreateNewResourceButton()
		.enterResourceName(objResource_data.strResourceName1)
		.enterResourceAbbrivation(
				objResource_data.strResourceAbbrivation)
		.selectResourceTypename(
				objResourceType_data.strResourceTypeName)
		.selectStandardResourceTypename(
				objResource_data.strStandardResourceTypename)
		.enterResourceFirstName(objResource_data.strResourceFirstName)
		.enterResourceLastName(objResource_data.strResourceLastName)
		.enterStreetAddress(objResource_data.strStreetAddress)
		.selectState(objResource_data.strState)
		.enterCity(objResource_data.strCity)
		.enterzipCode(objResource_data.strZipcode)
		.selectCounty(objResource_data.strCounty)
		.clickOnLookupAddressBtn()
		.clickOnSaveButton().clickOnSaveButton();
		
		strResourceValue[1] = objResource_Page
				.getResourceValue(objResource_data.strResourceName1);
		
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);


		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
						.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectRunReportRight(objResource_data.strResourceName1)
				.selectViewResourceRights(objResource_data.strResourceName1)
				
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption()
				.clickSaveButton();
		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();
		Thread.sleep(10000);

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
objUpdateStatus1.clickOnSelectAll();
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusValue[0]);
		
		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[4],
				objView_data.strValueForNDST);
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[3],
				objView_data.strValueForSST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForTST);
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strDateUpdateValue)
				.clickOnSaveButton();
		
Thread.sleep(5000);
		
		String strEventStartTime = objEventManagement1.getApplicationTime();
		String strEventStartTime1 = objEventManagement1.getApplicationTimeWithCSTCDT();

		String strStartTime[] = strEventStartTime.split(":");

		String strStartTime1[] = strStartTime[0].split(" ");

		String strDate2 = strStartTime1[0];
		
		String strMonth = strStartTime1[1];
		
		strMonth = objDate_Time_settings.converDateFormat(strMonth, "MMM", "MM");
		
		String strYear = objDate_Time_settings.getFutureYear(0, "yyyy");
		
		String strHour = strStartTime1[2];

		String strMinute = strStartTime[1];
		
		String strMinute1 = objDate_Time_settings.addTimetoExisting(strMinute, 1, "mm");
		String strMinute2 = objDate_Time_settings.addTimetoExisting(strMinute, 2, "mm");
		
		String strCurrentDate = strMonth+"/"+strDate2+"/"+strYear;
		
		String strTime = objDate_Time_settings.getCurrentDate("HH:mm");
		
		strCurrentDate = strCurrentDate+" "+strTime;
		
		String[] strDate = strCurrentDate.split(" ");
		
		System.out.println(strCurrentDate);
		String strLastUpdatedDateInReport = objDate_Time_settings.converDateFormat(strCurrentDate, "MM/dd/yyyy HH:mm", "dd MMM yyyy HH:mm");
		String str[] = strLastUpdatedDateInReport.split(" ");
		strLastUpdatedDateInReport = str[0]+" "+str[1]+" "+str[2]+" "+strHour+":"+strMinute;
		System.out.println(strLastUpdatedDateInReport);

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSnapshot().enterReportDate(strCurrentDate)
				.selectHour(strHour).selectMinute(strMinute)
				.clickOnGenerateReportBtn();

Thread.sleep(60000);
		
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
				"Status Snapshot", 1, 1, strDownloadName1);
		assertEquals("Status Snapshot - "+strDate[0]+" "+strHour+":"+strMinute1+"", strValue);

		String[] strHeaderNames = objReport_data.strStatusSnapshot;

		String[] strAnswers = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objStatusTypes_data.strDateStatusTypeName,
				objView_data.strDateUpdateValue,
				"",strEventStartTime1};
		
		String[] strAnswers1 = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strStatusNameInMulti,
				"",strEventStartTime1};
		
		String[] strAnswers2 = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objStatusTypes_data.strNumberStatusType,
				objView_data.strValueForUpdate,
				"",strEventStartTime1};
		
		String[] strAnswers3 = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objStatusTypes_data.strSaturationScoreStatusType,
				objView_data.strUpdatedValForSST,
				"",strEventStartTime1};
		
		String[] strAnswers4 = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objStatusTypes_data.strTextStatusType,
				objView_data.strValueForTST,
				"",strEventStartTime1};

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Status Snapshot",
					2, intCount, strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

//			strValue = objOffCommonFunc.readInfoExcel("Status Snapshot",
//					3, intCount, strDownloadName1);
//			assertTrue(strAnswers[intCount - 1].contains(strValue));
		}
		int rownum = objOffCommonFunc.getRowsCountOfExceSheet(strDownloadName1, "Status Snapshot");
		System.out.println(rownum);
		for(int i=1; i<=rownum;i++){
			String text = objOffCommonFunc.readInfoExcel("Status Snapshot",
					i, 3, strDownloadName1);
			if(text.equals(objView_data.strDateUpdateValue)||text.equals(objStatusTypes_data.strStatusNameInMulti)||text.equals(objView_data.strValueForUpdate)
					||text.equals(objView_data.strUpdatedValForSST)||text.equals(objView_data.strValueForTST)){
				for(int j=1; j<=strAnswers.length; j++){
					String text1 = objOffCommonFunc.readInfoExcel("Status Snapshot",
							i, j, strDownloadName1);
					assertTrue(text1.equals(strAnswers[j-1])||text1.equals(strAnswers1[j-1])||text1.equals(strAnswers2[j-1])
							||text1.equals(strAnswers3[j-1])||text1.equals(strAnswers4[j-1]));
				}
				
			}
		}
		
		gstrResult = "PASS";
	}
}


