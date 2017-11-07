package requirementGroup.SettingUpRegions;

import lib.dataObject.Login_data;
import lib.dataObject.Region_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreateRegion extends TestNG_UI_EXTENSIONS {

	public NewCreateRegion() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a region can be created.
	'Precondition:
	'Date	 	 : 01-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a region can be created.")
	public void testHappyDay64786() throws Exception {

		gstrTCID = "64786";
		gstrTO = "Verify that a region can be created.";

		Login_data objLogindata = new Login_data();
		Region_data objRegion_data = new Region_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions = new Regions(this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		String strFilePath = Login_data.strTestDataPath;
		boolean blnTest = false;

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
				.entereViewRefreshIntervalField(objRegion_data.ThreeMinsViewRefreshInterval)
				.clickSaveButton()
				.verRegionInRegionListPage(objRegion_data.strRegionName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objRegion_data.strRegionName);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
		
		 blnTest =true;
		    
		    if (blnTest) {
		
				String[] strTestData = { gstrTCID, objRegion_data.strRegionName};
				
				objOffCommonFunc.writeResultDataToParticularRow(strTestData,
						strFilePath, "Regions", 1);
		    }
	}
	
	/*************************************************************************************
	'Description : Verify that a region can be created providing Interface key. 
	'Precondition:
	'Date	 	 : 01-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a region can be created providing Interface key. ")
	public void testHappyDay64788() throws Exception {

		gstrTCID = "64788";
		gstrTO = "Verify that a region can be created providing Interface key. ";

		Login_data objLogindata = new Login_data();
		Region_data objRegion_data = new Region_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions = new Regions(this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		String strFilePath = Login_data.strTestDataPath;
		boolean blnTest = false;

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
				.provideInterfaceKeyForRegion(objRegion_data.strInterFaceKey)
				.entereViewRefreshIntervalField(objRegion_data.ThreeMinsViewRefreshInterval)
				.clickSaveButton()
				.verRegionInRegionListPage(objRegion_data.strRegionName)
				.clickOnEditRegions(objRegion_data.strRegionName)
				.verifyInterFaceKeyIsDisabeled(objRegion_data.strInterFaceKey);

		objLogin1.clickLogOut();
		
		 blnTest =true;
		    
		    if (blnTest) {
		
				String[] strTestData = { gstrTCID, objRegion_data.strRegionName};
				
				objOffCommonFunc.writeResultDataToParticularRow(strTestData,
						strFilePath, "Regions", 1);
		    }
		gstrResult = "PASS";
	}
}
