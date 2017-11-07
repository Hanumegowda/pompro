package requirementGroup.EMResourceIntegartionWithEICS;

import java.util.concurrent.TimeUnit;

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
import lib.page.Views;
import lib.page.eICSFunction;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class HappyDayHICSIncidentViewInEMResource3Browsers extends TestNG_UI_EXTENSIONSThreeBrowser{

	public HappyDayHICSIncidentViewInEMResource3Browsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/********************************************************************************************************
	 * 'Description 	: Assign a contact [C1] to ICS position [P1] in an incident [I1] and verify that the  
	 *                    assigned position is displayed on the ‘View Resource Detail’ page on manual refresh 
	 * 'Date 			: 24-Mar-2015
	 * 'Author 			: Renushree
	 * '-----------------------------------------------------------------------------------------------------
	 * 'Modified Date                                                               Modified By 
	 * 'Date                                                                        Name
	 ********************************************************************************************************/
	@Test(description = "Assign a contact [C1] to ICS position [P1] in an incident [I1] and verify that the assigned"
			+ " position is displayed on the ‘View Resource Detail’ page on manual refresh.")
	public void testHappyDay70684() throws Exception {

		gstrTCID = "70684";
		gstrTO = "Assign a contact [C1] to ICS position [P1] in an incident [I1] and verify that the assigned"
				+ " position is displayed on the ‘View Resource Detail’ page on manual refresh.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners = new LinksAtTopRightCorners(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Map objMap1 = new Map(this.driver1);		
		eICSFunction objEICSFunction = new eICSFunction(this.driver2);
		
		String strResourceValue[] = new String[1];

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
		
		System.out.println("---------Precondition ends and test execution starts--------");

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

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objEICSFunction.logoutWithConfirmation();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************************************
	 * 'Description 	: Assign a different contact [C2] to ICS position [P1] in an incident [I1] and verify that
	 *                    the assigned position is updated on the ‘View Resource Detail’ page on manual refresh
	 * 'Date 			: 25-Mar-2015
	 * 'Author 			: Renushree
	 * '-----------------------------------------------------------------------------------------------------------
	 * 'Modified Date                                                               Modified By 
	 * 'Date                                                                        Name
	 **************************************************************************************************************/
	@Test(description = "Assign a different contact [C2] to ICS position [P1] in an incident [I1] and verify that the"
			+ " assigned position is updated on the ‘View Resource Detail’ page on manual refresh.")
	public void testHappyDay70685() throws Exception {

		gstrTCID = "70685";
		gstrTO = "Assign a different contact [C2] to ICS position [P1] in an incident [I1] and verify that the assigned"
				+ " position is updated on the ‘View Resource Detail’ page on manual refresh.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();
		String strResourceValue[] = new String[1];

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners = new LinksAtTopRightCorners(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		eICSFunction objEICSFunction = new eICSFunction(this.driver2);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToResourceInSetup();

		strResourceValue[0] = objResource.getResourceValue(objEICS_Data.strExistingResourceNameForEICS);

		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword,objUserdata.strFullName).selectFirstRole()
				.selectViewResourceCheckBox(objEICS_Data.strExistingResourceNameForEICS)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("----------Precondition end and test execution starts--------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(objEICS_Data.strExistingResourceNameForEICS)
			   .verResourceNameInPopupWindow(objEICS_Data.strExistingResourceNameForEICS)
			   .clickOnViewInfoInPopupWindow()
			   .verViewResDetailScreenIsDisplayedWithResName(objEICS_Data.strExistingResourceNameForEICS)
			   .verIncidentCommandSystemSecIsDisplayed();

		objEICSFunction
				.launchEICSUrl()
				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
				.navigateToContacts()
				.selFacilityOrDomain(objEICS_Data.strExistingResourceNameForEICS1)
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
				.selFacilityOrDomain(objEICS_Data.strExistingResourceNameForEICS1)
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
				.provideIncidentDetails(objEICS_Data.strIncidentName,objEICS_Data.strIncidentDesc)
				.clkOnAllowStateRegToViewInc()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc);

		objLinksAtTopRightCorners.clickOnRefresh();

		objMap1.verIncidentInViewResourceDetailScreen(
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

						objEICS_Data.strMidName, objEICS_Data.strLastName);
		
		
		String strContact = objEICS_Data.strContactName + " "
				+ objEICS_Data.strMidName + " " + objEICS_Data.strLastName;

		objMap1.verIncidentPosAndContInViewResourceDetailScreen(
				objEICS_Data.strIncidentName, objEICS_Data.strPosition,
				strContact);
		
		
		objEICSFunction.assignContactToAPositionInResTracker(
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
		
		String strContact1 = objEICS_Data.strContactName1 + " "
				+ objEICS_Data.strMidName + " " + objEICS_Data.strLastName;

		objMap1.verIncidentPosAndContInViewResourceDetailScreen(
				objEICS_Data.strIncidentName, objEICS_Data.strPosition,
				strContact1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objEICSFunction.logoutWithConfirmation();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	:  Verify that the ICS icon is not displayed in view screens of EMR when a test incident is created in H-ICS.
	'Precondition	: None
	'Date 			: 26-Mar-2014 
	'Author 		: Anil 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that the ICS icon is not displayed in view screens of EMR when a test incident is created in H-ICS.")
	public void testHappyDay71790() throws Exception {

		gstrTCID = "71790";
		gstrTO = " Verify that the ICS icon is not displayed in view screens of EMR when a test incident is created in H-ICS.";

		Login_data objTest_data = new Login_data();
		eICS_Data objEICS_Data = new eICS_Data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);

		eICSFunction objEICSFunction = new eICSFunction(this.driver1);
		String strResourceValue[] = new String[1];

		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		Views objViews2 = new Views(this.driver2);
		LinksAtTopRightCorners objLinksAtTopRightCorners2 = new LinksAtTopRightCorners(this.driver2);
		Map objMap2 = new Map(this.driver2);
		
		objEICSFunction
		.launchEICSUrl()
		.loginToEICS(objTest_data.strEicsAdminUser,
				objTest_data.strEicsAdminPwd);
				
		objEICSFunction.verHomePage();
		
		boolean boolVerify = objEICSFunction.verifyFacilityName(objEICS_Data.strExistingResourceNameInEICS2);
		while(boolVerify ==	true){
	
			objEICSFunction.verHomePage()
			
		.clickOnViewLink(objEICS_Data.strExistingResourceNameInEICS2);
		Thread.sleep(15000);

		boolean boolCheck = objEICSFunction.verifyTestIncidentIsDisplayed();
		if(boolCheck == false){
			
		objEICSFunction.clickOnEndIncident();

		objEICSFunction.deselectAndClickOK();
		
		objEICSFunction.verIncidentIsEnded();
		
		objEICSFunction.clkOnCloseIncident();

		objEICSFunction.verCloseIncidentWindow();

		objEICSFunction.clkYesOnCloseIncidentWindow();
		
		Thread.sleep(60000);
		
		objEICSFunction.navigateToHomePage();
		
		objEICSFunction.clkYesToNavigateHomePage();
		
		}

		
		objEICSFunction.verHomePage();
		
		boolVerify = objEICSFunction.verifyFacilityName(objEICS_Data.strExistingResourceNameInEICS2);
		
	    }
		objEICSFunction.logoutWithoutConfirmation();
		
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);
		
		objRegionDefault.selectFrame();
		
		objResource.navigateToResourceListPageNew();
		
		strResourceValue[0] = objResource.getResourceValue(objEICS_Data.strExistingResourceNameForEICS2);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);	

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objRegionDefault1.verEICSIconNotDisplayedInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS2);
		
		objLogin2.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault2.selectFrame();
		
		objSelectRegion2
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);
		
		objRegionDefault2.selectFrame();
		
		objRegionDefault2.verifyRegionDefaultPage();
		
		objViews2
		.clickOnResource(objEICS_Data.strExistingResourceNameForEICS2);

		
		objEICSFunction
		.launchEICSUrl()
		.loginToEICS(objTest_data.strEicsAdminUser,
				objTest_data.strEicsAdminPwd)
		.navigateToResCreateTestIncident()
		.selFacility(objEICS_Data.strExistingResourceNameInEICS2)
		.deselectNotificationCheckBox()
		.selectOneemailNotifyCheckBox()
		.clickOnInitiateTest()
		.verifyTestIncidentFacilityName(objEICS_Data.strExistingResourceNameForEICS2)
		.logoutWithoutConfirmation();
		
		objLinksAtTopRightCorners1.clickOnRefresh();
	
		objRegionDefault1.verEICSIconNotDisplayedInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS2);
		
		objLinksAtTopRightCorners2.clickOnRefresh();
		
		objMap2.verIncidentInViewResourceDetailScreenNotDisplayed();

		objRegionDefault2.switchToDefaultFrame().selectFrame();

		objLogin2.clickLogOut();
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	'Description 	:  Unassign a contact [C1] from ICS position [P1] in an incident [I1] and verify that the unassigned
	                   ICS Position is no longer displayed on the ‘View Resource Detail’ page on manual refresh.
	'Precondition	: None
	'Date 			: 05-Nov-2014 
	'Author 		: Renushree 
	'-------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                            Modified By
	'Date					                                                        Name
	********************************************************************************************************************/
	@Test(description = " Unassign a contact [C1] from ICS position [P1] in an incident [I1] and verify that the"
			+ " unassigned ICS Position is no longer displayed on the ‘View Resource Detail’ page on manual refresh.")
	public void testHappyDay70686() throws Exception {

		gstrTCID = "70686";
		gstrTO = " Unassign a contact [C1] from ICS position [P1] in an incident [I1] and verify that the unassigned"
				+ " ICS Position is no longer displayed on the ‘View Resource Detail’ page on manual refresh.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();
		String strResourceValue[] = new String[1];

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners = new LinksAtTopRightCorners(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Map objMap1 = new Map(this.driver1);	
		eICSFunction objEICSFunction = new eICSFunction(this.driver2);


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
		
		System.out.println("-----------Precondition ends and test execution starts--------");

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

		Thread.sleep(10000);
		
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
		
		String strContact = objEICS_Data.strContactName + " "
				+ objEICS_Data.strMidName + " " + objEICS_Data.strLastName;

		objMap1.verIncidentPosAndContInViewResourceDetailScreenIsNotDisplayed(
				objEICS_Data.strIncidentName, objEICS_Data.strPosition,
				strContact);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objEICSFunction.switchToDefaultPage();

		objEICSFunction.logoutWithConfirmation();

		gstrResult = "PASS";
	}

	/*****************************************************************************************************
	'Description 	: Verify that the changes are reflected on manual refresh of view screens in EMR when 
	                  an Actual incident is created in HICS selecting the ‘Allow State/Region to view this
	                  incident’ checkbox and when the check box is deselected. 
	'Date 			: 20-Oct-2014 
	'Author 		: Anitha
	'-----------------------------------------------------------------------------------------------------
	'Modified Date			                        	                           Modified By
	'Date					                                                       Name
	******************************************************************************************************/
	@Test(description = "Verify that the changes are reflected on manual refresh of view screens in EMR when"
			+ " an Actual incident is created in HICS selecting the ‘Allow State/Region to view this incident’"
			+ " checkbox and when the check box is deselected.")
	public void testHappyDay70676() throws Exception {

		gstrTCID ="70676";
		gstrTO  ="Verify that the changes are reflected on manual refresh of view screens in EMR when"
				+ " an Actual incident is created in HICS selecting the ‘Allow State/Region to view this incident’"
				+ " checkbox and when the check box is deselected.";

		Login_data objTest_data = new Login_data();
		eICS_Data objEICS_Data = new eICS_Data();
		String strResourceValue[] = new String[1];

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		eICSFunction objEICSFunction = new eICSFunction(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		Views objViews2 = new Views(this.driver2);
		LinksAtTopRightCorners objLinksAtTopRightCorners2 = new LinksAtTopRightCorners(this.driver2);
		Map objMap2 = new Map(this.driver2);
			
		objEICSFunction.launchEICSUrl().loginToEICS(
				objTest_data.strEicsAdminUser, objTest_data.strEicsAdminPwd);

		objEICSFunction.verHomePage();

		boolean boolVerify = objEICSFunction
				.verifyFacilityName(objEICS_Data.strExistingResourceNameInEICS3);
		while (boolVerify == true) {

			objEICSFunction.verHomePage()

			.clickOnViewLink(objEICS_Data.strExistingResourceNameInEICS3);
			Thread.sleep(15000);
			
			boolean boolCheck = objEICSFunction.verifyTestIncidentIsDisplayed();
			if(boolCheck == false){

				objEICSFunction.clickOnEndIncident();

				objEICSFunction.deselectAndClickOK();

				objEICSFunction.verIncidentIsEnded();

				objEICSFunction.clkOnCloseIncident();

				objEICSFunction.verCloseIncidentWindow();

				objEICSFunction.clkYesOnCloseIncidentWindow();

				Thread.sleep(60000);

				objEICSFunction.navigateToHomePage();

				objEICSFunction.clkYesToNavigateHomePage();
			}
				objEICSFunction.verHomePage();

			boolVerify = objEICSFunction
					.verifyFacilityName(objEICS_Data.strExistingResourceNameInEICS3);

		}
		objEICSFunction.logoutWithoutConfirmation();

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToResourceInSetup();

		strResourceValue[0] = objResource
				.getResourceValue(objEICS_Data.strExistingResourceNameForEICS3);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		//Browser1
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		Thread.sleep(2000);
		objRegionDefault1.selectFrame();
		
		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);	

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();

		
		//Browser2
		objLogin2.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		Thread.sleep(2000);
		objRegionDefault2.selectFrame();
		
		objSelectRegion2
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);
		
		objRegionDefault2.selectFrame();
		
		objRegionDefault2.verifyRegionDefaultPage();
		
		objViews2
		.clickOnResource(objEICS_Data.strExistingResourceNameForEICS3);
		
		objEICSFunction
				.launchEICSUrl()
				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
				.navigateToResCreateIncident()
				.selFacility(objEICS_Data.strExistingResourceNameInEICS3)
				.selIrgAndClkNext(objEICS_Data.strIRGName1)
				.provideIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)
				.clkOnAllowStateRegToViewInc()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc);
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		Thread.sleep(400);
		
		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS3);
		
		objLinksAtTopRightCorners2.clickOnRefresh();
		Thread.sleep(400);
		
		objMap2.verIncidentCommandSystemSecIsDisplayed();
		
		objEICSFunction.clickOnEditIncidentButton()
		
		.deselectAllowStateRegToViewIncindentInEditInc()
		
		.clickOnOKButton()
		
		.logoutWithoutConfirmation();
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		Thread.sleep(400);
		
		objRegionDefault1.verEICSIconNotDisplayedInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS3);
		
		objLinksAtTopRightCorners2.clickOnRefresh();
		Thread.sleep(400);
		
		objMap2.verIncidentInViewResourceDetailScreenNotPresent();
		
		objLogin2.clickLogOut();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that the changes are reflected on view screens on manual refresh 
					  of EMR when an Actual incident is created in HICS WITHOUT selecting the 
					  visibility checkbox and then selected.
	'Precondition	: None
	'Date 			: 27-Mar-2015 
	'Author 		: Pallavi 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that the changes are reflected on view screens on manual refresh of EMR when an Actual incident"
			+ " is created in HICS WITHOUT selecting the visibility checkbox and then selected.")
	public void testHappyDay70677() throws Exception {

		gstrTCID = "70677";
		gstrTO = "Verify that the changes are reflected on view screens on manual refresh of EMR when an Actual incident is "
				+ "created in HICS WITHOUT selecting the visibility checkbox and then selected.";

		Login_data objTest_data = new Login_data();
		eICS_Data objEICS_Data = new eICS_Data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);

		eICSFunction objEICSFunction = new eICSFunction(this.driver1);
		String strResourceValue[] = new String[1];

		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		Views objViews2 = new Views(this.driver2);
		LinksAtTopRightCorners objLinksAtTopRightCorners2 = new LinksAtTopRightCorners(this.driver2);
		Map objMap2 = new Map(this.driver2);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);
		
		objRegionDefault.selectFrame();
		
		objResource.navigateToResourceListPageNew();
		
		strResourceValue[0] = objResource.getResourceValue(objEICS_Data.strExistingResNameForEICSCoxNorth);

		objLogin.clickLogOut();

		objEICSFunction.launchEICSUrl()
					   .loginToEICS(objTest_data.strEicsAdminUser,
							   objTest_data.strEicsAdminPwd)
					   .verHomePage();
		
		boolean boolVerify = objEICSFunction.verifyFacilityName(objEICS_Data.strExistingResNameInEICSCoxNorth);
		while(boolVerify ==	true){
	
		objEICSFunction.verHomePage()
					   .clickOnViewLink(objEICS_Data.strExistingResNameInEICSCoxNorth);

		Thread.sleep(15000);

		boolean boolCheck = objEICSFunction.verifyIncidentSummaryPageIsDisplayed();
			if(boolCheck == true){
			objEICSFunction.clickOnEndIncident()
						   .deselectAndClickOK()
						   .verIncidentIsEnded()
						   .clkOnCloseIncident()
						   .verCloseIncidentWindow()
						   .clkYesOnCloseIncidentWindow();
	
			Thread.sleep(40000);
			
			objEICSFunction.navigateToHomePage()
						   .clkYesToNavigateHomePage();
			}
		objEICSFunction.verHomePage();
		
		boolVerify = objEICSFunction.verifyFacilityName(objEICS_Data.strExistingResNameInEICSCoxNorth);
		
	    }
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);	

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objRegionDefault1.verEICSIconNotDisplayedInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResNameForEICSCoxNorth);

		objLogin2.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault2.selectFrame().switchToDefaultFrame().selectFrame();
		
		objSelectRegion2
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);	

		objRegionDefault2.selectFrame()
						 .verifyRegionDefaultPage();
		
		objViews2.clickOnResource(objEICS_Data.strExistingResNameForEICSCoxNorth);
		
		objMap2.verIncidentInViewResourceDetailScreenNotPresent();
		
		objEICSFunction.navigateToResCreateIncident()
					   .selFacility(objEICS_Data.strExistingResNameInEICSCoxNorth)
					   .selIrgAndClkNext(objEICS_Data.strIRGName)
					   .provideIncidentDetails(objEICS_Data.strIncidentName,
								objEICS_Data.strIncidentDesc)
					   .deSelAllowStateRegToViewInc()
					   .activateIncident()
					   .verCreatedIncidentDetails(objEICS_Data.strIncidentName,
								objEICS_Data.strIncidentDesc);

		System.out
		.println("-----Precondtion execution ends and execution starts------");

		objLinksAtTopRightCorners1.clickOnRefresh();

		objRegionDefault1.verEICSIconNotDisplayedInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResNameForEICSCoxNorth);

		objMap2.clickOnRefreshLink()
			   .verIncidentInViewResourceDetailScreenNotPresent();

		//Select Allow State/Region visibility
		objEICSFunction.clickOnEditIncidentButton()
					   .selAllowStateRegToViewIncindentInEditInc()
					   .clickOnOKButton();

		objLinksAtTopRightCorners2.clickOnRefresh();

		objMap2.verIncidentInViewResourceDetailScreen(objEICS_Data.strIncidentName,
								objEICS_Data.strIncidentDesc);

		objLinksAtTopRightCorners1.clickOnRefresh();

		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResNameForEICSCoxNorth);

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	:  Verify that the changes are reflected on view screens on auto refresh 
					   of EMR when a Drill incident is created in HICS selecting the visibility
					   checkbox and then deselected.
	'Precondition	: None
	'Date 			: 08-Apr-2015 
	'Author 		: Pallavi 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that the changes are reflected on view screens on auto refresh of EMR when a "
			+ "Drill incident is created in HICS selecting the visibility checkbox and then deselected.")
	public void testHappyDay70689() throws Exception {

		gstrTCID = "70689";
		gstrTO = "Verify that the changes are reflected on view screens on auto refresh of EMR when a Drill incident "
				+ "is created in HICS selecting the visibility checkbox and then deselected.";

		Login_data objTest_data = new Login_data();
		eICS_Data objEICS_Data = new eICS_Data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);

		eICSFunction objEICSFunction = new eICSFunction(this.driver1);
		String strResourceValue[] = new String[1];

		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		Views objViews2 = new Views(this.driver2);
		Map objMap2 = new Map(this.driver2);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);
		
		objRegionDefault.selectFrame();
		
		objResource.navigateToResourceListPageNew();
		
		strResourceValue[0] = objResource.getResourceValue(objEICS_Data.strExistingResNameForEICSCoxNorth);

		objLogin.clickLogOut();

		objEICSFunction.launchEICSUrl()
					   .loginToEICS(objTest_data.strEicsAdminUser,
							   objTest_data.strEicsAdminPwd)
					   .verHomePage();
		
		boolean boolVerify = objEICSFunction.verifyFacilityName(objEICS_Data.strExistingResNameInEICSCoxNorth);
		while(boolVerify ==	true){
	
		objEICSFunction.verHomePage()
					   .clickOnViewLink(objEICS_Data.strExistingResNameInEICSCoxNorth);

		Thread.sleep(15000);

		boolean boolCheck = objEICSFunction.verifyIncidentSummaryPageIsDisplayed();
			if(boolCheck == true){
			objEICSFunction.clickOnEndIncident()
						   .deselectAndClickOK()
						   .verIncidentIsEnded()
						   .clkOnCloseIncident()
						   .verCloseIncidentWindow()
						   .clkYesOnCloseIncidentWindow();
	
			Thread.sleep(40000);
			
			objEICSFunction.navigateToHomePage()
						   .clkYesToNavigateHomePage();
			}
		objEICSFunction.verHomePage();
		
		boolVerify = objEICSFunction.verifyFacilityName(objEICS_Data.strExistingResNameInEICSCoxNorth);
		
	    }
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);	

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objRegionDefault1.verEICSIconNotDisplayedInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResNameForEICSCoxNorth);

		objLogin2.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault2.selectFrame().switchToDefaultFrame().selectFrame();
		
		objSelectRegion2
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);	

		objRegionDefault2.selectFrame()
						 .verifyRegionDefaultPage();
		
		objViews2.clickOnResource(objEICS_Data.strExistingResNameForEICSCoxNorth);
		
		objMap2.verIncidentInViewResourceDetailScreenNotPresent();
		
		objEICSFunction.navigateToResCreateIncident()
					   .selFacility(objEICS_Data.strExistingResNameInEICSCoxNorth)
					   .clkExerciseRadioBtn()
					   .selIrgAndClkNext(objEICS_Data.strIRGName)
					   .provideIncidentDetails(objEICS_Data.strIncidentName,
								objEICS_Data.strIncidentDesc)
					   .clkOnAllowStateRegToViewInc()
					   .activateIncident()
					   .verCreatedIncidentDetails(objEICS_Data.strIncidentName,
								objEICS_Data.strIncidentDesc);

		System.out
		.println("-----Precondtion execution ends and execution starts------");

		//Wait for auto refresh
		TimeUnit.MINUTES.sleep(3);
		
		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
								strResourceValue[0],
								objEICS_Data.strExistingResNameForEICSCoxNorth);
		
		objMap2.verIncidentInViewResourceDetailScreen(objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc);

		//De-Select Allow State/Region visibility
		objEICSFunction.clickOnEditIncidentButton()
					   .deselectAllowStateRegToViewIncindentInEditInc()
					   .clickOnOKButton();

		//Wait for auto refresh
		TimeUnit.MINUTES.sleep(3);
		
		objRegionDefault1.verEICSIconNotDisplayedInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResNameForEICSCoxNorth);

		objMap2.verIncidentInViewResourceDetailScreenNotPresent();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that the changes are reflected on view screens on auto refresh of EMR
			            when a Drill incident is created in HICS WITHOUT selecting the visibility checkbox and then selected. 
	'Precondition	: None
	'Date 			: 08-Apr-2015 
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that the changes are reflected on view screens on auto refresh of EMR "
			+ "when a Drill incident is created in HICS WITHOUT selecting the visibility checkbox and then selected. ")
	public void testHappyDay70690() throws Exception {

		gstrTCID = "70690";
		gstrTO = "Verify that the changes are reflected on view screens on auto refresh of EMR when a Drill incident "
				+ "is created in HICS WITHOUT selecting the visibility checkbox and then selected. ";

		Login_data objTest_data = new Login_data();
		eICS_Data objEICS_Data = new eICS_Data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);

		eICSFunction objEICSFunction = new eICSFunction(this.driver1);
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		Login objLogin2 = new Login(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		Views objViews2 = new Views(this.driver2);
		Map objMap2 = new Map(this.driver2);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objResource.navigateToResourceListPageNew();

		strResourceValue[0] = objResource
				.getResourceValue(objEICS_Data.strExistingResNameForEICSCoxNorth);

		objLogin.clickLogOut();

		objEICSFunction
				.launchEICSUrl()
				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd).verHomePage();

		boolean boolVerify = objEICSFunction
				.verifyFacilityName(objEICS_Data.strExistingResNameInEICSCoxNorth);
		while (boolVerify == true) {

			objEICSFunction.verHomePage().clickOnViewLink(
					objEICS_Data.strExistingResNameInEICSCoxNorth);

			Thread.sleep(15000);

			boolean boolCheck = objEICSFunction
					.verifyIncidentSummaryPageIsDisplayed();
			if (boolCheck == true) {
				objEICSFunction.clickOnEndIncident().deselectAndClickOK()
						.verIncidentIsEnded().clkOnCloseIncident()
						.verCloseIncidentWindow().clkYesOnCloseIncidentWindow();

				Thread.sleep(40000);

				objEICSFunction.navigateToHomePage().clkYesToNavigateHomePage();
			}
			objEICSFunction.verHomePage();

			boolVerify = objEICSFunction
					.verifyFacilityName(objEICS_Data.strExistingResNameInEICSCoxNorth);

		}

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();

		objRegionDefault1.verEICSIconNotDisplayedInRegDefault(
				objEICS_Data.strIconName, strResourceValue[0],
				objEICS_Data.strExistingResNameForEICSCoxNorth);

		objLogin2.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault2.selectFrame().switchToDefaultFrame().selectFrame();

		objSelectRegion2
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault2.selectFrame().verifyRegionDefaultPage();

		objViews2
				.clickOnResource(objEICS_Data.strExistingResNameForEICSCoxNorth);

		objMap2.verIncidentInViewResourceDetailScreenNotPresent();

		objEICSFunction
				.navigateToResCreateIncident()
				.selFacility(objEICS_Data.strExistingResNameInEICSCoxNorth)
				.clkExerciseRadioBtn()
				.selIrgAndClkNext(objEICS_Data.strIRGName)
				.provideIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)
				.deSelAllowStateRegToViewInc()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc);

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		TimeUnit.MINUTES.sleep(3);
		TimeUnit.SECONDS.sleep(10);

		objRegionDefault1.verEICSIconNotDisplayedInRegDefault(
				objEICS_Data.strIconName, strResourceValue[0],
				objEICS_Data.strExistingResNameForEICSCoxNorth);

		objMap2.verIncidentInViewResourceDetailScreenNotPresent();

		// Select Allow State/Region visibility
		objEICSFunction.clickOnEditIncidentButton()
				.selAllowStateRegToViewIncindentInEditInc()
				.clickOnOKButton();

		TimeUnit.MINUTES.sleep(3);
		TimeUnit.SECONDS.sleep(10);

		objMap2.verIncidentInViewResourceDetailScreen(
				objEICS_Data.strIncidentName, objEICS_Data.strIncidentDesc);

		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResNameForEICSCoxNorth);

		gstrResult = "PASS";
	}
}
