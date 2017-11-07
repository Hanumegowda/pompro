package requirementGroup.Reports;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.Login;
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

public class NewCreatingAndManagingUsers extends TestNG_UI_EXTENSIONS {

	public NewCreatingAndManagingUsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/****************************************************************************************************************
	'Description : Verify that a user can be provided the right to generate Statewide Resource Detail report.
	'Precondition:
	'Date	 	 :04-Feb-2016
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to generate Statewide Resource Detail report.")
	public void testHappyDay99746() throws Exception {

		gstrTCID = "99746";
		gstrTO = "Verify that a user can be provided the right to generate Statewide Resource Detail report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Report_data objReport_data = new Report_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
        User_data objUser_data = new User_data();
		View_data objView_data = new View_data();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
        UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus_Page = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		
		String strstatusTypeValues[] = new String[9];
		String strStdStatusValue[] = new String[3];
		String strStdResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[3];


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
		
		String strLogitude = "";
		String strLatitude = "";

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName4.trim());

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// RoleBased Status Types in Region1
		objStatusTypeList.enterStatusTypesSelectingStdStatusType(objStatuTypes_data.strNumberStatusType, objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription, objStatuTypes_data.strStandardStatusTypeName2);

		strStdStatusValue[0] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypeName2);

		System.out.println(strStdStatusValue[0]);

		objStatusTypeList.clickOnSaveButton();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// RoleBased Status Types in Region1
		objStatusTypeList.enterStatusTypesSelectingStdStatusType(objStatuTypes_data.strNumberStatusType, objStatuTypes_data.strNSTStatusTypeName1,
						objStatuTypes_data.strStatusDescription, objStatuTypes_data.strStandardStatusTypeName2);

		objStatusTypeList.selectPrivateStatusTypeRadioBtn();
		
		strStdStatusValue[0] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypeName2);

		objStatusTypeList.clickOnSaveButton();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);
		
		// RoleBased Status Types in Region1
		objStatusTypeList.enterStatusTypesSelectingStdStatusType(objStatuTypes_data.strNumberStatusType, objStatuTypes_data.strNSTStatusTypeName2,
						objStatuTypes_data.strStatusDescription, objStatuTypes_data.strStandardStatusTypeName2);

		objStatusTypeList.selectSharedStatusTypeRadioBtn();
		
		strStdStatusValue[0] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypeName2);

		objStatusTypeList.clickOnSaveButton();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName2);
		

		// RoleBased Status Types in Region1
		objStatusTypeList.enterStatusTypesSelectingStdStatusType(objStatuTypes_data.strMultiStatusType, objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription, objStatuTypes_data.strStandardStatusTypeName4);
		
		strStdStatusValue[1] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypeName4);

		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti)
				
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor)
		 .verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
	
		objStatusTypeList.enterStatusTypesSelectingStdStatusType(objStatuTypes_data.strMultiStatusType, objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objStatuTypes_data.strStandardStatusTypeName4);
		
		strStdStatusValue[1] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypeName4);
		
		objStatusTypeList.selectPrivateStatusTypeRadioBtn();
		
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti1)
				
			             .createNewStatus(objStatuTypes_data.strStatusNameInMulti2,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti2);		

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);	
		
	
		objStatusTypeList.enterStatusTypesSelectingStdStatusType(objStatuTypes_data.strMultiStatusType, objStatuTypes_data.strMSTStatusTypeName2,
				objStatuTypes_data.strStatusDescription, objStatuTypes_data.strStandardStatusTypeName4);
		
		objStatusTypeList.selectSharedStatusTypeRadioBtn();
		
		strStdStatusValue[1] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypeName4);
		
		objStatusTypeList.clickOnSaveButton();
		

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti2,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti2)
		
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti4,
				objStatuTypes_data.strStatusColor)
		 .verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti4);


		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName2);	
		
		objStatusTypeList.enterStatusTypesSelectingStdStatusType(objStatuTypes_data.strTextStatusType, objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objStatuTypes_data.strStandardStatusTypeName5);
	
		
		strStdStatusValue[2] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypeName5);
		
		objStatusTypeList.clickOnSaveButton();
		
		strstatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);		
		
		objStatusTypeList.enterStatusTypesSelectingStdStatusType(objStatuTypes_data.strTextStatusType, objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objStatuTypes_data.strStandardStatusTypeName5);
		objStatusTypeList.selectPrivateStatusTypeRadioBtn();
		
		strStdStatusValue[2] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypeName5);
		
		objStatusTypeList.clickOnSaveButton();
		
		strstatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);			
		
		objStatusTypeList.enterStatusTypesSelectingStdStatusType(objStatuTypes_data.strTextStatusType, objStatuTypes_data.strTSTStatusTypeName2,
				objStatuTypes_data.strStatusDescription, objStatuTypes_data.strStandardStatusTypeName5);
		
		objStatusTypeList.selectSharedStatusTypeRadioBtn();
		
		strStdStatusValue[2] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypeName5);
		
		objStatusTypeList.clickOnSaveButton();
		
		strstatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName2);		
		
		
		String strStatusValues[] = {strstatusTypeValues[0], strstatusTypeValues[1],strstatusTypeValues[2],strstatusTypeValues[4]};
		String strStatusValues1[] = {strstatusTypeValues[3],strstatusTypeValues[5], strstatusTypeValues[6],strstatusTypeValues[7],strstatusTypeValues[8]};
		
		
		
		
		// Resource type creation in Region1
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create Resource in Region1
		objResource
				.navigateToResourceListPage()
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardRTHomeHealth)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn().verMap();

		 strLatitude = objResource.getLatitude();
		strLogitude = objResource.getLongitude();

		strStdResourceValue[0] = objResource
				.getStandardResourceValue(objResource_data.strStandardRTHomeHealth);

		objResource.clickOnSaveButton().clickOnViewResChkBox()
				.clickOnSaveButton();

		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource.selectStatusType(strStatusValues1);

		objResource.clickOnSaveButton();
		
		objUsersList.navigateToUsers();
		System.out.println(objUser_data.strNewUserName);
        //New User Creation
        objUsersList.clickCreateNewUserButton()
        .enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName)
        .selectFirstRole()
        .selectUpdateStatusOfResource(objResource_data.strResourceName)
        .clickSaveButton();    
        
		objnNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strNSTStatusTypeName2,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strMSTStatusTypeName2,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strTSTStatusTypeName2};
		
// Modification is done in create view while selecting region
		objViewsList.clickCreateNewViewButton()
		.enterViewName(objView_data.strViewName)
		.enterViewDesc(objView_data.strViewDesc)
		.clickNextButton()
		.selectRegionName(objLogin_data.strRegionName4)
		.clickNextButton()
		.selectResource(objResource_data.strResourceName)
		.clickNextButton();
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {	
			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}
		
		objViewsList.clickOnSaveOfCreateNewView()
		            .verViewInList(objView_data.strViewName);	
		
		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionStatewideFlorida
				.trim());

		objRegionDefault.selectFrame();

		objUsersList.navigateToUsers();
		
        //New User Creation
        objUsersList.clickCreateNewUserButton()
        .enterUserDetails(objUser_data.strNewUserName1, objUser_data.strNewPassword, objUser_data.strFullName)
        .selectFirstRole()
        .clickAdvancedOptionAndExpand()
        .selectReportStatewideResourceDetail()
        .clickSaveButton();    

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.clickOnViewMenu();

		Thread.sleep(2000);
		objNavigationToSubMenus
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		Thread.sleep(2000);

		objViewsList.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus_Page
		.clickOnSelectAll()
		.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate)
		.enterNSTAndTSTUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForUpdate1)
		.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForUpdate2)
		.selectMSTUpdateValue(strstatusTypeValues[3],
				strStatusesValues[0])
		.selectMSTUpdateValue(strstatusTypeValues[4],
				strStatusesValues[1])
		.selectMSTUpdateValue(strstatusTypeValues[5],
				strStatusesValues[2])
			.enterNSTAndTSTUpdateValue(strstatusTypeValues[6],
				objView_data.strValueForUpdate)
		.enterNSTAndTSTUpdateValue(strstatusTypeValues[7],
				objView_data.strValueForUpdate1)
		.enterNSTAndTSTUpdateValue(strstatusTypeValues[8],
				objView_data.strValueForUpdate2).clickOnSaveButton();
		
		objLogin.clickLogOut();


		objLogin1.loginAsNewUser(objUser_data.strNewUserName1, objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnResourceReports();
		Thread.sleep(5000);
		objReport1.verifyResourceReportMenuPage()
				.clickOnStatewideResourceDetails()
				.verifyStatewideResourceDetailReportPage()
				.selectStandardResources(strStdResourceValue)
				.clickOnNextButtonInResourceDetailPage()
				.selectStandardStatus(strStdStatusValue);
		Thread.sleep(10000);
		objReport1.clickOnGenerateReportBtn();

		Thread.sleep(20000);
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
				"Statewide Resource Detail Repor", 1, 1, strDownloadName1);
		assertEquals(objReport_data.strStatewideResourceDetailReport, strValue);

		int intRowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, "Statewide Resource Detail Repor");

		String[] strHeaderNames ={ "Region", "Resource Name", "Type",
				"Address", "County", "Latitude", "Longitude",
				"EMResource ID", "AHA ID", "External ID", "Website",
				"Contact", "Phone 1", "Phone 2", "Fax", "Email",
				"Notes", "Bed Availability: Adult ICU", 
				"File Number", "FL: Active"};

		String[] strAnswers = {
				objLogin_data.strRegionName4,
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStreetAddress + ", "
						+ objResource_data.strCity + ", "
						+ objResource_data.strCaliforniaCode + " "
						+ objResource_data.strZipcode + "",
				objResource_data.strCounty, strLogitude, strLatitude, "", "",
				"", "", "FN LN", "", "", "", "", "", "6",objView_data.strValueForUpdate+"; "+objView_data.strValueForUpdate1+"; "+objView_data.strValueForUpdate2,
				objStatuTypes_data.strStatusNameInMulti+"; "+objStatuTypes_data.strStatusNameInMulti2+"; "+objStatuTypes_data.strStatusNameInMulti1};

		for (int i = 1; i <= strHeaderNames.length; i++) {
			strValue = objOffCommonFunc.readInfoExcel(
					"Statewide Resource Detail Repor", 2, i, strDownloadName1);
			assertEquals(strHeaderNames[i - 1], strValue);
		}
		System.out.println(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName1);

		String strRes1 = objResource_data.strResourceName;
		String strRes2 = objResource_data.strResourceName1;
		int intcnt = 0;
		for (int i = intRowCount; i <= intRowCount; i--) {
			if (i != 0) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Statewide Resource Detail Repor", i, 2,
						strDownloadName1);
				if (strValue.contains(strRes1) || strValue.contains(strRes2)) {
					for (int j = 1; j <= strAnswers.length; j++) {
						strValue = objOffCommonFunc.readInfoExcel(
								"Statewide Resource Detail Repor", i, j,
								strDownloadName1);
						System.out.println(strValue);
						System.out.println(strAnswers[j - 1]);
						if(j==strAnswers.length){
							assertTrue(strValue.contains(objStatuTypes_data.strStatusNameInMulti));	
							assertTrue(strValue.contains(objStatuTypes_data.strStatusNameInMulti1));	
							assertTrue(strValue.contains(objStatuTypes_data.strStatusNameInMulti2));	
						}
						else if(j==(strAnswers.length-1)){
							assertTrue(strValue.contains(objView_data.strValueForUpdate));	
							assertTrue(strValue.contains(objView_data.strValueForUpdate1));	
							assertTrue(strValue.contains(objView_data.strValueForUpdate2));	
						}
						else{
							assertTrue(strValue.contains(strAnswers[j - 1]));	
						}
						
					}
					
					intcnt++;
				}
			}
			if (intcnt == 1)
				break;
		}
		gstrResult = "PASS";
	}

}
