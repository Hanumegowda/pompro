package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayCreateOREditRole extends TestNG_UI_EXTENSIONS{

	public HappyDayCreateOREditRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/************************************************************************************
	'Description 	: Verify that 'View Right' and 'Update Right' columns are available 
	                  corresponding to status types on 'Create / Edit' role page.
	'Date 			: 8-May-2015 
	'Author 		: Anitha
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that 'View Right' and 'Update Right' columns are available corresponding "
			+ "to status types on 'Create / Edit' role page.")
	public void testHappyDay160132() throws Exception {

		gstrTCID = "160132";
		gstrTO = "Verify that 'View Right' and 'Update Right' columns are available corresponding to status "
				+ "types on 'Create / Edit' role page.";

		Login_data objTest_data = new Login_data();
		Roles_data objRolesData = new Roles_data();

		Login objLogin1 = new Login(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
	
		System.out.println("---------Precondition ends and test execution starts--------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		// role
		objNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
		
		         .enterRoleName(objRolesData.strRoleName)
		         
		         .verViewRightHeader()
		         
		         .verUpdateRightHeader()
		         
		         .clickOnSaveBtn()
		         
		         .clickOnEditLinkOfRole(objRolesData.strRoleName)
		         
		         .verViewRightHeader()
		         
		         .verUpdateRightHeader()
		         
		         .clickOnSaveBtn();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
