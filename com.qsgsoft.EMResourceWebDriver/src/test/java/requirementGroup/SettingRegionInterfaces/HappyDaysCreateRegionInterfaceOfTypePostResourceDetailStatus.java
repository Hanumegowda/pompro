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

public class HappyDaysCreateRegionInterfaceOfTypePostResourceDetailStatus extends TestNG_UI_EXTENSIONS {

	public HappyDaysCreateRegionInterfaceOfTypePostResourceDetailStatus()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/****************************************************************************************************************
	'Description : Verify that a region interface of type 'Post Resource Detail Status' can be created.
	'Date	 	 : 03-Jun-2015
	'Author		 : Sangappa.k
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/
	@Test(/*invocationCount=3,*/description = "Verify that a region interface of type 'Post Resource Detail Status' can be created.")
	public void testHappyDay94127() throws Exception {

		gstrTCID = "94127";
		gstrTO = "Verify that a region interface of type 'Post Resource Detail Status' can be created."; 
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogin_data = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToInterfaces();
		
		objInterfacesInSetUp
				.verInterfaceTypeAndDeleteCorrespondingInterface(
						objInterfaceInSetUp_data.strInterfaceType10)
				.verifyInterfaceListScreen()
				.clickOnCreateNewInterfaceBtn()
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType10)
				.clickOnNext()
				.verifyCreateInterfaceScreen()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo);

		String strWebServAction = objInterfacesInSetUp.getWebServiceAction();
		System.out.println(strWebServAction);

		objInterfacesInSetUp
				.verAppropriateInterfaceTypeUnderWSA(
						objInterfaceInSetUp_data.strPostResourceDetailStatus)
				.selActiveChkbox()
				.clickOnSave()
				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strInterfaceType10,
						strWebServAction,
						objInterfaceInSetUp_data.strInterfaceActiveStatus)
				.clickOnDelete(objInterfaceInSetUp_data.strInterfaceName);

		objLogin.clickLogOut();
		gstrResult = "PASS";
	}

}
	


