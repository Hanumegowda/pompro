package requirementGroup.Credence;

import java.util.Iterator;
import java.util.Set;
import lib.dataObject.CORES_data;
import lib.dataObject.Credence_data;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.CORESFunctions;
import lib.page.CredenceLoginPage;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayLogout extends TestNG_UI_EXTENSIONS {

	public HappyDayLogout() throws Exception {
		super();
	}
	
	/*************************************************************************************
	'Description : Verify that when user logs out from CORES application user should still be able to work with EMResource application 
	'Precondition: 
	'Date        : 06-Nov-2014 
	'Author      : Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that when user logs out from CORES application user should still be able to work with EMResource application")
	public void testHappyDay144902() throws Exception {

		gstrTCID = "144902";
		gstrTO = " Verify that when user logs out from CORES application user should still be able to work with EMResource application";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		CORES_data objCores_data = new CORES_data();
		Credence_data objCredence_data = new Credence_data();

		CORESFunctions objCoresFunctions = new CORESFunctions(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions = new Regions(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		CredenceLoginPage objCredenceLoginPage1 = new CredenceLoginPage(
				this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		CORESFunctions objCoresFunctions1 = new CORESFunctions(this.driver1);
		Login objLogin1 = new Login(this.driver1);

		objCoresFunctions.launchCORESUrl();

		objCoresFunctions.createUser(objCores_data.strCoresUserName,
				objCores_data.strCoresPassword, objCores_data.strCoresPassword,
				objCores_data.strSecretQuestion, objCores_data.strSecretAnswer,
				objCores_data.strFirstName, objCores_data.strLastName,
				objCores_data.strAddressLine, objCores_data.strCity,
				objCores_data.strState, objCores_data.strZipcode,
				objCores_data.strContactMethod,
				objCores_data.strNumberToAttempt1,
				objCores_data.strNumberToAttempt2,
				objCores_data.strNumberToAttempt3,
				objCores_data.strOccupationType, objCores_data.strOccupation,
				objCores_data.strStatusForOccupation);

		System.out.println("Cores username: " + objCores_data.strCoresUserName);

		objCoresFunctions.clickOnAttentionRequiredClosebtn();

		objCoresFunctions.clickOnLogout();

		// login to EMR

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToRegions();

		objRegions.clickOnEditRegions(objTest_data.strRegionName);

		objRegions.selectAccountLinkingCheckbox().clickSaveButton();

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("EMR username: " + objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objCredenceLoginPage1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToLinkMyAccounts();

		objCredenceLoginPage1.enterUserName(objUser_data.strNewUserName)
				.enterPassword(objUser_data.strNewPassword).clickLogin();

		objCredenceLoginPage1.selectLinkTo(objCredence_data.strLinkToCoresDots)
				.enterUserName(objCores_data.strCoresUserName)
				.enterPassword(objCores_data.strCoresPassword)
				.clickOnCreateLink()
				.verCurrentlyLinkedAcc(objCredence_data.strLinkToCoresDots)
				.verCurrentlyLinkedAcc(objCredence_data.strEMResource)
				.clickOnProceedToApplication();

		objRegionDefault1.selectFrame();

		String mainWindowHandle = driver1.getWindowHandle();

		objNavigationToSubMenus1.selectProductUnderAppSwitcher(objCredence_data.strLinkToCoresDots);

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);
				driver1.manage().window().maximize();
			}
		}

		objCoresFunctions1
				.clickOnAttentionRequiredClosebtn()
				.verifyHomePage()
				.clickOnChangeApp()
				.verProductsUnderChangeApp(objCredence_data.strLinkToCoresDots,
						objCredence_data.strEMResource)
				.clickOnLogout();

		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToUsersInfoInPreferences();
		
		objLogin1.clickLogOut();
				
		gstrResult = "PASS";
	}
	/**********************************************************************************
	'Description : Verify that when user logs out of EMResource application user should  
	               still be able to work on CORES application
	'Date        : 20-Oct-2014 
	'Author      : Anitha
	'----------------------------------------------------------------------------------
	'Modified Date			                        	                  Modified By
	'Date					                                              Name
	***********************************************************************************/
	@Test(description = "Verify that when user logs out of EMResource application user should"
			+ " still be able to work on CORES application")
	public void testHappyDay144901() throws Exception {

		gstrTCID = "144901";
		gstrTO = "Verify that when user logs out of EMResource application user should still"
				+ " be able to work on CORES application";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		CORES_data objCores_data = new CORES_data();
		Credence_data objCredence_data = new Credence_data();

		CORESFunctions objCoresFunctions = new CORESFunctions(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		CredenceLoginPage objCredenceLoginPage1 = new CredenceLoginPage(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		CORESFunctions objCoresFunctions1 = new CORESFunctions(this.driver1);

		objCoresFunctions.launchCORESUrl();

		objCoresFunctions.createUser(objCores_data.strCoresUserName,
				objCores_data.strCoresPassword, objCores_data.strCoresPassword,
				objCores_data.strSecretQuestion, objCores_data.strSecretAnswer,
				objCores_data.strFirstName, objCores_data.strLastName,
				objCores_data.strAddressLine, objCores_data.strCity,
				objCores_data.strState, objCores_data.strZipcode,
				objCores_data.strContactMethod,
				objCores_data.strNumberToAttempt1,
				objCores_data.strNumberToAttempt2,
				objCores_data.strNumberToAttempt3,
				objCores_data.strOccupationType, objCores_data.strOccupation,
				objCores_data.strStatusForOccupation);

		System.out.println("Cores username: " + objCores_data.strCoresUserName);

		objCoresFunctions.clickOnAttentionRequiredClosebtn();

		objCoresFunctions.clickOnLogout();

		// login to EMR

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToRegions();

		objRegions.clickOnEditRegions(objTest_data.strRegionName);

		objRegions.selectAccountLinkingCheckbox().clickSaveButton();

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("EMR username: " + objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objCredenceLoginPage1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToLinkMyAccounts();

		objCredenceLoginPage1.enterUserName(objUser_data.strNewUserName)
				.enterPassword(objUser_data.strNewPassword).clickLogin();

		objCredenceLoginPage1.selectLinkTo(objCredence_data.strLinkToCoresDots)
				.enterUserName(objCores_data.strCoresUserName)
				.enterPassword(objCores_data.strCoresPassword)
				.clickOnCreateLink()
				.clickOnProceedToApplication();
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();

		objCoresFunctions1.launchCORESUrl().clickOnLoginInToLinkedAcc()
				.enterUsername(objCores_data.strCoresUserName)
				.enterPassword(objCores_data.strCoresPassword).clickOnLogin();

		String mainWindowHandle = driver1.getWindowHandle();
		
		objCoresFunctions1
				.clickOnAttentionRequiredClosebtn()
				.verifyHomePage()
				.clickOnChangeApp()
			    .clickOnEmresourceUnderChangeApp(objCredence_data.strEMResource);
		
		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();
		
		while (ite.hasNext()){
			String popupHandle = ite.next().toString();
			
			if(!popupHandle.contains(mainWindowHandle)){
				driver1.switchTo().window(popupHandle);
				driver1.manage().window().maximize();
			}
			
		}
		objRegionDefault1.selectFrame()
		
		.verifyRegionDefaultPage();
		
	     driver1.close();
		
		driver1.switchTo().window(mainWindowHandle);
		
		objCoresFunctions1.clickOnMission()
		
		.verifyMissionPage()
		
		.clickOnLogout();
	
		gstrResult = "PASS";
	}
}