package requirementGroup.CreatingAndManagingRegions;

import lib.dataObject.Login_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseManagingRegions  extends TestNG_UI_EXTENSIONS{

	public EdgeCaseManagingRegions() throws Exception 
	{
		super();
	}

	/****************************************************************************************************************
	'Description    : Verify that 'Last Update Years' option is available under 'Available Options' when a region is edited.
	'Date	 	    : 15-September-2015
	'Author		    : Sandhya.M.B
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/
	
	@Test(description = " Verify that 'Last Update Years' option is available under 'Available Options' when a region is edited.")
	public void testEdgeCase166883() throws Exception {

		gstrTCID = "166883";
		gstrTO = " Verify that 'Last Update Years' option is available under 'Available Options' when a region is edited.";
		Login_data objLogin_data = new Login_data();

		Login objLogin1 = new Login(this.driver1);
		
		Regions objRegion1 = new Regions(this.driver1);

		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
	
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);			
	
       	objLogin1.loginToApplication(objLogin_data.strUserName,objLogin_data.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogin_data.strRegionName);
		
    	objRegionDefault1.selectFrame();
    	
   	    objNavigationToSubmenus1.navigateToRegions();
   	    
   	    objRegion1.clickOnEditRegions(objLogin_data.strRegionName);  
   	    
 
   	 objRegion1 .verEditRegiontPageIsDisplayed()
   	            .verLastUpdateYearsChkboxIsPresentAndIsEnabled();
   	    
   	    objLogin1.clickLogOut();
   	 
   	    gstrResult = "PASS";
	}
}
