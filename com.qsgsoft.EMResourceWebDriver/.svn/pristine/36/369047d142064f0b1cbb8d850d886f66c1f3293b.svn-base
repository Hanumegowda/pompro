package requirementGroup.CreatingAndManagingUsers;

import java.io.File;
import java.util.Properties;
import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.Upload_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.Upload;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewImportedNewUserMinimumConfig extends TestNG_UI_EXTENSIONS{

	public NewImportedNewUserMinimumConfig() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*****************************************************************************
	'Description : Verify that default role is not selected for the uploaded user.
	'Date	 	 : 30-Jul-2014
	'Author		 : Anitha
	'-----------------------------------------------------------------------------
	'Modified Date			                        	           Modified By
	'Date					                                       Name
	******************************************************************************/
	@Test(description = "Verify that default role is not selected for the uploaded user.")
	public void testHappyDay127933() throws Exception {

		gstrTCID = "127933";
		gstrTO = "Verify that default role is not selected for the uploaded user.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();
		Upload_data objUpload_data = new Upload_data();
		
		Login objLogin = new Login(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		UsersList objUserList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();
		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		// Create default role
		objRoles.createRole(objRolesData.strRoleName1);

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);

		objRoles.clickOnDefaultLinkOfRole(objRolesData.strRoleName1);

		objLogin.clickLogOut();
System.out.println(objUser_data.strNewUserName);
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

//		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame()/*.clickRegionLink()*/;

//		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);
//
//		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		String[] strTestData1 = { "", "N", "", "", "", "", "", "", "N", "N",
				"", "", "", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);

		objUpload1.clickOnUploadResourceBtn().uploadFile(strFilePath)
				.deselectTestCheckBox().clickOnSaveBtn();

		objUpload1.clickOnUserName(objUser_data.strNewUserName);

		objUserList1.verEditUserPageisDisplayed()
				.verAllViewResReightOptionIsSelected()
				.verifyRoleIsSelected(strRoleValue[0])
				.verifyRoleIsNotSelected(strRoleValue[1]).clickCancelButton();

		objNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnDeleteRole(objRolesData.strRoleName1);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
