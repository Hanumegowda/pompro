package requirementGroup.SettingUpRoles;

import lib.dataObject.Login_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class TestClass extends TestNG_UI_EXTENSIONS{

	public TestClass() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*******************************************************************************************
	'Description 	: Region data
	'Date 			: 15-June-2014 
	'Author 		: Anitha
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	                  Modified By
	'Date					                                              Name
	********************************************************************************************/
	@Test(description = "Fecthing region Names.")
	public void testHappyDay81344() throws Exception {

		gstrTCID = "81344";
		gstrTO = "Fecthing region Names.";

		Login_data objTest_data = new Login_data();
		boolean bln1 = false;
		boolean bln2 = false;
		boolean bln3 = false;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		for (int i = 0; i < objTest_data.RegionNames.length; i++) {

			objSelectRegion
					.selectRegionAndNavigate(objTest_data.RegionNames[i]);

			objRegionDefault.selectFrame();

			objnNavigationToSubMenus.navigateToStatusTypesInSetup();

			int intCount = objnNavigationToSubMenus.getXpathCount();

			if (intCount < 250) {

				System.out.println(objTest_data.RegionNames[i]);
				if (bln1 == true) {
					bln2 = true;
				}
				if (bln2 == true) {
					bln3 = true;
				}
				if (bln1 == true & bln2 == true & bln3 == true) {
					break;
				}
				bln1 = true;
				bln2 = true;
			}
		}

		objLogin.clickLogOut();

		gstrResult = "PASS";

	}
}
