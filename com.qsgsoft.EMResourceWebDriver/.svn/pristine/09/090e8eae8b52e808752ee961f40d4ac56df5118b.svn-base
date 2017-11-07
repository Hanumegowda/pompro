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

public class NewEditRegion extends TestNG_UI_EXTENSIONS{

	public NewEditRegion() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/****************************************************************************************
	'Description : Verify that Interface key can be provided while editing a region.
	'Date	 	 : 28-May-2015
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------
	'Modified Date			                        	                          Modified By
	'Date					                                                      Name
	******************************************************************************************/
	@Test(description = "Verify that Interface key can be provided while editing a region.")
	public void testHappyDay108503() throws Exception {

		gstrTCID = "108503";
		gstrTO = "Verify that Interface key can be provided while editing a region.";

		Login_data objLogindata = new Login_data();
		Region_data objRegion_Data=new Region_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		Regions objRegions = new Regions(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRegions();
		
		objRegions.verRegionListPage()
		
		.clickOnEditRegions(objLogindata.strRegionName);

		objRegions.verEditRegiontPageIsDisplayed()

		.provideInterfaceKeyForRegion(objRegion_Data.strInterFaceKey)

		.clickSaveButton()
		
		.verRegionListPage()

		.clickOnEditRegions(objLogindata.strRegionName)

		.verifyInterFaceKeyIsDisabeled(objRegion_Data.strInterFaceKey);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/****************************************************************************************
	'Description : Verify that a region can be edited. 
	'Date	 	 : 28-May-2015
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------
	'Modified Date			                        	                          Modified By
	'Date					                                                      Name
	******************************************************************************************/
	@Test(description = "Verify that a region can be edited.")
	public void testHappyDay64787() throws Exception {

		gstrTCID = "64787";
		gstrTO = "Verify that a region can be edited.";

		Login_data objLogindata = new Login_data();
		Region_data objRegion_Data=new Region_data();
		
		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		Regions objRegions=new Regions(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		Regions objRegions1=new Regions(this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRegions();
		
		objRegions.clickCreateNewRegionButton()
		
//		.clickCreateNewRegionButton()
				.enterRegionName(objRegion_Data.strRegionName)
				.selectTimeZone(objRegion_Data.strEditTimezone)
				.enterFirstName(objRegion_Data.strFirstName)
				.enterLastName(objRegion_Data.strLastName)
				.enterRegionOrg(objRegion_Data.strRegionOrg)
				.enterRegionContactAdd(objRegion_Data.strRegionContactAdd)
				.enterRegionPhone1(objRegion_Data.strRegionPhone1)
				.enterRegionPhone2(objRegion_Data.strRegionPhone2)
				.enterRegionFax(objRegion_Data.strRegionFax)
				.enterRegionEmail(objRegion_Data.strRegionEmail)
				.selectFrequency(objRegion_Data.strEmailFrequency)
				.selectAudioAlert(objRegion_Data.strAlertFrequency)
				.entereViewRefreshIntervalField(objRegion_Data.ThreeMinsViewRefreshInterval)
				.provideInterfaceKeyForRegion(objRegion_Data.strInterFaceKey)
				.enterRegionDomain(objRegion_Data.strRegionDomain1)
				.clickSaveButton()

		.clickOnEditRegions(objLogindata.strRegionName)
		           
		           .verEditRegiontPageIsDisplayed()
		           
		           .clickSaveButton()
		           
		           .clickOnEditRegions(objLogindata.strRegionName);
		
		System.out.println("-------Precondition ends and test execution starts-------");
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToRegions();
		
		objRegions1
				.clickOnEditRegions(objRegion_Data.strRegionName)
				.verRegionDetailsAreRetained(objRegion_Data.strRegionName,
						objRegion_Data.strFirstName,
						objRegion_Data.strLastName,
						objRegion_Data.strRegionOrg,
						objRegion_Data.strRegionContactAdd,
						objRegion_Data.strRegionPhone1,
						objRegion_Data.strRegionPhone2,
						objRegion_Data.strRegionFax,
						objRegion_Data.strRegionEmail,
						objRegion_Data.strRegionDomain1)
				.verifyInterFaceKeyIsDisabeled(objRegion_Data.strInterFaceKey)
				.enterRegionName(objRegion_Data.strEditRegionName)
				.selectTimeZone(objRegion_Data.strTimezone)
				.enterFirstName(objRegion_Data.strEditFirstName)
				.enterLastName(objRegion_Data.strEditLastName)
				.selectFrequency(objRegion_Data.strEditEmailFrequency)
				.selectAudioAlert(objRegion_Data.strEditAlertFrequency)
				.clickSaveButton()
				.verRegionInRegionListPage(objRegion_Data.strEditRegionName)
				.verTimeZoneInRegionListPage(objRegion_Data.strEditRegionName,
						objRegion_Data.strDisplayTimeZone)
				.verDomainInRegionListPage(objRegion_Data.strEditRegionName,
						objRegion_Data.strRegionDomain1)
				.verinterFaceKeyInRegionListPage(
						objRegion_Data.strEditRegionName,
						objRegion_Data.strInterFaceKey);
			
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

}
