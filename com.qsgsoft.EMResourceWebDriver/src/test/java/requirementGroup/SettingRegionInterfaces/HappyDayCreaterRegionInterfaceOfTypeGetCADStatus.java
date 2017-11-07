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

public class HappyDayCreaterRegionInterfaceOfTypeGetCADStatus extends TestNG_UI_EXTENSIONS {
	public HappyDayCreaterRegionInterfaceOfTypeGetCADStatus() throws Exception {
		super();
	}
	
	/*************************************************************************************
	'Description : Verify that a region interface of type 'Get CAD Status' can be created.
	'Precondition:
	'Date	 	 : 02-June-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a region interface of type 'Get CAD Status' can be created.")
	public void testHappyDay94122() throws Exception {

		gstrTCID = "94122";
		gstrTO = "Verify that a region interface of type 'Get CAD Status' can be created.";

		Login_data objLogindata = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
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
						objInterfaceInSetUp_data.strInterfaceType3);
		objInterfacesInSetUp
				.clickOnCreateNewInterfaceBtn()
				.verifySelInterfaceTypeScreen(strInterfaceTypes)
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType3)
				.clickOnNext()
				.verifyCreateInterfaceScreen()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo)
				.verDefaultTextInWebServicesActionField(
						objInterfaceInSetUp_data.defaultText1);
		String strWebServAction = objInterfacesInSetUp.getWebServiceAction();
		objInterfacesInSetUp
				.verOptionalStatusTypeMappingsFieldIsDisplayed()
				.selActiveChkbox()
				.clickOnSave()
				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strInterfaceType3,
						strWebServAction,
						objInterfaceInSetUp_data.strInterfaceActiveStatus);
		objInterfacesInSetUp
				.verInterfaceTypeAndDeleteCorrespondingInterface(objInterfaceInSetUp_data.strInterfaceType3);
		objLogin.clickLogOut();

		gstrResult = "PASS";
	}

}
