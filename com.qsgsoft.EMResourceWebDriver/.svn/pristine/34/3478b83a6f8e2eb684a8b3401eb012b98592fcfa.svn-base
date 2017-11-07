package requirementGroup.CreatingAndManagingRoles;

import static org.testng.Assert.assertTrue; 
import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
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
import qaframework.lib.UserDefinedFunctions.CSVFunctions;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayCreateRole extends TestNG_UI_EXTENSIONS{

	
	public HappyDayCreateRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/****************************************************************************************************************
	'Description : Verify that a user can be provided a role with right to generate Monthly Status Assessment report.
	'Date	 	 : 23-Mar-2015
	'Author		 : Anil
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/
	@Test(description = "Verify that a user can be provided a role with right to generate Monthly Status Assessment report.")
	public void testHappyDay69228() throws Exception {

		gstrTCID = "69228";
		gstrTO = "Verify that a user can be provided a role with right to generate Monthly Status Assessment report.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		Roles_data objRolesData = new Roles_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.csvFile;
		CSVFunctions objCSVFunctions = new CSVFunctions();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strRoleValue[] = new String[1];
		
		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + "TC" +gstrTCID+ "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

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
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)		
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		// role
		objNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
		         .enterRoleName(objRolesData.strRoleName);
		
		objUsersList1.selectMonthlyStatusAssignmentOption();
		
		objRoles1.clickOnSaveBtn();

		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objUsersList1
				.navigateToUsersNew()
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
						
				.editUserDetails(objUser_data.strNewUserName)
		             
		             .selectRoleCheckBox(strRoleValue)
		             
		             .clickSaveButton();
		
		objLogin1.clickLogOut();
		//New user login
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();
		System.out.println(objResource_data.strResourceName);
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.selectStatusTypes(strstatusTypeValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
						.clickOnSaveButton();

		String strCurrentDate = objDts.getCurrentDate("MM/dd/yyyy HH:mm");

		String[] strTime4 = strCurrentDate.split(" ");
		
		String[] strTime5 = strTime4[0].split("/");
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnMonthlyStatusSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1.verifyDetailsInMonthlyStatusAssesmentPage1(strTime5[0], strTime5[2]);
		
		String strMonth = objReport1.getSelectedMonth();
		
		objReport1.selectResources(strResourceValue[0]).clickOnNextBtn()
		
		.verMonthlyStatusAssessmentReportPge2IsDisplayed()
		  .selStatusType(objStatusTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .verMonthlyStatusAssessmentReportPge3IsDisplayed()
		  .verifyStatuses(strStatusesValues[0])
		  .verifyStatuses(strStatusesValues[1])
		  .selStatuses(strStatusesValues[0]);
		
		String mainWindowHandle = driver1.getWindowHandle();

		String strEventStartTime = objEventManagement1.getApplicationTimeWithCSTCDT();

		String strEventStartTime1 = dts.AddTimeToExistingTimeHourAndMin(strEventStartTime, 0, 1, "dd MMM HH:mm");
		String strStartTime[] = strEventStartTime.split(" ");

		String strReportTime = strStartTime[0]+" "+strStartTime[1]+" "+strTime5[2]+" "+strStartTime[2]+" "+objTest_data.timeZone;
		
		String strStartTime1[] = strEventStartTime1.split(" ");
		
		String strReportTime1 = strStartTime1[0]+" "+strStartTime1[1]+" "+strTime5[2]+" "+strStartTime1[2]+" "+objTest_data.timeZone;
		
		objReport1.clickOnGenerateReportBtn();

		Thread.sleep(10000);
		
		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		
		String TitleName = driver1.getTitle();
		assertTrue(TitleName.contains("Monthly Status Assessment Report"));

		String[] strHeaderName = {"Monthly Status Assessment Report for "+strMonth+" "+ strTime5[2],objStatusTypes_data.strMSTStatusTypeName };
		
		objReport1.verifyHeadersInHTMLMonthlyAssesmentReport(strHeaderName);
		
		String[] strHeaderName1  = {"Resource Selected: "+objResource_data.strResourceName+" (N=1)", "Status Selected: "+objStatuTypes_data.strStatusNameInMulti};
		objReport1.verifyRSAndSTInHTMLMonthlyAssesmentReport(strHeaderName1);
		
		objReport1.verifyFooterHTMLMonthlyAssesmentReport(strReportTime, strReportTime1);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnMonthlyStatusSummaryLink();

		objReport1.selectCSVRadioBtn();
		
		objReport1.selectResources(strResourceValue[0]).clickOnNextBtn()
		
		  .selStatusType(objStatusTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .verMonthlyStatusAssessmentReportPge3IsDisplayed()
		  .selStatuses(strStatusesValues[0]);

		objReport1.clickOnGenerateReportBtn();
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
		File file1 = new File(strDownloadName);
		boolean strCsv1 = file1.exists();

		objLogin1.clickLogOut();

		String[][] strReportData = {{},{}, {},{}, {"\"Monthly Status Assessment Report for "+strMonth+" of "+strTime5[2]+"\""}, {"\""+objStatuTypes_data.strMSTStatusTypeName+"\""},{"\"Resource Selected: "+objResource_data.strResourceName+"(N=1)\""}, {"\"Status Selected: "+objStatuTypes_data.strStatusNameInMulti+"\""}, {"\"HOUR\""}};
		
		objCSVFunctions.verifyMonthlyAssesmentCSVData(strDownloadName, strReportData);
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName + ", ",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					"",
					objReport_data.ExternalIP,
					strDownloadName,"",
					"",
					 objStatuTypes_data.strStatusNameInMulti};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
			gstrResult = "PASS";
		}
		
	}
}
