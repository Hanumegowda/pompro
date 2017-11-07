package requirementGroup.RegionalInfoDocumentLibrary;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.RegionalInfo_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.RegionalInfo;
import lib.page.SelectRegion;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewDeleteADocument extends TestNG_UI_EXTENSIONS{
	
	public NewDeleteADocument() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************************************************************
	'Description : Verify that a document can be deleted. 	
	'Precondition:
	'Date	 	 : 29-Jun-2015
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a document can be deleted.")
	public void testHappyDay221() throws Exception {

		gstrTCID = "221";
		gstrTO = "Verify that a document can be deleted.";

		Login_data objLogin_data = new Login_data();
		RegionalInfo_data objRegionalInfo_data = new RegionalInfo_data();
		Date_Time_settings objDts = new Date_Time_settings();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigateToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);

		String fileDownloadPath = pathProps
				.getProperty(objRegionalInfo_data.strFileUpload);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strPath = file.toString();

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigateToSubMenus1.navigateToDocumentLibraryInRegionalInfo();

		objRegionalInfo1.clickOnCreateNewFolder()
				.enterFolderName(objRegionalInfo_data.strFolderName)
				.clickOnCreateInAllFoldersRadioBtn();

		objEventManagement1.clickOnSaveButton();

		String strFolderValue = objRegionalInfo1
				.getFolderValue(objRegionalInfo_data.strFolderName);
		
		objRegionalInfo1.verFolderName(objRegionalInfo_data.strFolderName);

		objRegionalInfo1.clickOnAddNewDocument()
				.enterDocumentName(objRegionalInfo_data.strDocumentTitle)
				.clickOnBrowse(strPath).clickOnCreateInAllFoldersRadioBtn();

		objEventManagement1.clickOnSaveButton();

		objRegionalInfo1
				.verifyDocumentName(objRegionalInfo_data.strDocumentTitle);

		String strFetchDateTime = objEventManagement1.getApplicationTime();

		String[] strDate = strFetchDateTime.split(" ");

		String strCurYear = objDts.getTimeOfParticularTimeZone("CST", "yyyy");

		String StrReqDate = strDate[0] + " " + strDate[1] + " " + strCurYear
				+ " " + strDate[2];

		objRegionalInfo1.verifyStartDateAndTimeInDL(objLogin_data.strUserName,
				StrReqDate);

		objRegionalInfo1.deleteDocument(objRegionalInfo_data.strDocumentTitle)
				.verifyDocumentNameNotDisplayed(
						objRegionalInfo_data.strDocumentTitle);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
