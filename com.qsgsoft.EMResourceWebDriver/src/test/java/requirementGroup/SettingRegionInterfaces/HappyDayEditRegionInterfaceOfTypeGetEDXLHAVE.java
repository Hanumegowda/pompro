package requirementGroup.SettingRegionInterfaces;

import lib.dataObject.InterfaceInSetUp_data;
import lib.dataObject.Login_data;
import lib.module.NavigationToSubMenus;
import lib.page.EditRegionInterface;
import lib.page.InterfacesInSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayEditRegionInterfaceOfTypeGetEDXLHAVE extends TestNG_UI_EXTENSIONS {
	public HappyDayEditRegionInterfaceOfTypeGetEDXLHAVE() throws Exception {
		super();
	}
	
	/*************************************************************************************
	'Description : Verify that a region interface of type 'Get EDXL-HAVE 1.0' can be edited.
	'Precondition:
	'Date	 	 : 01-June-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that a region interface of type 'Get EDXL-HAVE 1.0' can be edited.")
	public void testHappyDay101820() throws Exception {

		gstrTCID = "101820";
		gstrTO = " Verify that a region interface of type 'Get EDXL-HAVE 1.0' can be edited.";

		Login_data objLogindata = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		EditRegionInterface objEditRegionInterface = new EditRegionInterface(
				this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp1 = new InterfacesInSetUp(
				this.driver1);

		String[] strInterfaceTypes = {
				objInterfaceInSetUp_data.strInterfaceType1,
				objInterfaceInSetUp_data.strInterfaceType2,
				objInterfaceInSetUp_data.strInterfaceType3,
				objInterfaceInSetUp_data.strInterfaceType4,
				objInterfaceInSetUp_data.strInterfaceType5,
				objInterfaceInSetUp_data.strInterfaceType6,
				objInterfaceInSetUp_data.strInterfaceType7,
				objInterfaceInSetUp_data.strInterfaceType8,
				objInterfaceInSetUp_data.strInterfaceType9,
				objInterfaceInSetUp_data.strInterfaceType10,
				objInterfaceInSetUp_data.strInterfaceType11,
				objInterfaceInSetUp_data.strInterfaceType12 };

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		objRegionDefault.verifyRegionDefaultPage();

		objNavigationToSubmenus.navigateToInterfaces();
		objInterfacesInSetUp.verifyInterfaceListScreen()
				.verInterfaceTypeAndDeleteCorrespondingInterface(
						objInterfaceInSetUp_data.strInterfaceType4);
		objInterfacesInSetUp
				.clickOnCreateNewInterfaceBtn()
				.verifySelInterfaceTypeScreen(strInterfaceTypes)
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType4)
				.clickOnNext()
				.verifyCreateInterfaceScreen()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo)
				.verDefaultTextInWebServicesActionField(
						objInterfaceInSetUp_data.defaultText);
		String strWebServAction = objInterfacesInSetUp.getWebServiceAction();
		objInterfacesInSetUp
				.verOptionalStatusTypeMappingsFieldIsDisplayed()
				.verCustomStatusTypeMappingsFieldIsDisplayed()
				.selActiveChkbox()
				.clickOnSave()
				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strInterfaceType4,
						strWebServAction,
						objInterfaceInSetUp_data.strInterfaceActiveStatus);
		objLogin.clickLogOut();
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);
		objRegionDefault1.selectFrame();
		objRegionDefault1.verifyRegionDefaultPage();
		objNavigationToSubmenus1.navigateToInterfaces();
		objInterfacesInSetUp1.verifyInterfaceListScreen();
		objInterfacesInSetUp1
				.clickOnEditLink(objInterfaceInSetUp_data.strInterfaceName);
		objEditRegionInterface
				.verNameOfInterfaceInEditRegionInterfacePage(
						objInterfaceInSetUp_data.strInterfaceName)
				.verDescriptionOfInterfaceInEditRegionInterfacePage(
						objInterfaceInSetUp_data.strInterfaceDesc)
				.verContactInformationOfInterfaceInEditRegionInterfacePage(
						objInterfaceInSetUp_data.strContInfo);
		String strWebServAction1 = objInterfacesInSetUp1.getWebServiceAction();
		objInterfacesInSetUp1.provideDetailsForInterface(
				objInterfaceInSetUp_data.strInterfaceName1,
				objInterfaceInSetUp_data.strInterfaceDesc1,
				objInterfaceInSetUp_data.strContInfo1).clickOnSave();
		objInterfacesInSetUp1.verifyCreatedInterfaceInList(
				objInterfaceInSetUp_data.strInterfaceName1,
				objInterfaceInSetUp_data.strInterfaceDesc1,
				objInterfaceInSetUp_data.strInterfaceType4, strWebServAction1,
				objInterfaceInSetUp_data.strInterfaceActiveStatus);
		objInterfacesInSetUp1
				.verInterfaceTypeAndDeleteCorrespondingInterface(objInterfaceInSetUp_data.strInterfaceType4);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
