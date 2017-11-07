package requirementGroup.ManagingViewInterface;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Region_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayManagingViews extends TestNG_UI_EXTENSIONS  {

	public HappyDayManagingViews() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*************************************************************************************
	'Description : Verify that 'View Refresh Interval(minutes):' option is available on 'Edit Region' screen. 
	'Date	 	 : 10-Oct-2015
	'Author		 : Sangappa.K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that 'View Refresh Interval(minutes):' option is available on 'Edit Region' screen.")
	public void testHappyDay164640() throws Exception {

		gstrTCID ="164640";
		gstrTO ="Verify that 'View Refresh Interval(minutes):' option is available on 'Edit Region' screen.";

		Login_data objLogindata = new Login_data();
		Region_data objRegion_data = new Region_data();
		Login objLogin1 = new Login(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Regions objRegions1 = new Regions(this.driver1);
		

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegion1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToRegions();
		
		objRegions1.clickOnEditRegions(objLogindata.strRegionName)
		           .verEditRegiontPageIsDisplayed()
		           .verAndEntereViewRefreshIntervalField(objRegion_data.strViewRefreshInterval)
		           .clickSaveButton()
		           .verRegionInRegionListPage(objLogindata.strRegionName)
		           .clickOnEditRegions(objLogindata.strRegionName)
		           .verViewRefreshIntervalValueRetained(objRegion_data.strViewRefreshInterval)
		           .clickSaveButton();
		objLogin1.clickLogOut();

		  gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that‘View Refresh Interval (minutes):’ field on ‘Edit Region’ screen can only be viewed by 'System Admin. 
	'Date	 	 : 14-Oct-2015
	'Author		 : Sangappa.K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that‘View Refresh Interval (minutes):’ field on ‘Edit Region’ screen can only be viewed by 'System Admin.")
	public void testHappyDay164734() throws Exception {

		gstrTCID ="164734";
		gstrTO ="Verify that‘View Refresh Interval (minutes):’ field on ‘Edit Region’ screen can only be viewed by 'System Admin.";

		Login_data objLogindata = new Login_data();
		Region_data objRegion_data = new Region_data();
		User_data objUser_data = new User_data();
		Login objLogin1 = new Login(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Regions objRegions1 = new Regions(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegion1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToUsers();
		
		UsersList_page1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()		
				.clickallcheckboxes()
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		objNavigationToSubMenus1.navigateToRegions();
		
		objRegions1.clickOnEditRegions(objLogindata.strRegionName)
		           .verEditRegiontPageIsDisplayed()
		           .verAndEntereViewRefreshIntervalField(objRegion_data.strViewRefreshInterval)
		           .clickSaveButton()
		           .verRegionInRegionListPage(objLogindata.strRegionName)
		           .clickOnEditRegions(objLogindata.strRegionName)
		           .verViewRefreshIntervalValueRetained(objRegion_data.strViewRefreshInterval)
		           .clickSaveButton();
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		 objRegionDefault1.selectFrame();
		 objNavigationToSubMenus1.navigateToRegions();
		objRegions1.clickOnEditRegions(objLogindata.strRegionName);
		           Thread.sleep(5000);
		objRegions1 .verEditRegiontPageIsDisplayed()    
		           .verViewRefreshIntervalFieldIsNotPresnt()
	               .clickSaveButton();
		objLogin1.clickLogOut();
		  gstrResult = "PASS";
	}
		
}
