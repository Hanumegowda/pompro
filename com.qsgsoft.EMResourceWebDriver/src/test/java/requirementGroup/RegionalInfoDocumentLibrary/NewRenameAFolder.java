package requirementGroup.RegionalInfoDocumentLibrary;

import lib.dataObject.Login_data;
import lib.dataObject.RegionalInfo_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.RegionalInfo;
import lib.page.SelectRegion;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewRenameAFolder extends TestNG_UI_EXTENSIONS{

	public NewRenameAFolder() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/**********************************************************************************
	'Description : Verify that a folder can be renamed.
	'Date	 	 : 26-June-2014
	'Author		 : Anitha
	'----------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***********************************************************************************/
	
	@Test(description = "Verify that a folder can be renamed.")
	public void testHappyDay200() throws Exception {

		gstrTCID = "200";
		gstrTO = "Verify that a folder can be renamed.";

		Login_data objLogin_data = new Login_data();
		RegionalInfo_data objRegionalInfo_data = new RegionalInfo_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigateToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

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

		objRegionalInfo1.clickOnRename().verSelectFolderScreenIsDisplayed()
				.selFolderForAddDoument(objRegionalInfo_data.strFolderName)
				.clickOnRenameBtn().verEditFolderScreenIsDisplayed()
				.enterFolderName(objRegionalInfo_data.strRenamed);

		objEventManagement1.clickOnSaveButton();

		objRegionalInfo1.verFolderName(objRegionalInfo_data.strRenamed);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
