package requirementGroup.LoginAndLogout;

import java.util.Iterator;
import java.util.Set;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

	public class NewLoginAndLogout extends TestNG_UI_EXTENSIONS{

	public NewLoginAndLogout() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************************************************************
	'Description : Verify that user can login to EMResource providing valid login credentials 
	'Precondition:
	'Date	 	 : 24-June-2015
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(enabled=false,description = "Verify that user can login to EMResource providing valid login credentials ")
	public void testHappyDay126261() throws Exception {

		gstrTCID = "126261";
		gstrTO = "Verify that user can login to EMResource providing valid login credentials ";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);

		objLogin.loginToApplication(objTest_data.strEicsAdminUser,
				objTest_data.strEicsAdminPwd);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.launchEMRurl().verifyUserName().verPasswordField()
				.verLoginButton().verHelpLink().verIntermedixLink()
			.verCopyRightEdition(objTest_data.strCurrentYear); 

		objLogin1.loginToApplication(objTest_data.strEicsAdminUser,
				objTest_data.strEicsAdminPwd);

		objRegionDefault1.selectFrame();

		objSelectRegion1
				.clickRegionLink()
				.verInstructionInSelectRegPage()
				.verRegionNameField()
				.verNextButton()
				.verEMRBuildAndVersion(objTest_data.strEMRVersion,
						objTest_data.strEMRBuild)
				.verEMRCopyRightTermsAndConditions(objTest_data.strCurrentYear)
				.verEMRLogo().verAppSwitcher();

		objRegionDefault1.verifyUserNameInFooter(objTest_data.strQSGFullName);

		objSelectRegion1.clickOnAppSwitcherAndVerAccManagement()
				.clickOnEMRLogo();

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objSelectRegion1.verTileOfIntermedix();
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);
		
		objRegionDefault1.selectFrame();
		
		objSelectRegion1.clickOnTermsAndConditions();
		
		a = driver1.getWindowHandles();
		ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		
		objSelectRegion1.verTileOfTermsandServiceWin();
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);
		
		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objLogin1.clickLogOut();
		
		gstrResult= "PASS";
	}
}
