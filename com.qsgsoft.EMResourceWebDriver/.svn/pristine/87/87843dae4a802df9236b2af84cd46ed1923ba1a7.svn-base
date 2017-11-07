package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

import lib.dataObject.Login_data;
import lib.dataObject.View_data;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.ViewsList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseManagingRegionViews extends TestNG_UI_EXTENSIONS {

	public EdgeCaseManagingRegionViews() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**************************************************************************************
	'Description 	: Verify that Default View can not be deleted.
	'Date 			: 11-May-2015 
	'Author 		: Anitha
	'--------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***************************************************************************************/
	@Test(description = "Verify that Default View can not be deleted.")
	public void testEdgeCase155986() throws Exception {

		gstrTCID = "155986";
		gstrTO = "Verify that Default View can not be deleted.";

		Login_data objTest_data = new Login_data();
		View_data objView_data = new View_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		
		//RegAdmin

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objViewsList1.navigateToViewsListNew()
		
		             .verCopyAssociatedWithMulRegView(objView_data.strRegionDefaultName)
		             
		             .verEditAssociatedWithMulRegView(objView_data.strRegionDefaultName)
		             
		             .verDeleteLinkNotWithView(objView_data.strRegionDefaultName);
		
		objLogin1.clickLogOut();
				
		gstrResult = "PASS";
	}
}
