package requirementGroup.SettingRegionInterfaces;

import lib.dataObject.InterfaceInSetUp_data;
import lib.dataObject.Login_data;
import lib.module.NavigationToSubMenus;
import lib.page.InterfacesInSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayDeleteRegionInterfaceOfTypeLegacyGetHospitalStatus extends TestNG_UI_EXTENSIONS {
	
	public HappyDayDeleteRegionInterfaceOfTypeLegacyGetHospitalStatus()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************************
	'Description : Verify that a region interface of type 'Legacy Get Hospital status' can be deleted.
	'Date	 	 : 27-Aug-2015
	'Author		 : Sangappa.k
	'-------------------------------------------------------------------------------------------------
	'Modified Date			                                                            Modified By
	'Date					                                                            Name
	**************************************************************************************************/
	@Test(description = "Verify that a region interface of type 'Legacy Get Hospital status' can be deleted.")
	public void testHappyDay129483() throws Exception {

		gstrTCID ="129483";
		gstrTO = "Verify that a region interface of type 'Legacy Get Hospital status' can be deleted."; 
			
		Login_data objLogin_data = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp1 = new InterfacesInSetUp(
				this.driver1);

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToInterfaces();

		objInterfacesInSetUp
				.verInterfaceTypeAndDeleteCorrespondingInterface(
						objInterfaceInSetUp_data.strInterfaceType8)
				.clickOnCreateNewInterfaceBtn()
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType8)
				.clickOnNext()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo)
				.verAppropriateInterfaceTypeUnderWSA(
						objInterfaceInSetUp_data.strgetHospitalStatus)
				.selActiveChkbox()
				.clickOnSave()
				.clickOnParameteresLink(
						objInterfaceInSetUp_data.strInterfaceName)
				.verParameterListForRegionInterfacePage(
						objInterfaceInSetUp_data.strInterfaceName)
				.creatParameterForInterface(
						objInterfaceInSetUp_data.strParaMeterName,
						objInterfaceInSetUp_data.strParameterValue);

       System.out.println(objInterfaceInSetUp_data.strInterfaceName);

		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToInterfaces();

		objInterfacesInSetUp1.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strInterfaceType8,
						objInterfaceInSetUp_data.strgetHospitalStatus,
						objInterfaceInSetUp_data.strInterfaceActiveStatus);		
		
		objInterfacesInSetUp1
				.clickOnParameteresLink(
						objInterfaceInSetUp_data.strInterfaceName)
				.clickOnDeleteLinksForParameter(
						objInterfaceInSetUp_data.strParaMeterName)
				.verParameterNotListed(
						objInterfaceInSetUp_data.strParaMeterName);

		objNavigationToSubmenus1.navigateToInterfaces();

		objInterfacesInSetUp1.clickOnDeleteLinksForInterface(
				objInterfaceInSetUp_data.strInterfaceName)
				.verInterfaceNotListed(
						objInterfaceInSetUp_data.strInterfaceName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
