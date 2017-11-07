package requirementGroup.Reports;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.File;
import java.util.Properties;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.FileFormatConverter;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewResourceDetailReport extends TestNG_UI_EXTENSIONS{

	public NewResourceDetailReport() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*************************************************************************************************
	 * 'Description : Verify that user can generate 'Resource Detail report' providing mandatory data.
	 * 'Date        : 25-June-2015 
	 * 'Author      : Anitha
	 *************************************************************************************************/

	@Test(description = "Verify that user can generate 'Resource Detail report' providing mandatory data.")
	public void testHappyDay124624() throws Exception {
		gstrTCID = "124624";
		gstrTO = "Verify that user can generate 'Resource Detail report' providing mandatory data.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		
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
		
		String strDownloadName2 = file + "\\" + "1TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName3 = file + "\\" + "1TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strResourceValue[] = new String[2];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

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
				.clickOnLookupAddressBtn().verMap();

		String strLatitude = objResource_Page.getLatitude();
		String strLongitude = objResource_Page.getLongitude();
		
		System.out.println(strLatitude);
		System.out.println(strLongitude);

		objResource_Page.clickOnSaveButton().clickOnSaveButton();

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);
		
		System.out.println(objResource_data.strResourceName);

		//Resource 2 
		objResource_Page.clickOnCreateNewResourceButton()
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
				.clickOnLookupAddressBtn().verMap();
		
		System.out.println(objResource_data.strResourceName1);

		String strLatitude1 = objResource_Page.getLatitude();
		String strLongitude1 = objResource_Page.getLongitude();
		
		System.out.println(strLatitude1);
		System.out.println(strLongitude1);
		
		objResource_Page.clickOnSaveButton().clickOnSaveButton();

		strResourceValue[1] = objResource_Page
				.getResourceValue(objResource_data.strResourceName1);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMayUpdateRegionSetupInformationOption()
				.clickSaveButton();

		objUsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectRunReportRight(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectEditResourcesOnlyOption()
				.clickSaveButton();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		
		System.out.println("------------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.clickOnResourceReports();

		objReport1.verifyResourceReportMenuPage()
		          .clickOnResourceDetails();
		
		Thread.sleep(10000);
		
		objReport1.verifyResourceDetailReportPage()
				.verifyResourceValueDisplayed(strResourceValue[0])
				.verifyResourceValueDisplayed(strResourceValue[1])
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1])
				.clickOnNextBtn()
		        .selectStatusCheckbox(strStatusTypeValues[0]);
		
		Thread.sleep(10000);

		objReport1.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
		int intCount = 0;
		
		objFileFormatConverter.convertXlsxToXls(strDownloadName, strDownloadName1);
		
		assertTrue(new File(strDownloadName1).exists());

		String strValue = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 1, 1, strDownloadName1);
		
		assertEquals("Resource Detail Report for: "
				+ objTest_data.strRegionName + "", strValue);

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strResDetailRep,
				objStatusTypes_data.strNDSTStatusTypeName);

		String[] strAnswers = {
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStreetAddress + ", "
						+ objResource_data.strCity + ", "
						+ objResource_data.strCaliforniaCode,
				objResource_data.strCounty,
				strLatitude,
				strLongitude,
				strResourceValue[0],
				"--",
				"--",
				"--",
				objResource_data.strResourceFirstName + " "
						+ objResource_data.strResourceLastName, "--", "--",
				"--", "--", "--", "--"};
		
		String[] strAnswers1 = {
				objResource_data.strResourceName1,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStreetAddress + ", "
						+ objResource_data.strCity + ", "
						+ objResource_data.strCaliforniaCode,
				objResource_data.strCounty,
				strLatitude1,
				strLongitude1,
				strResourceValue[1],
				"--",
				"--",
				"--",
				objResource_data.strResourceFirstName + " "
						+ objResource_data.strResourceLastName, "--", "--",
				"--", "--", "--", "--"};
		
		String strValue1="";

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Resource Detail Report",
					2, intCount, strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);


			strValue = objOffCommonFunc.readInfoExcel("Resource Detail Report",
					3, intCount, strDownloadName1);
			
			strValue1 = objOffCommonFunc.readInfoExcel("Resource Detail Report",
					4, intCount, strDownloadName1);

			 if(strHeaderNames[intCount - 1].equals("Longitude")||strHeaderNames[intCount - 1].equals("Latitude")){

				assertTrue(strValue.startsWith(strAnswers[intCount - 1]));
				assertTrue(strValue1.startsWith(strAnswers1[intCount - 1]));
			}
			 else {
					assertTrue(strAnswers[intCount - 1].contains(strValue));
					assertTrue(strAnswers1[intCount - 1].contains(strValue1));
					}
		}
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.clickOnResourceReports();

		objReport1.clickOnResourceDetails();
		
		Thread.sleep(10000);
		
		objReport1.verOnlySingleResIsDisplayed(strResourceValue[1])
				.selectResources(strResourceValue[1])
				.clickOnNextBtn()
				.selectStatusCheckbox(strStatusTypeValues[0]);
		
		Thread.sleep(10000);

		objReport1.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		
		intCount = 0;
		
		objFileFormatConverter.convertXlsxToXls(strDownloadName2, strDownloadName3);
		
		assertTrue(new File(strDownloadName3).exists());
		
		String strValue2 = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 1, 1, strDownloadName3);
		
		assertEquals("Resource Detail Report for: "
				+ objTest_data.strRegionName + "", strValue2);

		String[] strAnswers2 = {
				objResource_data.strResourceName1,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStreetAddress + ", "
						+ objResource_data.strCity + ", "
						+ objResource_data.strCaliforniaCode,
				objResource_data.strCounty,
				strLatitude1,
				strLongitude1,
				strResourceValue[1],
				"--",
				"--",
				"--",
				objResource_data.strResourceFirstName + " "
						+ objResource_data.strResourceLastName, "--", "--",
				"--", "--", "--", "--" };

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			
			strValue2 = objOffCommonFunc.readInfoExcel("Resource Detail Report",
					2, intCount, strDownloadName3);
			

			assertEquals(strHeaderNames[intCount - 1], strValue2);

			strValue2 = objOffCommonFunc.readInfoExcel(
					"Resource Detail Report", 3, intCount, strDownloadName3);
			 if(strHeaderNames[intCount - 1].equals("Longitude")||strHeaderNames[intCount - 1].equals("Latitude")){
				 assertTrue(strValue2.startsWith(strAnswers2[intCount - 1]));		
			}
			else{
				assertTrue(strAnswers2[intCount - 1].contains(strValue2));
			}
		}
		gstrResult = "PASS";
	}
}
