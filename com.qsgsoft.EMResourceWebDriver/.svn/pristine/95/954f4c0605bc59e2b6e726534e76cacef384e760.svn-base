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

public class HappyDayRegionInterfaceOfTypeChicagoGetHospitalStatus extends TestNG_UI_EXTENSIONS{

	public HappyDayRegionInterfaceOfTypeChicagoGetHospitalStatus()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/************************************************************************************************
	'Description : Verify that a region interface of type 'Chicago Get Hospital Status'can be edited.
	'Date	 	 : 01-June-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that a region interface of type 'Chicago Get Hospital Status'can be edited.")
	public void testHappyDay148731() throws Exception {

		gstrTCID = "148731";
		gstrTO = "Verify that a region interface of type 'Chicago Get Hospital Status'can be edited.";

		Login_data objLogindata = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();

		Login objLogin = new Login(this.driver1);
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

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToInterfaces();
		
		objInterfacesInSetUp.verifyInterfaceListScreen()
				.verInterfaceTypeAndDeleteCorrespondingInterface(
						objInterfaceInSetUp_data.strInterfaceType1);
		
		objInterfacesInSetUp
				.clickOnCreateNewInterfaceBtn()
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType1)
				.clickOnNext()
				.verifyCreateInterfaceScreen()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo)
				.verAppropriateInterfaceTypeUnderWSA(
						objInterfaceInSetUp_data.strgetChicagoStatus)
				.selActiveChkbox()
				.clickOnSave()
				.clickOnParameteresLink(
						objInterfaceInSetUp_data.strInterfaceName)
				.verParameterListForRegionInterfacePage(
						objInterfaceInSetUp_data.strInterfaceName)
				.creatParameterForInterface(
						objInterfaceInSetUp_data.strParaMeterName,
						objInterfaceInSetUp_data.strParameterValue);
		
		objLogin.clickLogOut();
		
		System.out.println(objInterfaceInSetUp_data.strInterfaceName);

		System.out.println("---------Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToInterfaces();
		
		objInterfacesInSetUp1.verifyCreatedInterfaceInList(
				objInterfaceInSetUp_data.strInterfaceName,
				objInterfaceInSetUp_data.strInterfaceDesc,
				objInterfaceInSetUp_data.strInterfaceType1,
				objInterfaceInSetUp_data.strgetChicagoStatus,
				objInterfaceInSetUp_data.strInterfaceActiveStatus);
		
		objInterfacesInSetUp1
				.clickOnEditLink(objInterfaceInSetUp_data.strInterfaceName);
		
		String strWebServAction1 = objInterfacesInSetUp1.getWebServiceAction();
		
		objInterfacesInSetUp1.provideDetailsForInterface(
				objInterfaceInSetUp_data.strInterfaceName1,
				objInterfaceInSetUp_data.strInterfaceDesc1,
				objInterfaceInSetUp_data.strContInfo1).clickOnSave();
		
		objInterfacesInSetUp1
				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName1,
						objInterfaceInSetUp_data.strInterfaceDesc1,
						objInterfaceInSetUp_data.strInterfaceType1,
						strWebServAction1,
						objInterfaceInSetUp_data.strInterfaceActiveStatus)
						
				.clickOnParameteresLink(
						objInterfaceInSetUp_data.strInterfaceName1)
				.verParameterListForRegionInterfacePage(
						objInterfaceInSetUp_data.strInterfaceName1)
				.verParameterIsListed(objInterfaceInSetUp_data.strParaMeterName)
				
				.verifyEditAndDeleteLinksForParameter(
						objInterfaceInSetUp_data.strParaMeterName)
				.clickOnEditLinkOfParameter(
						objInterfaceInSetUp_data.strParaMeterName)
				.entereParameterName(objInterfaceInSetUp_data.strParaMeterName1)
		        .entereParameterValue(objInterfaceInSetUp_data.strParameterValue1)
		        .clickOnSaveOfParametere()
				.verParameterIsListed(
						objInterfaceInSetUp_data.strParaMeterName1)
				.verifyEditAndDeleteLinksForParameter(
						objInterfaceInSetUp_data.strParaMeterName1);
			     			
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************************
	'Description : Verify that a region interface of type 'Chicago Get Hospital Status'can be created.
	'Date	 	 : 15-Oct-2015
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------------------
	'Modified Date			                                                           Modified By
	'Date					                                                                Name
	**************************************************************************************************/
	@Test(description = "Verify that a region interface of type 'Chicago Get Hospital Status'can be created.")
	public void testHappyDay148729() throws Exception {

		gstrTCID ="148729";
		gstrTO = "Verify that a region interface of type 'Chicago Get Hospital Status'can be created."; 
		
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
						objInterfaceInSetUp_data.strInterfaceType1);

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
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType1)
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
						objInterfaceInSetUp_data.strInterfaceType1,
						objInterfaceInSetUp_data.strgetChicagoStatus,
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
						objInterfaceInSetUp_data.strSchemaForgetChicagoStatus);
		
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
	/**************************************************************************************************
	'Description : Verify that a region interface of type 'Chicago Get Hospital Status' can be deleted. 
	'Date	 	 : 27-Aug-2015
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------------------
	'Modified Date			                                                            Modified By
	'Date					                                                            Name
	**************************************************************************************************/
	@Test(description = "Verify that a region interface of type 'Chicago Get Hospital Status' can be deleted.")
	public void testHappyDay148732() throws Exception {

		gstrTCID ="148732";
		gstrTO = "Verify that a region interface of type 'Chicago Get Hospital Status' can be deleted."; 
			
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
						objInterfaceInSetUp_data.strInterfaceType1)
				.clickOnCreateNewInterfaceBtn()
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType1)
				.clickOnNext()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo)
				.verAppropriateInterfaceTypeUnderWSA(
						objInterfaceInSetUp_data.strgetChicagoStatus)
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
						objInterfaceInSetUp_data.strInterfaceType1,
						objInterfaceInSetUp_data.strgetChicagoStatus,
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
