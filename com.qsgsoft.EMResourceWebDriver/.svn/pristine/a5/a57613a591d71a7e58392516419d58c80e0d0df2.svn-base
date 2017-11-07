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

public class HappyDayEditRegionInterfaceOfTypeLegacyGetHospitalStatus extends TestNG_UI_EXTENSIONS{

	public HappyDayEditRegionInterfaceOfTypeLegacyGetHospitalStatus()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*************************************************************************************************
	'Description : Verify that a region interface of type 'Legacy Get Hospital status' can be edited.
	'Date	 	 : 12-Oct-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************************/
	@Test(description = " Verify that a region interface of type 'Legacy Get Hospital status' can be edited.")
	public void testHappyDay129482() throws Exception {

		gstrTCID = "129482";
		gstrTO = " Verify that a region interface of type 'Legacy Get Hospital status' can be edited.";

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
		EditRegionInterface objEditRegionInterface1 = new EditRegionInterface(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToInterfaces();
		
		objInterfacesInSetUp.verifyInterfaceListScreen()
				.verInterfaceTypeAndDeleteCorrespondingInterface(
						objInterfaceInSetUp_data.strInterfaceType8);
		
		objInterfacesInSetUp
				.clickOnCreateNewInterfaceBtn()
				.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType8)
				.clickOnNext()
				.verifyCreateInterfaceScreen()
				.provideDetailsForInterface(
						objInterfaceInSetUp_data.strInterfaceName,
						objInterfaceInSetUp_data.strInterfaceDesc,
						objInterfaceInSetUp_data.strContInfo)
				.verAppropriateInterfaceTypeUnderWSA(
						objInterfaceInSetUp_data.strgetHospitalStatus)
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
				objInterfaceInSetUp_data.strInterfaceType8,
				objInterfaceInSetUp_data.strgetHospitalStatus,
				objInterfaceInSetUp_data.strInterfaceActiveStatus);
		
		objInterfacesInSetUp1
				.clickOnEditLink(objInterfaceInSetUp_data.strInterfaceName);
		
		objEditRegionInterface1
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
		
		objInterfacesInSetUp1
				.verifyCreatedInterfaceInList(
						objInterfaceInSetUp_data.strInterfaceName1,
						objInterfaceInSetUp_data.strInterfaceDesc1,
						objInterfaceInSetUp_data.strInterfaceType8,
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
}
