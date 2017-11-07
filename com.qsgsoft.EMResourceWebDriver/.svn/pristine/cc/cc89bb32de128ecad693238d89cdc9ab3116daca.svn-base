package requirementGroup.EMResourceIntegartionWithEICS;

import lib.dataObject.Login_data;
import lib.dataObject.OtherRegions_Data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.dataObject.eICS_Data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.Map;
import lib.page.OtherRegions;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;
import lib.page.eICSFunction;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class HappyDaySupportMultipleIncidentsFromEICS2Browsers extends
		TestNG_UI_EXTENSIONSThreeBrowser {

	public HappyDaySupportMultipleIncidentsFromEICS2Browsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	 * 'Description : Verify that changes done for multiple incidents are
	 * reflected on Manual / Auto refresh of view screen. 'Precondition : None
	 * 'Date : 21-Oct-2014 'Author : Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(enabled=false,description = "Verify that changes done for multiple incidents are reflected on Manual / Auto refresh of view screen.")
	public void testHappyDay145716() throws Exception {

		gstrTCID = "145716";
		gstrTO = "Verify that changes done for multiple incidents are reflected on Manual / Auto refresh of view screen.";

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

		Thread.sleep(190000);// Wait for auto refresh

		objRegionDefault1.selectFrame();

		objMap1.verIncidentInViewResourceDetailScreen(
				objEICS_Data.strIncidentName2, objEICS_Data.strIncidentDesc);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objEICSFunction.logoutWithConfirmation();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description : Assign a contact [C1] to ICS position [P1] in multiple
	 * incidents [I1] and verify that the assigned positions are displayed
	 * appropriately for each incident on the ‘View Resource Detail’ page on
	 * manual refresh 'Precondition : None 'Date : 03-Nov-2014 'Author :
	 * Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(enabled=false,description = " Assign a contact [C1] to ICS position [P1] in multiple incidents [I1] and verify that the assigned positions are displayed appropriately for each incident on the ‘View Resource Detail’ page on manual refresh")
	public void testHappyDay145751() throws Exception {

		gstrTCID = "145751";
		gstrTO = " Assign a contact [C1] to ICS position [P1] in multiple incidents [I1] and verify that the assigned positions are displayed appropriately for each incident on the ‘View Resource Detail’ page on manual refresh";

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

	/*************************************************************************************
	 * 'Description : Verify that user in region RG1 can view eICS incident
	 * details of region RG2 when there exists mutual agreement between regions
	 * RG1 and RG2. 'Precondition : None 'Date : 03-Nov-2014 'Author : Sowmya
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description = "Verify that user in region RG1 can view eICS incident details of region RG2 when "
			+ "there exists mutual agreement between regions RG1 and RG2.")
	public void testHappyDay145754() throws Exception {

		gstrTCID = "145754";
		gstrTO = "Verify that user in region RG1 can view eICS incident details of region RG2 when there "
				+ "exists mutual agreement between regions RG1 and RG2.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();
		OtherRegions_Data objOtherRegions_Data = new OtherRegions_Data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		OtherRegions objOtherRegions = new OtherRegions(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners = new LinksAtTopRightCorners(
				this.driver1);
		Map objMap1 = new Map(this.driver1);

		eICSFunction objEICSFunction = new eICSFunction(this.driver2);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strArkansasReg);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewOtherRegView(objTest_data.strStateOfMissouriValue)
				.clickSaveButton();
		
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault.selectFrame();

		objnNavigationToSubMenus
				.navigateToRegUnderOtherRegions(objTest_data.strStateOfMissouri);

		objRegionDefault
				.verifyParticularRegPageIsDisplayed(objTest_data.strStateOfMissouri);

		objOtherRegions.clickOnFacility(objOtherRegions_Data.strFacilityName);

		System.out.println(objUserdata.strNewUserName);

		objEICSFunction
				.launchEICSUrl()
				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
				.navigateToResCreateIncident()
				.selFacility(objEICS_Data.strFacilityName)
				.selIrgAndClkNext(objEICS_Data.strIRGName1)
				.provideIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)
				.clkOnAllowStateRegToViewInc()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc);

		System.out.println(objEICS_Data.strIncidentName);

		objLinksAtTopRightCorners.clickOnRefresh();
		
		objMap1.verIncidentInViewResourceDetailScreen(
				objEICS_Data.strIncidentName, objEICS_Data.strIncidentDesc);

		objRegionDefault.switchToDefaultFrame().selectFrame();

		objLogin.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description : Assign a different contact [C2] to ICS position [P1] in
	 * multiple
	 * 
	 * incidents and verify that the assigned positions are displayed
	 * appropriately for each
	 * 
	 * incident on the ‘View Resource Detail’ page on manual refresh
	 * 'Precondition : None 'Date : 03-Nov-2014 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 * 
	 * 
	 ******************************************************************************************* 
	 */
	@Test(description = "Assign a different contact [C2] to ICS position [P1] in multiple incidents and verify that the assigned positions are displayed appropriately for each incident on the ‘View Resource Detail’ page on manual refresh ")
	public void testHappyDay145752() throws Exception {

		gstrTCID = "145752";
		gstrTO = "Assign a different contact [C2] to ICS position [P1] in multiple incidents and verify that the assigned positions are displayed appropriately for each incident on the ‘View Resource Detail’ page on manual refresh ";

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
		LinksAtTopRightCorners objLinksAtTopRightCorners = new

		LinksAtTopRightCorners(this.driver1);
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

		strResourceValue[0] = objResource.getResourceValue

		(objEICS_Data.strExistingResourceNameForEICS);

		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword,

						objUserdata.strFullName).selectFirstRole()
				.selectViewResourceCheckBox(

				objEICS_Data.strExistingResourceNameForEICS).clickSaveButton();

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
						objEICS_Data.strMidName,

						objEICS_Data.strLastName,
						objEICS_Data.strContactUserId,

						objEICS_Data.strPhNo, objEICS_Data.strEmailID)
				.addOrRemovePositionToContact(objEICS_Data.strPosition);

		Thread.sleep(5000);

		objEICSFunction
				.navigateToContacts()
				.selFacilityOrDomain(

				objEICS_Data.strExistingResourceNameForEICS1)
				.clkOnAddNewContact()
				.addContact(objEICS_Data.strContactName1,
						objEICS_Data.strMidName,

						objEICS_Data.strLastName,
						objEICS_Data.strContactUserId1,

						objEICS_Data.strPhNo, objEICS_Data.strEmailID)
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

		objMap1.verIncidentInViewResourceDetailScreenOne(
				objEICS_Data.strIncidentName,

				objEICS_Data.strIncidentDesc);

		objEICSFunction
				.clkOnICSChartTab()
				.verICSChartPage()
				.selPosition(objEICS_Data.strPosition)
				.clkOnResponseTracker()
				.assignContactToAPositionInResTracker(
						objEICS_Data.strContactName,

						objEICS_Data.strMidName, objEICS_Data.strLastName,

						objEICS_Data.strPosition)
				.verAssignedContact(objEICS_Data.strContactName,
						objEICS_Data.strPosition,

						objEICS_Data.strMidName, objEICS_Data.strLastName)

				.assignContactToAPositionInResTracker(
						objEICS_Data.strContactName1,

						objEICS_Data.strMidName, objEICS_Data.strLastName,

						objEICS_Data.strPosition)

				.verAssignedContact(objEICS_Data.strContactName1,
						objEICS_Data.strPosition,

						objEICS_Data.strMidName,

						objEICS_Data.strLastName).switchToDefaultPage();

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners.clickOnRefresh();

		objRegionDefault1.selectFrame();

		String strContact = objEICS_Data.strContactName + " "
				+ objEICS_Data.strMidName + " " + objEICS_Data.strLastName;

		String strContact1 = objEICS_Data.strContactName1 + " "
				+ objEICS_Data.strMidName + " " + objEICS_Data.strLastName;

		objMap1.verIncidentPosAndContInViewResourceDetailScreen(
				objEICS_Data.strIncidentName, objEICS_Data.strPosition,
				strContact);

		objMap1.verIncidentPosAndContInViewResourceDetailScreen(
				objEICS_Data.strIncidentName, objEICS_Data.strPosition,
				strContact1);

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
				objEICS_Data.strIncidentName2,

				objEICS_Data.strIncidentDesc);

		objEICSFunction
				.clkOnICSChartTab()
				.verICSChartPage()
				.selPosition(objEICS_Data.strPosition1)
				.clkOnResponseTracker()
				.assignContactToAPositionInResTracker(
						objEICS_Data.strContactName,

						objEICS_Data.strMidName, objEICS_Data.strLastName,

						objEICS_Data.strPosition)
				.verAssignedContact(objEICS_Data.strContactName,
						objEICS_Data.strPosition1,

						objEICS_Data.strMidName, objEICS_Data.strLastName)
				.assignContactToAPositionInResTracker(
						objEICS_Data.strContactName1,

						objEICS_Data.strMidName, objEICS_Data.strLastName,

						objEICS_Data.strPosition)
				.verAssignedContact(objEICS_Data.strContactName1,
						objEICS_Data.strPosition1,

						objEICS_Data.strMidName,

						objEICS_Data.strLastName).switchToDefaultPage();

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners.clickOnRefresh();

		objRegionDefault1.selectFrame();

		objMap1.verIncidentPosAndContInViewResourceDetailScreen(
				objEICS_Data.strIncidentName2, objEICS_Data.strPosition1,
				strContact);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objEICSFunction.logoutWithConfirmation();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Unassign a contact [C1] from ICS position [P1] participating in multiple incidents and verify that the unassigned ICS Position is no longer displayed on the ‘View Resource Detail’ page on manual refresh 
	'Precondition	: None
	'Date 			: 05-Nov-2014 
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Unassign a contact [C1] from ICS position [P1] participating in multiple incidents and verify that the unassigned ICS Position is no longer displayed on the ‘View Resource Detail’ page on manual refresh ")
	public void testHappyDay145753() throws Exception {

		gstrTCID = "145753";
		gstrTO = "Unassign a contact [C1] from ICS position [P1] participating in multiple incidents and verify that the unassigned ICS Position is no longer displayed on the ‘View Resource Detail’ page on manual refresh ";

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

		objEICSFunction.switchToDefaultPage();

		objEICSFunction
				.clkOnGeneralInfo()
				.clkOnUnassign()
				.verUnassignPositionWindow(objEICS_Data.strPosition)
				.clkOnYesOfUnassignPositionWindow()
				.verUnAssignedContact(objEICS_Data.strContactName,
						objEICS_Data.strPosition, objEICS_Data.strMidName,
						objEICS_Data.strLastName);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners.clickOnRefresh();

		objRegionDefault1.selectFrame();

		objMap1.verIncidentPosAndContInViewResourceDetailScreenIsNotDisplayed(
				objEICS_Data.strIncidentName2, objEICS_Data.strPosition,
				strContact);

		objEICSFunction.switchToDefaultPage();

		objEICSFunction
				.navigateToHomePageWithConfirmation()
				.clkOnViewOfIncident(objEICS_Data.strIncidentName)
				.clkOnICSChartTab()
				.verICSChartPage()
				.selPosition(objEICS_Data.strPosition)
				.clkOnUnassign()
				.verUnassignPositionWindow(objEICS_Data.strPosition)
				.clkOnYesOfUnassignPositionWindow()
				.verUnAssignedContact(objEICS_Data.strContactName,
						objEICS_Data.strPosition, objEICS_Data.strMidName,
						objEICS_Data.strLastName);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners.clickOnRefresh();

		objRegionDefault1.selectFrame();

		objMap1.verIncidentPosAndContInViewResourceDetailScreenIsNotDisplayed(
				objEICS_Data.strIncidentName, objEICS_Data.strPosition,
				strContact);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objEICSFunction.switchToDefaultPage();

		objEICSFunction.logoutWithConfirmation();

		gstrResult = "PASS";
	}
}