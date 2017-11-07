package requirementGroup.Reports;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
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

public class NewHappyDayStatusDetailReport extends TestNG_UI_EXTENSIONS {

	public NewHappyDayStatusDetailReport() throws Exception {
		super();
	}

	/*********************************************************************************
	'Description :  Generate 'Status Detail report' in PDF format and verify that the report displays correct data.
	'Precondition:
	'Date	 	 : 25-Jun-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = " Generate 'Status Detail report' in PDF format and verify that the report displays correct data.")
	public void testHappyDay103962() throws Exception {

		gstrTCID = "103962";
		gstrTO = " Generate 'Status Detail report' in PDF format and verify that the report displays correct data.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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

		String strStatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strStatusesValues1[] = new String[2];
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
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
		
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType;	
		String strDownloadName3 = file + "\\" + "TC"+gstrTCID+"_3" + "_" + strTimeText
				+ fileType;	
		String strDownloadName4 = file + "\\" + "TC"+gstrTCID+"_4" + "_" + strTimeText
				+ fileType;	
		String strDownloadName5 = file + "\\" + "TC"+gstrTCID+"_5" + "_" + strTimeText
				+ fileType;	
		String strDownloadName6 = file + "\\" + "TC"+gstrTCID+"_6" + "_" + strTimeText
				+ fileType;	
		String[] strDownloadName = {strDownloadName1, strDownloadName2, strDownloadName3, strDownloadName4, strDownloadName5, strDownloadName6};
		
		boolean[] strPdf = {false, false, false, false, false, false};
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);


		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		
		objStatusTypeList.createSharedStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strsSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strsSSTStatusTypeName);

	
		objStatusTypeList.createSharedStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strsTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strsTSTStatusTypeName);
		
		
		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strpMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti2, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti2);
		strStatusesValues1[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti3, objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3);
		strStatusesValues1[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);

		
		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strpSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpSSTStatusTypeName);
		
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.selectStatusTypes(strStatusTypeValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1], strStatusesValues[0])
				
				.selectStatusTypes(strStatusTypeValues[2])
				.enterUpdateSSTValues(strStatusTypeValues[2], objView_data.strValueForSST)
				
				.selectStatusTypes(strStatusTypeValues[3])
				
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForTST)
				
				.selectStatusTypes(strStatusTypeValues[4])
				.selectMSTUpdateValue(strStatusTypeValues[4], strStatusesValues1[1])
				
				.selectStatusTypes(strStatusTypeValues[5])
				.enterUpdateSSTValues(strStatusTypeValues[5], objView_data.strValueForSST1)
								
				.clickOnSaveButton();
		String[] strUpdatedValues = {objView_data.strValueForUpdate, objStatusTypes_data.strStatusNameInMulti, objView_data.strUpdatedValForSST, objView_data.strValueForTST, objStatusTypes_data.strStatusNameInMulti3, objView_data.strUpdatedValForSST1};
		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strValueForUpdate);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		
		String[] strStatusTypes= {objStatuTypes_data.strNSTStatusTypeName, objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strsSSTStatusTypeName,
									objStatuTypes_data.strsTSTStatusTypeName, objStatuTypes_data.strpMSTStatusTypeName, objStatuTypes_data.strpSSTStatusTypeName};
		
		
		
		for(int intCount = 0;intCount<strStatusTypeValues.length; intCount++){
			

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(strStatusTypes[intCount])
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						strStatusTypes[intCount])
				.selectResources(strResourceValue[0]);
				
		if(strStatusTypes[intCount].equals(objStatuTypes_data.strMSTStatusTypeName)){
		objReport1.selectStatusCheckbox(strStatusesValues[0]);
		}		
		
		if(strStatusTypes[intCount].equals(objStatuTypes_data.strpMSTStatusTypeName)){
		objReport1.selectStatusCheckbox(strStatusesValues1[1]);
		}	
		
		objReport1.clickOnGenerateReportBtn();

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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName[intCount],
				strAutoITName);
		 
		File file1 = new File(strDownloadName[intCount]);
		strPdf[intCount] = file1.exists();

		if (strPdf[intCount]) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					strStatusTypes[intCount], "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , strUpdatedValues[intCount]};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}	
		
		}

		assertTrue(strPdf[0] && strPdf[1] && strPdf[2] && strPdf[3] && strPdf[4]&& strPdf[5]);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}

	/*********************************************************************************
	'Description : Generate 'Status Detail report' in CSV format and verify that the report displays correct data. 
	'Precondition:
	'Date	 	 : 25-Jun-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Generate 'Status Detail report' in CSV format and verify that the report displays correct data. ")
	public void testHappyDay103963() throws Exception {

		gstrTCID = "103963";
		gstrTO = "Generate 'Status Detail report' in CSV format and verify that the report displays correct data. ";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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

		String strStatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strStatusesValues1[] = new String[2];
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
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
		
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType;	
		String strDownloadName3 = file + "\\" + "TC"+gstrTCID+"_3" + "_" + strTimeText
				+ fileType;	
		String strDownloadName4 = file + "\\" + "TC"+gstrTCID+"_4" + "_" + strTimeText
				+ fileType;	
		String strDownloadName5 = file + "\\" + "TC"+gstrTCID+"_5" + "_" + strTimeText
				+ fileType;	
		String strDownloadName6 = file + "\\" + "TC"+gstrTCID+"_6" + "_" + strTimeText
				+ fileType;	
		String[] strDownloadName = {strDownloadName1, strDownloadName2, strDownloadName3, strDownloadName4, strDownloadName5, strDownloadName6};
		
		boolean[] stCsv = {false, false, false, false, false, false};
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);


		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		
		objStatusTypeList.createSharedStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strsSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strsSSTStatusTypeName);

	
		objStatusTypeList.createSharedStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strsTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strsTSTStatusTypeName);
		
		
		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strpMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti2, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti2);
		strStatusesValues1[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti3, objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3);
		strStatusesValues1[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);

		
		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strpSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpSSTStatusTypeName);
		
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.selectStatusTypes(strStatusTypeValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1], strStatusesValues[0])
				
				.selectStatusTypes(strStatusTypeValues[2])
				.enterUpdateSSTValues(strStatusTypeValues[2], objView_data.strValueForSST)
				
				.selectStatusTypes(strStatusTypeValues[3])
				
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForTST)
				
				.selectStatusTypes(strStatusTypeValues[4])
				.selectMSTUpdateValue(strStatusTypeValues[4], strStatusesValues1[1])
				
				.selectStatusTypes(strStatusTypeValues[5])
				.enterUpdateSSTValues(strStatusTypeValues[5], objView_data.strValueForSST1)
								
				.clickOnSaveButton();
		String[] strUpdatedValues = {objView_data.strValueForUpdate, objStatusTypes_data.strStatusNameInMulti, objView_data.strUpdatedValForSST, objView_data.strValueForTST, objStatusTypes_data.strStatusNameInMulti3, objView_data.strUpdatedValForSST1};
		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strValueForUpdate);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		
		String[] strStatusTypes= {objStatuTypes_data.strNSTStatusTypeName, objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strsSSTStatusTypeName,
									objStatuTypes_data.strsTSTStatusTypeName, objStatuTypes_data.strpMSTStatusTypeName, objStatuTypes_data.strpSSTStatusTypeName};
		
		
		
		for(int intCount = 0;intCount<strStatusTypeValues.length; intCount++){
			

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.selectCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(strStatusTypes[intCount])
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						strStatusTypes[intCount])
				.selectResources(strResourceValue[0]);
				
		if(strStatusTypes[intCount].equals(objStatuTypes_data.strMSTStatusTypeName)){
		objReport1.selectStatusCheckbox(strStatusesValues[0]);
		}		
		
		if(strStatusTypes[intCount].equals(objStatuTypes_data.strpMSTStatusTypeName)){
		objReport1.selectStatusCheckbox(strStatusesValues1[1]);
		}	
		
		objReport1.clickOnGenerateReportBtn();

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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName[intCount],
				strAutoITName);
		 
		File file1 = new File(strDownloadName[intCount]);
		stCsv[intCount] = file1.exists();

		if (stCsv[intCount]) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					strStatusTypes[intCount], "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , strUpdatedValues[intCount]};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}	
		
		}

		assertTrue(stCsv[0] && stCsv[1] && stCsv[2] && stCsv[3] && stCsv[4]&& stCsv[5]);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}
	
	/*********************************************************************************
	'Description : Update status of a numeric status type NST added at the resource type level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with view right for NST can view the status of NST in the generated status detail report.
	'Precondition:
	'Date	 	 : 18-Sep-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Update status of a numeric status type NST added at the resource type level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with view right for NST can view the status of NST in the generated status detail report.")
	public void testHappyDay42729() throws Exception {

		gstrTCID = "42729";
		gstrTO = "Update status of a numeric status type NST added at the resource type level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with view right for NST can view the status of NST in the generated status detail report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
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
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType1;		
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strValueForUpdate);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName)
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		 
		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strNSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);
		
		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
	
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					 objLogin_data.strRegionName,
					objStatusTypes_data.strNSTStatusTypeName,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF,
					objReport_data.ExternalIP,strDownloadName2,strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1&& strCsv1);

		if(strPdf1&& strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	
	/*********************************************************************************
	'Description : Update status of a numeric status type NST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with view right for NST can view the status of NST in the generated status detail report.
	'Precondition:
	'Date	 	 : 02-Jul-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Update status of a numeric status type NST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with view right for NST can view the status of NST in the generated status detail report.")
	public void testHappyDay63390() throws Exception {

		gstrTCID = "63390";
		gstrTO = "Update status of a numeric status type NST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and with a role with view right for NST can view the status of NST in the generated status detail report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		
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
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType1;		
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();
		
		String[] strOneStatus = {strStatusTypeValues[0]};
		
		objResource1.selectStatusType(strOneStatus)
		.clickOnSaveButton();
		
		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		System.out.println(objResource_data.strResourceName);
		

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strValueForUpdate);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		 
		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strNSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);
		
		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
	
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					 objLogin_data.strRegionName,
					objStatusTypes_data.strNSTStatusTypeName,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF,
					objReport_data.ExternalIP,strDownloadName2,strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1&& strCsv1);

		if(strPdf1&& strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/*********************************************************************************
	'Description : Add a number status type NST back to resource RS and update the status value of NST for RS, generate the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report
	'Precondition:
	'Date	 	 : 02-Jul-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Add a number status type NST back to resource RS and update the status value of NST for RS, generate the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report")
	public void testHappyDay63336() throws Exception {

		gstrTCID = "63336";
		gstrTO = "Add a number status type NST back to resource RS and update the status value of NST for RS, generate the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		
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
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType1;		
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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
		
		objResource.verEditResourceLevelStatusTypesPageisDisplayed();
		
		String[] strOneStatus = {strStatusTypeValues[0]};
		
		objResource.selectStatusType(strOneStatus)
		.clickOnSaveButton();
		
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();
		
		objResource1.deselectStatusType(strOneStatus)
		
		.clickOnSaveButton();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();
		
		objResource1.selectStatusType(strOneStatus)
		
		.clickOnSaveButton();
		
		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strValueForUpdate);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		 
		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strNSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);
		
		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
	
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					 objLogin_data.strRegionName,
					objStatusTypes_data.strNSTStatusTypeName,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF,
					objReport_data.ExternalIP,strDownloadName2,strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1&& strCsv1);

		if(strPdf1&& strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/*********************************************************************************
	'Description : Update the status of a numeric private status type pNST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pNST for RS in the generated status detail report.
	'Precondition:
	'Date	 	 : 02-Jul-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = " Update the status of a numeric private status type pNST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pNST for RS in the generated status detail report.")
	public void testHappyDay184566() throws Exception {

		gstrTCID = "184566";//Old TC ID 63392 is deactivated 
		gstrTO = " Update the status of a numeric private status type pNST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pNST for RS in the generated status detail report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
//		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
//		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
//		Resource objResource1 = new Resource(this.driver1);
		UpdateStatus UpdateStatuspage1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		
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
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType1;		
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createPrivateStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strPNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strPNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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
		
		objResource.verEditResourceLevelStatusTypesPageisDisplayed();
		
		String[] strOneStatus = {strStatusTypeValues[0]};
		
		objResource.selectStatusType(strOneStatus)
		           .clickOnSaveButton();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)				
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
//				.selectSetupResourceOption()
//				.selectSetupResourceTypesOption()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);	
		
//modification : another user is created for updating		
		objNavigationToSubMenus.navigateToUsers();
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword1, objUserdata.strFullName1)
		.selectFirstRole()
        .selectUpdateStatusOfResource(objResource_data.strResourceName)
        .clickSaveButton()
        .verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName1);

		objNavigationToSubMenus.navigateToViews();
		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				objStatuTypes_data.strPNSTStatusTypeName);
		objLogin.clickLogOut();
		
		System.out.println("---Precondition ends and test execution starts----");
				
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);		
		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnViewMenu();
		Thread.sleep(2000);
		
		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatuspage1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],objView_data.strValueForUpdate);
		UpdateStatuspage1.clickOnSaveButton();
		objViewsList1.verifyUpdatedValue(strResourceValue[0],strStatusTypeValues[0],objView_data.strValueForUpdate);		
		
		String strUpdatedTime = objEventManagement1.getApplicationTime();
		String strUpdatedTime_ForReport = dts.timeNow("HH:mm:ss");
		String[] UpdatedDate = strUpdatedTime.split(" ");
		String strCurYear = dts.getCurrentDate("yyyy");
		String strRequiredUpdatedTime = dts.converDateFormat(UpdatedDate[0]
				+ UpdatedDate[1] + strCurYear + " " + UpdatedDate[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");
		objLogin1.clickLogOut();
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strPNSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strPNSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

//		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
//				strUpdatedTime);
		
		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime_ForReport);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		 
		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strPNSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strPNSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strPNSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);
		
//		int intExcelDurationDiff = dts.getTimeDiff1(
//				strExcelReportGeneratedtime, strUpdatedTime);
		
		int intExcelDurationDiff = dts.getTimeDiff1(strExcelReportGeneratedtime,
				strUpdatedTime_ForReport);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
	
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					 objLogin_data.strRegionName,
					objStatusTypes_data.strPNSTStatusTypeName,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF,
					objReport_data.ExternalIP,strDownloadName2,strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1&& strCsv1);

		if(strPdf1&& strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	/***************************************************************************************************************
	'Description : Add a text status type TST back to resource RS and update the status value of TST for RS,generate
	               the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report
	'Date	 	 : 02-Jul-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                Modified By
	'Date					                                                            Name
	****************************************************************************************************************/
	@Test(description = "Add a text status type TST back to resource RS and update the status value of TST for RS,"
			+ " generate the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report.")
	public void testHappyDay63369() throws Exception {

		gstrTCID = "63369";
		gstrTO = "Add a text status type TST back to resource RS and update the status value of TST for RS, generate the"
				+ " ‘Status Detail Report’ and verify that the data is displayed appropriately in the report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Report_data objReport_data = new Report_data();
		Date_Time_settings dts = new Date_Time_settings();
		User_data objUserdata = new User_data();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();	
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
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType1;		
		
		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		
		System.out.println("--------precondition starts----------");
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()
		
		.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objResource
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource.verEditResourceLevelStatusTypesPageisDisplayed();

		String[] strOneStatus = { strStatusTypeValues[0] };

		objResource.selectStatusType(strOneStatus).clickOnSaveButton();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("--------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		objResource1.deselectStatusType(strOneStatus)

		.clickOnSaveButton();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		objResource1.selectStatusType(strOneStatus)

		.clickOnSaveButton();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strValueForUpdate);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts.converDateFormat(
				strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm", "M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strReportDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strTSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strTSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strTSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objView_data.strValueForUpdate };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strTSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strTSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);

		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strTSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objView_data.strValueForUpdate };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1 && strCsv1);

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	/***************************************************************************************************************
	'Description : Add a saturation score status type SST back to resource RS and update the status value of TST for RS,generate
	               the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report
	'Date	 	 : 02-Jul-2015
	'Author		 : Anil
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                Modified By
	'Date					                                                            Name
	****************************************************************************************************************/
	@Test(description = "Add a saturation score status type TST back to resource RS and update the status value of TST for RS,"
			+ " generate the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report.")
	public void testHappyDay63379() throws Exception {

		gstrTCID = "63379";
		gstrTO = "Add a saturation score status type TST back to resource RS and update the status value of TST for RS, generate the"
				+ " ‘Status Detail Report’ and verify that the data is displayed appropriately in the report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Report_data objReport_data = new Report_data();
		Date_Time_settings dts = new Date_Time_settings();
		User_data objUserdata = new User_data();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();	
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
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType1;		
		
		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		
		System.out.println("--------precondition starts----------");
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()
		
		.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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
		
		System.out.println(objResource_data.strResourceName);

		objResource
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource.verEditResourceLevelStatusTypesPageisDisplayed();

		String[] strOneStatus = { strStatusTypeValues[0] };

		objResource.selectStatusType(strOneStatus).clickOnSaveButton();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("--------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		objResource1.deselectStatusType(strOneStatus)

		.clickOnSaveButton();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		objResource1.selectStatusType(strOneStatus)

		.clickOnSaveButton();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterUpdateSSTValues(strStatusTypeValues[0],
						objView_data.strValueForSST).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strUpdatedValForSST);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts.converDateFormat(
				strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm", "M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strReportDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strSSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strSSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
        Thread.sleep(10000);
		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strSSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objView_data.strUpdatedValForSST };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strSSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strSSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);

		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strSSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objView_data.strUpdatedValForSST };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1 && strCsv1);

			gstrResult = "PASS";

	}
	
	/*********************************************************************************
	'Description : Update the status of a multi private status type pMST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pMST for RS in the generated status detail report.
	'Precondition:
	'Date	 	 : 07-Jul-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Update the status of a multi private status type pMST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pMST for RS in the generated status detail report.")
	public void testHappyDay63394() throws Exception {

		gstrTCID = "63394";
		gstrTO = "Update the status of a multi private status type pMST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pMST for RS in the generated status detail report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
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

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[2];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);

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
		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_1" + "_"
				+ strTimeText + fileType;
		String strDownloadName2 = file + "\\" + "TC" + gstrTCID + "_2" + "_"
				+ strTimeText + fileType1;

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createPrivateStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strpMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();		
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		String[] strOneStatus = { strStatusTypeValues[0] };

		objResource1.selectStatusType(strOneStatus).clickOnSaveButton();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0], strStatusesValues[1])
				.clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti1);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts.converDateFormat(
				strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm", "M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strReportDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strpMSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectStatusCheckbox(strStatusesValues[1])
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strpMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strpMSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectStatusCheckbox(strStatusesValues[1])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);

		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strpMSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1 && strCsv1);

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	
	/*********************************************************************************
	'Description :  Verify that the status detail report displays appropriate data for NEDOCS status type
	'Precondition:
	'Date	 	 : 22-Sep-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = " Verify that the status detail report displays appropriate data for NEDOCS status type")
	public void testHappyDay119791() throws Exception {

		gstrTCID = "119791";
		gstrTO = " Verify that the status detail report displays appropriate data for NEDOCS status type";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
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
		String strDownloadName1 = file + "\\" + "TC" + gstrTCID+"_1" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC" + gstrTCID+"_2" + strTimeText
				+ fileType1;

		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);
		
		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);
		
		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);


		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();
System.out.println(objUserdata.strNewUserName);
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNedocsUpdateValue(strStatusTypeValues[0], objView_data.strValueForNDST1)
				.clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strNEDOCValue2);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"MM/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		 String strStartAndEndDate = dts
				    .converDateFormat(strReportDate, "MM/dd/yyyy",
				      "dd-MMM-yyyy");

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNDSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNDSTStatusTypeName)
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNDSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNDSTStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strNDSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, strStartAndEndDate, strStartAndEndDate,
					strDurationDiffPDF , objView_data.strUpdatedValForNDST};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objLogin_data.strRegionName,
							objStatuTypes_data.strNDSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objView_data.strUpdatedValForNDST};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}


		objLogin1.clickLogOut();

		if(strPdf1  && strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/*********************************************************************************
	'Description :  Add a multi status type MST back to resource RS and update the status value of MST for RS, generate the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report
	'Precondition:
	'Date	 	 : 07-Jul-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = " Add a multi status type MST back to resource RS and update the status value of MST for RS, generate the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report")
	public void testHappyDay63347() throws Exception {

		gstrTCID = "63347";
		gstrTO = " Add a multi status type MST back to resource RS and update the status value of MST for RS, generate the ‘Status Detail Report’ and verify that the data is displayed appropriately in the report";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
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

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[2];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);

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
		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_1" + "_"
				+ strTimeText + fileType;
		String strDownloadName2 = file + "\\" + "TC" + gstrTCID + "_2" + "_"
				+ strTimeText + fileType1;

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();		
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToResourceInSetup();

		objResource
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource.verEditResourceLevelStatusTypesPageisDisplayed();

		String[] strOneStatus = { strStatusTypeValues[0] };

		objResource.selectStatusType(strOneStatus).clickOnSaveButton();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		objResource1.deselectStatusType(strOneStatus).clickOnSaveButton();
		
		objResource1
		.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		objResource1.selectStatusType(strOneStatus).clickOnSaveButton();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0], strStatusesValues[1])
				.clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti1);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts.converDateFormat(
				strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm", "M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strReportDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strMSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectStatusCheckbox(strStatusesValues[1])
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strMSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectStatusCheckbox(strStatusesValues[1])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);

		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1 && strCsv1);

		gstrResult = "PASS";

	}
	
	
	/*********************************************************************************
	'Description : Update the status of a text private status type pTST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pTST for RS in the generated status detail report.
	'Precondition:
	'Date	 	 : 07-Jul-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Update the status of a text private status type pTST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pTST for RS in the generated status detail report.")
	public void testHappyDay63395() throws Exception {

		gstrTCID = "63395";
		gstrTO = "Update the status of a text private status type pTST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pTST for RS in the generated status detail report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		
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
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType1;		
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createPrivateStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strpTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectRunReportsCheckBox(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectSetupResourceOption()
		.selectSetupResourceTypesOption()
		.selectReportStatusDetailOption()
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();
		
		String[] strOneStatus = {strStatusTypeValues[0]};
		
		objResource1.selectStatusType(strOneStatus)
		.clickOnSaveButton();
		
		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForTST).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strValueForTST);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strpTSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strpTSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		 
		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strpTSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , objView_data.strValueForTST};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strpTSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strpTSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);
		
		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
	
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					 objLogin_data.strRegionName,
					objStatusTypes_data.strpTSTStatusTypeName,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF,
					objReport_data.ExternalIP,strDownloadName2,strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, objView_data.strValueForTST};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1&& strCsv1);

		if(strPdf1&& strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	
	}

	
	
	/*********************************************************************************
	'Description : Update the status of a saturation score private status type pSST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pSST for RS in the generated status detail report. 
	'Precondition:
	'Date	 	 : 07-Jul-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Update the status of a saturation score private status type pSST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pSST for RS in the generated status detail report. ")
	public void testHappyDay63396() throws Exception {

		gstrTCID = "63396";
		gstrTO = "Update the status of a saturation score private status type pSST added at the resource level for a resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights on RS and without any role can view the status of pSST for RS in the generated status detail report. ";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
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

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		
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
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType1;		
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createPrivateStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strpSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectRunReportsCheckBox(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectSetupResourceOption()
		.selectSetupResourceTypesOption()
		.selectReportStatusDetailOption()
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();
		
		String[] strOneStatus = {strStatusTypeValues[0]};
		
		objResource1.selectStatusType(strOneStatus)
		.clickOnSaveButton();
		
		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterUpdateSSTValues(strStatusTypeValues[0], objView_data.strValueForSST)
				/*.enterNSTAndTSTUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForTST)*/.clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strUpdatedValForSST);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strpSSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strpSSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
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

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		 
		File file1 = new File(strDownloadName1);
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
					objStatusTypes_data.strpSSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , objView_data.strUpdatedValForSST};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strpSSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strpSSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);
		
		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
	
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					 objLogin_data.strRegionName,
					objStatusTypes_data.strpSSTStatusTypeName,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF,
					objReport_data.ExternalIP,strDownloadName2,strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, objView_data.strUpdatedValForSST};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1&& strCsv1);

			gstrResult = "PASS";

	
	}

	/*********************************************************************************
	'Description :  Verify that resource is not listed in the 'Step Detail Report (Step 2 of 2) screen, if the status type selected in the previous screen is refined for that particular resource.
	'Precondition:
	'Date	 	 : 07-Jul-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = " Verify that resource is not listed in the 'Step Detail Report (Step 2 of 2) screen, if the status type selected in the previous screen is refined for that particular resource.")
	public void testHappyDay63368() throws Exception {

		gstrTCID = "63368";
		gstrTO = " Verify that resource is not listed in the 'Step Detail Report (Step 2 of 2) screen, if the status type selected in the previous screen is refined for that particular resource.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
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
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();
		
		String strResourceValue[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strstatusTypeValues[] = new String[4];
		String strStatusesValues[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

			
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();
		
		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
        .clickOnReturnToStatusTypeList();


		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		// create resource with address
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
		
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectRunReportsCheckBox(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName1)
		.selectRunReportsCheckBox(objResource_data.strResourceName1)
		.clickAdvancedOptionAndExpand()
		.selectReportStatusDetailOption()
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectRunReportsCheckBox(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName1)
		.selectRunReportsCheckBox(objResource_data.strResourceName1)
		.clickAdvancedOptionAndExpand()
		.selectReportStatusDetailOption()
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectConfigureRegionalUserAccessOption()
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();
		
		objNavigationToSubMenus.navigateToResourceInSetup();
		
		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource.verEditResourceLevelStatusTypesPageisDisplayed();
		
		objResource.selectStatusType(strstatusTypeValues)
		.clickOnSaveButton();
		
		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName1);
		
		objResource.verEditResourceLevelStatusTypesPageisDisplayed();
		
		objResource.selectStatusType(strstatusTypeValues)
		.clickOnSaveButton();
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objUpdateStatus_data.strNSTUpdateValue)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[1],
						objUpdateStatus_data.strTSTUpdateValue)
				.selectMSTUpdateValue(strstatusTypeValues[2],
						strStatusesValues[0])
				.enterUpdateSSTValues(strstatusTypeValues[3],
						objUpdateStatus_data.strSSTUpdateValue)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
						objUpdateStatus_data.strNSTUpdateValue).clickOnSaveButton();

		objLogin1.clickLogOut();
		
	
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objUsersList1.navigateToUsers();
		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
		 .clickSearchButton()
		 .editUserDetails(objUserdata.strNewUserName)
		 .clickRefineLinkOfViewResource(objResource_data.strResourceName1)
		 .verRefineVisiblesttausTypesWinIsDisplayed()
		 .selectFrameOfRefineVisibleStatusTypes();
		
		objUsersList1.deselectStatusTypesInRefine(strstatusTypeValues)
		 .clickSaveChangesButtonInRefine()
		 .selectFrame()
		 .clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		objNavigationToSubMenus1.clickOnStatusReports();
		
		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.verifyStartDate()
				.verifyEndDate()
				.verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.verifyStatusTypeDropDownIsDisplayed()
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName)
				.verifyResourceIsDisplayed(strResourceValue[0])
				.verifyResourceIsNotDisplayed(strResourceValue[1]);

		objNavigationToSubMenus1.clickOnStatusReports();
		
		objReport1
		.clickOnStatusDetail()
		.verStatusDetailReportPgeIsDisplayed()
		.enterReportStartDate(strReportDate)
		.enterReportEndDate(strReportDate)
		.verifyStatusTypeDropDownIsDisplayed()
		.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
		.clickOnNextBtn()
		.verStatusDetailReportPge2IsDisplayed()
		.verStatusTypeInStatusDetailReportPge2(
				objStatuTypes_data.strNSTStatusTypeName)
		.verifyResourceIsDisplayed(strResourceValue[0])
		.verifyResourceIsNotDisplayed(strResourceValue[1]);

		objNavigationToSubMenus1.clickOnStatusReports();
		
		objReport1
		.clickOnStatusDetail()
		.verStatusDetailReportPgeIsDisplayed()
		.enterReportStartDate(strReportDate)
		.enterReportEndDate(strReportDate)
		.verifyStatusTypeDropDownIsDisplayed()
		.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
		.clickOnNextBtn()
		.verStatusDetailReportPge2IsDisplayed()
		.verStatusTypeInStatusDetailReportPge2(
				objStatuTypes_data.strMSTStatusTypeName)
		.verifyResourceIsDisplayed(strResourceValue[0])
		.verifyResourceIsNotDisplayed(strResourceValue[1]);


		objNavigationToSubMenus1.clickOnStatusReports();
		
		objReport1
		.clickOnStatusDetail()
		.verStatusDetailReportPgeIsDisplayed()
		.enterReportStartDate(strReportDate)
		.enterReportEndDate(strReportDate)
		.verifyStatusTypeDropDownIsDisplayed()
		.selStatusType(objStatuTypes_data.strSSTStatusTypeName)
		.clickOnNextBtn()
		.verStatusDetailReportPge2IsDisplayed()
		.verStatusTypeInStatusDetailReportPge2(
				objStatuTypes_data.strSSTStatusTypeName)
		.verifyResourceIsDisplayed(strResourceValue[0])
		.verifyResourceIsNotDisplayed(strResourceValue[1]);

		objLogin1.clickLogOut();
			gstrResult = "PASS";
	}

}