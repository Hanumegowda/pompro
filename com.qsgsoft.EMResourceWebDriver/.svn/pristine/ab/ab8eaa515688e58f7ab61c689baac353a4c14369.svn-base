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

public class HappyDayCreateRegionInterfaceOfTypeGetActiveEvents extends TestNG_UI_EXTENSIONS {

	public HappyDayCreateRegionInterfaceOfTypeGetActiveEvents()
			throws Exception {
	super();}
	
	/****************************************************************************************************************
	'Description : Verify that a region interface of type 'Get Active Events' can be created.
	'Date	 	 : 27-Aug-2015
	'Author		 : Sangappa.k
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/
	@Test(description = "Verify that a region interface of type 'Get Active Events' can be created.")
	public void testHappyDay129484() throws Exception {

		gstrTCID ="129484";
		gstrTO = "Verify that a region interface of type 'Get Active Events' can be created."; 
		
		
		Login_data objLogin_data = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		User_data objUserdata = new User_data();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);
		UsersList objUsersList = new UsersList(driver);

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

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToInterfaces();

		objInterfacesInSetUp1
				.verInterfaceTypeAndDeleteCorrespondingInterface(
						objInterfaceInSetUp_data.strInterfaceType2)
				.verifyInterfaceListScreen()
				.clickOnCreateNewInterfaceBtn()
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType2)
				.clickOnNext()
				.verifyCreateInterfaceScreen()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo);

		System.out.println(objInterfaceInSetUp_data.strInterfaceName);

		objInterfacesInSetUp1
				.verAppropriateInterfaceTypeUnderWSA(
						objInterfaceInSetUp_data.strgetActiveEvents)
				.selActiveChkbox()
				.clickOnSave()
				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strInterfaceType2,
						objInterfaceInSetUp_data.strgetActiveEvents,
						objInterfaceInSetUp_data.strInterfaceActiveStatus)
				.verAppropriateSchemaForInterface(
						objInterfaceInSetUp_data.strSchemaForGetActiveEvents);
		
		objInterfacesInSetUp1
				.clickOnUsersLink(objInterfaceInSetUp_data.strInterfaceName)
				.verWebServiceUserNameUnderRegionInterfaceUsersListPage(
						objUserdata.strNewUserName2);		
				Thread.sleep(8000);
		objInterfacesInSetUp1
				.verNormelUsersNotDispUnderRegionInterfaceUsersListPage(
						objUserdata.strNewUserName1)
				.clickOnSaveOfRegionInterfaceUsersListPge()
				.clickOnParameteresLink(
						objInterfaceInSetUp_data.strInterfaceName)
				.verParameterListForRegionInterfacePage(
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