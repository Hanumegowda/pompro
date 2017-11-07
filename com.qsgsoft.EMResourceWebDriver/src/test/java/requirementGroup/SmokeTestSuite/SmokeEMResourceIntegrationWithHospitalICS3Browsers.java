package requirementGroup.SmokeTestSuite;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.dataObject.eICS_Data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.SelectRegion;
import lib.page.UsersList;
import lib.page.eICSFunction;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class SmokeEMResourceIntegrationWithHospitalICS3Browsers extends
TestNG_UI_EXTENSIONSThreeBrowser {

	public SmokeEMResourceIntegrationWithHospitalICS3Browsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	 * 'Description 	: Assign a contact [C1] to ICS position [P1] in multiple
	 * 					incidents [I1] and verify that the assigned positions are displayed
	 *	 				appropriately for each incident on the ‘View Resource Detail’ page on
	 * 					manual refresh 
	 * 'Precondition 	: None 
	 * 'Date 			: 21-Nov-2014 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description = "Assign a contact [C1] to ICS position [P1] in multiple incidents [I1] and verify that the assigned positions are displayed appropriately for each incident on the ‘View Resource Detail’ page on manual refresh")
	public void testSmoke129049() throws Exception {

		gstrTCID = "129049";
		gstrTO = "Assign a contact [C1] to ICS position [P1] in multiple incidents [I1] and verify that the assigned positions are displayed appropriately for each incident on the ‘View Resource Detail’ page on manual refresh";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		eICSFunction objEICSFunction = new eICSFunction(this.driver2);

		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners = new LinksAtTopRightCorners(
				this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToResourceInSetup();

		strResourceValue[0] = objResource
				.getResourceValue(objEICS_Data.strExistingResourceNameForEICS);

		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(
						objEICS_Data.strExistingResourceNameForEICS)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objEICS_Data.strExistingResourceNameForEICS)
				.verResourceNameInPopupWindow(
						objEICS_Data.strExistingResourceNameForEICS)
				.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objEICS_Data.strExistingResourceNameForEICS)
				.verIncidentCommandSystemSecIsDisplayed();

		objEICSFunction
				.launchEICSUrl()
				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
				.navigateToContacts()
				.selFacilityOrDomain(
						objEICS_Data.strExistingResourceNameForEICS1)
				.clkOnAddNewContact()
				.addContact(objEICS_Data.strContactName,
						objEICS_Data.strMidName, objEICS_Data.strLastName,
						objEICS_Data.strContactUserId, objEICS_Data.strPhNo,
						objEICS_Data.strEmailID)
				.addOrRemovePositionToContact(objEICS_Data.strPosition)
				.navigateToResCreateIncident()
				.selFacility(objEICS_Data.streICSRegName)
				.selIrgAndClkNext(objEICS_Data.strIRGName)
				.provideIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)
				.clkOnAllowStateRegToViewInc()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc);

		objLinksAtTopRightCorners.clickOnRefresh();

		objMap1.verIncidentInViewResourceDetailScreen(
				objEICS_Data.strIncidentName, objEICS_Data.strIncidentDesc);

		objEICSFunction
				.clkOnICSChartTab()
				.verICSChartPage()
				.selPosition(objEICS_Data.strPosition)
				.clkOnResponseTracker()
				.assignContactToAPositionInResTracker(
						objEICS_Data.strContactName, objEICS_Data.strMidName,
						objEICS_Data.strLastName, objEICS_Data.strPosition)
				.verAssignedContact(objEICS_Data.strContactName,
						objEICS_Data.strPosition, objEICS_Data.strMidName,
						objEICS_Data.strLastName).switchToDefaultPage();

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners.clickOnRefresh();

		objRegionDefault1.selectFrame();

		String strContact = objEICS_Data.strContactName + " "
				+ objEICS_Data.strMidName + " " + objEICS_Data.strLastName;

		objMap1.verIncidentPosAndContInViewResourceDetailScreen(
				objEICS_Data.strIncidentName, objEICS_Data.strPosition,
				strContact);

		objEICSFunction
				.navigateToHomePageWithConfirmation()
				.navigateToResCreateIncident()
				.selFacility(objEICS_Data.streICSRegName)
				.selIrgAndClkNext(objEICS_Data.strIRGName)
				.provideIncidentDetails(objEICS_Data.strIncidentName2,
						objEICS_Data.strIncidentDesc)
				.clkOnAllowStateRegToViewInc()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName2,
						objEICS_Data.strIncidentDesc);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners.clickOnRefresh();

		objRegionDefault1.selectFrame();

		objMap1.verIncidentInViewResourceDetailScreen(
				objEICS_Data.strIncidentName2, objEICS_Data.strIncidentDesc);

		objEICSFunction
				.clkOnICSChartTab()
				.verICSChartPage()
				.selPosition(objEICS_Data.strPosition)
				.clkOnResponseTracker()
				.assignContactToAPositionInResTracker(
						objEICS_Data.strContactName, objEICS_Data.strMidName,
						objEICS_Data.strLastName, objEICS_Data.strPosition)
				.verAssignedContact(objEICS_Data.strContactName,
						objEICS_Data.strPosition, objEICS_Data.strMidName,
						objEICS_Data.strLastName).switchToDefaultPage();

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners.clickOnRefresh();

		objRegionDefault1.selectFrame();

		objMap1.verIncidentPosAndContInViewResourceDetailScreen(
				objEICS_Data.strIncidentName2, objEICS_Data.strPosition,
				strContact);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objEICSFunction.logoutWithConfirmation();

		gstrResult = "PASS";
	}
}
