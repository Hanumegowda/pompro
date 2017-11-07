package requirementGroup.SettingRegionInterfaces;

import lib.dataObject.InterfaceInSetUp_data;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.InterfacesInSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayCreateRegionInterfaceOfTypeLegacyGetHospitalStatus extends TestNG_UI_EXTENSIONS{

	public HappyDayCreateRegionInterfaceOfTypeLegacyGetHospitalStatus()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************************
	'Description : Verify that a region interface of type 'Legacy Get Hospital status' can be created.
	'Date	 	 : 14-Oct-2015
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------------------
	'Modified Date			                                                           Modified By
	'Date					                                                                Name
	**************************************************************************************************/
	@Test(description = "Verify that a region interface of type 'Legacy Get Hospital status' can be created.")
	public void testHappyDay129478() throws Exception {

		gstrTCID ="129478";
		gstrTO = "Verify that a region interface of type 'Legacy Get Hospital status' can be created."; 
		
		Login_data objLogin_data = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(driver);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
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

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToInterfaces();
		
		objInterfacesInSetUp.verifyInterfaceListScreen()
				.verInterfaceTypeAndDeleteCorrespondingInterface(
						objInterfaceInSetUp_data.strInterfaceType8);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterOrganization(objUserdata.strOrganization)
				.selectFirstRole().selectWebServiceChkBox().clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

		objLogin.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToInterfaces();

		objInterfacesInSetUp1
				.clickOnCreateNewInterfaceBtn()
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType8)
				.clickOnNext()
				.verifyCreateInterfaceScreen()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo)
				.selActiveChkbox()
				.clickOnSave()
				
				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strInterfaceType8,
						objInterfaceInSetUp_data.strgetHospitalStatus,
						objInterfaceInSetUp_data.strInterfaceActiveStatus)
				.verifyLinkForInterFace(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strLinkName1)
				.verifyLinkForInterFace(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strLinkName2)
				.verifyLinkForInterFace(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strLinkName3)
				.verifyLinkForInterFace(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strLinkName4)
				.verAppropriateSchemaForInterface(
						objInterfaceInSetUp_data.strSchemaForLegacyHospitalStatus);
		
		objInterfacesInSetUp1
				.clickOnUsersLink(objInterfaceInSetUp_data.strInterfaceName)
				.verWebServiceUserNameUnderRegionInterfaceUsersListPage(
						objUserdata.strNewUserName2)
				.verNormelUsersNotDispUnderRegionInterfaceUsersListPage(
						objUserdata.strNewUserName1)
				.clickOnSaveOfRegionInterfaceUsersListPge()
				
				.clickOnParameteresLink(
						objInterfaceInSetUp_data.strInterfaceName)
				.creatParameterForInterface(
						objInterfaceInSetUp_data.strParaMeterName,
						objInterfaceInSetUp_data.strParameterValue)
				.verCreatedParameterDetailes(
						objInterfaceInSetUp_data.strParaMeterName,
						objInterfaceInSetUp_data.strParameterValue)
				.verEditAndDeleteLinksForParameter(
						objInterfaceInSetUp_data.strParaMeterName);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
