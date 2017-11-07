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

public class EdgeCaseDeleteADocument extends TestNG_UI_EXTENSIONS{

	public EdgeCaseDeleteADocument() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/******************************************************************************
	'Description : Verify that the process of deleting a document can be cancelled.
	'Date	 	 : 26-Feb-2016
	'Author		 : Anitha
	'------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*******************************************************************************/
	@Test(description = "Verify that the process of deleting a document can be cancelled.")
	public void testEdgeCase222() throws Exception {

		gstrTCID = "222";
		gstrTO = "Verify that the process of deleting a document can be cancelled.";

		Login_data objLogin_data = new Login_data();
		RegionalInfo_data objRegionalInfo_data = new RegionalInfo_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		Login objLogin1 = new Login(this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigateToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

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

		objRegionalInfo1.clickOnAddNewDocument()
				.enterDocumentName(objRegionalInfo_data.strDocumentTitle)
				.clickOnBrowse(strPath).clickOnCreateInAllFoldersRadioBtn()
				.clickOnSaveButton()
				.verifyDocumentName(objRegionalInfo_data.strDocumentTitle)
				.cancelDeletingDocument(objRegionalInfo_data.strDocumentTitle)
				.verifyDocumentName(objRegionalInfo_data.strDocumentTitle);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
