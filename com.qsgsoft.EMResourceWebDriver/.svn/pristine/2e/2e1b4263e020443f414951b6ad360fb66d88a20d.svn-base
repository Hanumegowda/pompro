package requirementGroup.RegionalInfoDocumentLibrary;

import java.io.File;
import java.util.Properties;
import lib.dataObject.Login_data;
import lib.dataObject.RegionalInfo_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.RegionalInfo;
import lib.page.SelectRegion;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseMoveADocument extends TestNG_UI_EXTENSIONS{

	public EdgeCaseMoveADocument() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*******************************************************************************************************
	'Description : Verify that the process of moving a document from one folder to another can be cancelled.
	'Date	 	 : 26-Feb-2015
	'Author		 : Anil
	'-------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************************/
	@Test(description = "Verify that the process of moving a document from one folder to another can be cancelled.")
	public void testEdgeCase220() throws Exception {

		gstrTCID = "220";
		gstrTO = "Verify that the process of moving a document from one folder to another can be cancelled.";
		
		Login_data objLogin_data = new Login_data();
		RegionalInfo_data objRegionalInfo_data = new RegionalInfo_data();	
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
				
		Login objLogin1 = new Login(this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);	
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);	
		NavigationToSubMenus objNavigateToSubMenus1 = new NavigationToSubMenus(this.driver1);
		
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
				.clickOnCreateInAllFoldersRadioBtn().clickOnSaveButton();

		objRegionalInfo1.clickOnCreateNewFolder()
				.enterFolderName(objRegionalInfo_data.strFolderName1)
				.clickOnCreateInAllFoldersRadioBtn().clickOnSaveButton();

		objRegionalInfo1.verFolderName(objRegionalInfo_data.strFolderName1);

		objRegionalInfo1.clickOnAddNewDocument()
				.enterDocumentName(objRegionalInfo_data.strDocumentTitle)
				.clickOnBrowse(strPath).clickOnCreateInAllFoldersRadioBtn()
                .clickOnSaveButton();

		objRegionalInfo1
				.clickOnMoveDocument1(objRegionalInfo_data.strDocumentTitle);

		objRegionalInfo1
				.selectFolderToCreateSubFolder(
						objRegionalInfo_data.strFolderName)
				.clcikOnMoveOfSelectedFolder()
				.verifyDocumentIsMovedToFolder(
						objRegionalInfo_data.strDocumentTitle,
						objRegionalInfo_data.strFolderName)
						
				.clickToExpand(objRegionalInfo_data.strFolderName)
				.clickOnMoveDocument1(objRegionalInfo_data.strDocumentTitle)
				.selectFolderToCreateSubFolder(
						objRegionalInfo_data.strFolderName1)
				.clickOnCancelButton()
				.verifyDocumentIsMovedToFolder(
						objRegionalInfo_data.strDocumentTitle,
						objRegionalInfo_data.strFolderName);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
