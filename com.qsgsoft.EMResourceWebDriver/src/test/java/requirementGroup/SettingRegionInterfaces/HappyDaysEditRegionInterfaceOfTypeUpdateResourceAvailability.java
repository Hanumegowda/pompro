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

public class HappyDaysEditRegionInterfaceOfTypeUpdateResourceAvailability extends TestNG_UI_EXTENSIONS {

	public HappyDaysEditRegionInterfaceOfTypeUpdateResourceAvailability()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/****************************************************************************************************************
	'Description :  Verify that a region interface of type 'Update Resource Availability' can be edited.
	'Date	 	 : 02-Jun-2015
	'Author		 : Sangappa.k
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/
	@Test(/*invocationCount=3,*/description = "Verify that a region interface of type 'Update Resource Availability' can be edited.")
	public void testHappyDay94044() throws Exception {

		gstrTCID = "94044";
		gstrTO = "Verify that a region interface of type 'Update Resource Availability' can be edited."; 
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogin_data = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);
		// ie
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
				  objInterfaceInSetUp_data.strInterfaceType12)
				.verifyInterfaceListScreen()
				.clickOnCreateNewInterfaceBtn()
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType12)
				.clickOnNext()
				.verifyCreateInterfaceScreen()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo);
		
		System.out.println(objInterfaceInSetUp_data.strInterfaceName);		
		String strWebServAction = objInterfacesInSetUp.getWebServiceAction();
		System.out.println(strWebServAction);

		objInterfacesInSetUp
				.verAppropriateInterfaceTypeUnderWSA(
						objInterfaceInSetUp_data.strpostResourceStatus)
				.selActiveChkbox()
				.clickOnSave()
				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strInterfaceType12,
						strWebServAction,
						objInterfaceInSetUp_data.strInterfaceActiveStatus);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToInterfaces();
		
		objInterfacesInSetUp1
				.verifyInterfaceListScreen()

				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strInterfaceType12,
						strWebServAction,
						objInterfaceInSetUp_data.strInterfaceActiveStatus)
						
				.clickOnEditLink(objInterfaceInSetUp_data.strInterfaceName)
				
				.verAppropriateInterfaceTypeUnderWSA(
						objInterfaceInSetUp_data.strpostResourceStatus)		

				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strEditInterfaceName,
						objInterfaceInSetUp_data.strEditInterfaceDesc,
						objInterfaceInSetUp_data.strEditContInfo)
				.selActiveChkbox()
				.clickOnSave()

				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strEditInterfaceName,
						objInterfaceInSetUp_data.strEditInterfaceDesc,
						objInterfaceInSetUp_data.strInterfaceType12,
						strWebServAction,
						objInterfaceInSetUp_data.strInterfaceDisabledStatus)
				
				.clickOnDelete(objInterfaceInSetUp_data.strEditInterfaceName);
		System.out.println(objInterfaceInSetUp_data.strEditInterfaceName);		


		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}

}	
	


