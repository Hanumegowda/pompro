package requirementGroup.SettingUpRegions;

import lib.dataObject.Login_data;
import lib.dataObject.Region_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEdgeCaseCreateRegion extends TestNG_UI_EXTENSIONS {

	public NewEdgeCaseCreateRegion() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Cancel the process of creating the region and verify that the region is not created.
	'Precondition:
	'Date	 	 : 22-Feb-2016
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Cancel the process of creating the region and verify that the region is not created.")
	public void testEdgeCase2112() throws Exception {

		gstrTCID = "2112";
		gstrTO = "Cancel the process of creating the region and verify that the region is not created.";

		Login_data objLogindata = new Login_data();
		Region_data objRegion_data = new Region_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions = new Regions(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRegions();

		objRegions.clickCreateNewRegionButton().verCreateNewRegionPage()
				.enterRegionName(objRegion_data.strRegionName)
				.selectTimeZone(objRegion_data.strTimezone)
				.enterFirstName(objRegion_data.strFirstName)
				.enterLastName(objRegion_data.strLastName)
				.enterRegionOrg(objRegion_data.strRegionOrg)
				.enterRegionContactAdd(objRegion_data.strRegionContactAdd)
				.enterRegionPhone1(objRegion_data.strRegionPhone1)
				.enterRegionPhone2(objRegion_data.strRegionPhone2)
				.enterRegionFax(objRegion_data.strRegionFax)
				.enterRegionEmail(objRegion_data.strRegionEmail)
				.selectFrequency(objRegion_data.strEmailFrequency)
				.selectAudioAlert(objRegion_data.strAlertFrequency)
				.provideInterfaceKeyForRegion(objRegion_data.strInterFaceKey)
				.enterRegionDomain(objRegion_data.strRegionDomain1)
				.clickCancelButton()
				.verRegionNotInRegionListPage(objRegion_data.strRegionName);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
