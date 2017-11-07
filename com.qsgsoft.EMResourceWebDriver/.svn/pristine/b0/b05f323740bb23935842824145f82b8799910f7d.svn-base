package requirementGroup.EMResourceIntegartionWithEICS;

import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.dataObject.eICS_Data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;
import lib.page.eICSFunction;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDaySupportMultipleIncidentsFromEICS extends TestNG_UI_EXTENSIONS{

	public HappyDaySupportMultipleIncidentsFromEICS() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************************************************************************************
	 * 'Description : Verify that a user with 'View Resource' right on resource can view details 
	 *                of multiple incidents under 'Incident Command Section' of EMResource.
	 * 'Date        : 20-Oct-2014 
	 * 'Author      : Anil
	 ******************************************************************************************/

	@Test(description = "Verify that a user with 'View Resource' right on resource can view details"
			+ " of multiple incidents under 'Incident Command Section' of EMResource.")
	public void testHappyDay145709() throws Exception {
		gstrTCID = "145709";
		gstrTO = "Verify that a user with 'View Resource' right on resource can view details of multiple"
				+ " incidents under 'Incident Command Section' of EMResource.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		eICSFunction eICSFunction_page = new eICSFunction(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		Map Map_page1=new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		RegionDefault_page.selectFrame();

		objnNavigationToSubMenus.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.selectViewResourceCheckBox(
						objEICS_Data.strExistingResourceNameForEICS)

				.clickSaveButton();
		
	 System.out.println("-----Precondtion execution ends and execution starts------");

		eICSFunction_page
				.launchEICSUrl()

				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
				// Incident 1
				.navigateToResCreateIncident()

				.selFacility(objEICS_Data.streICSRegName)

				.selIrgAndClkNext(objEICS_Data.strIRGName)

				.provideIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)

				.clkOnAllowStateRegToViewInc()

				.activateIncident()

				// Incident 2
				
				.navigateToHomePageWithConfirmation()
				
				.navigateToResCreateIncident()

				.selFacility(objEICS_Data.streICSRegName)

				.selIrgAndClkNext(objEICS_Data.strIRGName)

				.provideIncidentDetails(objEICS_Data.strIncidentName2,
						objEICS_Data.strIncidentDesc)

				.clkOnAllowStateRegToViewInc()

				.activateIncident()

				// Incident 3
				
				.navigateToHomePageWithConfirmation()
				
				.navigateToResCreateIncident()

				.selFacility(objEICS_Data.streICSRegName)

				.selIrgAndClkNext(objEICS_Data.strIRGName)

				.provideIncidentDetails(objEICS_Data.strIncidentName3,
						objEICS_Data.strIncidentDesc)

				.clkOnAllowStateRegToViewInc()

				.activateIncident();

				Thread.sleep(10000);
//				eICSFunction_page.logoutWithConfirmation();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();
		
        objNavigationToSubmenus1.navigateToMap();
		
		String[] strIncidentNames = {objEICS_Data.strIncidentName, objEICS_Data.strIncidentName2, objEICS_Data.strIncidentName3};
		String[] strIncidentDescriptions = {objEICS_Data.strIncidentDesc, objEICS_Data.strIncidentDesc, objEICS_Data.strIncidentDesc};
		
        Map_page1.selectResourceNameInFindResourceDropdown(objEICS_Data.strExistingResourceNameForEICS)
        
			     .clickOnViewInfoInPopupWindow()
			     
				.verIncidentInViewResourceDetailScreenNew(strIncidentNames,strIncidentDescriptions);

//				.verIncidentInViewResourceDetailScreen(
//						objEICS_Data.strIncidentName2,
//						objEICS_Data.strIncidentDesc)
//
//				.verIncidentInViewResourceDetailScreen(
//						objEICS_Data.strIncidentName3,
//						objEICS_Data.strIncidentDesc);
		
        RegionDefault_Page1.selectFrame();
		
        login_page1.clickLogOut();
        
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that a user with 'View Resource' right on resource can view the eICS incident and its information on 'View Resource Detail' screen.
	'Precondition	: None
	'Date 			: 20-Oct-2014 
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that a user with 'View Resource' right on resource can view the eICS incident and its information on 'View Resource Detail' screen.")
	public void testHappyDay145708() throws Exception {

		gstrTCID = "145708";
		gstrTO = "Verify that a user with 'View Resource' right on resource can view the eICS incident and its information on 'View Resource Detail' screen.";

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
		eICSFunction objEICSFunction = new eICSFunction(this.driver1);

		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);

		/*objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
*/
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
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objEICS_Data.strExistingResourceNameForEICS)
				.verResourceNameInPopupWindow(objEICS_Data.strExistingResourceNameForEICS)
				.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objEICS_Data.strExistingResourceNameForEICS)
				.verIncidentCommandSystemSecIsDisplayed()
				.verIncidentInViewResourceDetailScreen(
						objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	
	
	/*************************************************************************************
	'Description 	: Verify that the changes are reflected on manual refresh of view screens in EMR when multiple Actual incidents are created in eICS selecting the ‘Allow State/Region to view this incident’ checkbox and when the check box is deselected.
	'Precondition	: None
	'Date 			: 20-Oct-2014 
	'Author 		: Anil 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that the changes are reflected on manual refresh of view screens in EMR when multiple Actual incidents are created in eICS selecting the ‘Allow State/Region to view this incident’ checkbox and when the check box is deselected.")
	public void testHappyDay145707() throws Exception {

		gstrTCID = "145707";
		gstrTO = " Verify that the changes are reflected on manual refresh of view screens in EMR when multiple Actual incidents are created in eICS selecting the ‘Allow State/Region to view this incident’ checkbox and when the check box is deselected. ";

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
		eICSFunction objEICSFunction = new eICSFunction(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		Map Map_page1=new Map(this.driver1);
		Map Map_page=new Map(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strResourceValue[] = new String[1];
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();
		Map_page.clickOnRefreshLink();
		objnNavigationToSubMenus.navigateToResourceInSetup();

		strResourceValue[0] = objResource
				.getResourceValue(objEICS_Data.strExistingResourceNameForEICS);

		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objEICS_Data.strExistingResourceNameForEICS)
				.selectRunReportsCheckBox(
						objEICS_Data.strExistingResourceNameForEICS)
				.selectAssociateWithOfResource(
						objEICS_Data.strExistingResourceNameForEICS)
				.clickAdvancedOptionAndExpand()
				.selectOverrideViewingRestrictionOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

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
						objEICS_Data.strIncidentDesc)
						
				.navigateToHomePageWithConfirmation()					
								// Incident 2
				.navigateToResCreateIncident()

				.selFacility(objEICS_Data.streICSRegName)
				.selIrgAndClkNext(objEICS_Data.strIRGName)

				.provideIncidentDetails(objEICS_Data.strIncidentName2,
						objEICS_Data.strIncidentDesc)

				.clkOnAllowStateRegToViewInc()

				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName2,
						objEICS_Data.strIncidentDesc);
				
		System.out
		.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		RegionDefault_Page1.selectFrame();
		
		objnNavigationToSubMenus1.navigateToMap();
		
		Map_page1.selectResourceNameInFindResourceDropdown(objEICS_Data.strExistingResourceNameForEICS)

	     .clickOnViewInfoInPopupWindow();
	    
		String[] strIncidentNames = {objEICS_Data.strIncidentName, objEICS_Data.strIncidentName2};
		String[] strIncidentDescriptions = {objEICS_Data.strIncidentDesc, objEICS_Data.strIncidentDesc};
		
		Map_page1.verIncidentInViewResourceDetailScreenNew(strIncidentNames, strIncidentDescriptions);
		
		objEICSFunction.clickOnEditIncidentButton()
		
		.deselectAllowStateRegToViewIncindentInEditInc()
		
		.clickOnOKButton();
		
		RegionDefault_Page1.selectFrame();
		
		Map_page1.clickOnRefreshLink()
		
	     .verIncidentInViewResourceDetailScreenNotDisplayed(objEICS_Data.strIncidentName2,
					objEICS_Data.strIncidentDesc);
		gstrResult = "PASS";
	}
	

	/*************************************************************************************
	 * 'Description :Update the statuses of all 6 shared status types in EMR and verify that the updated status is displayed for all the incidents under that facility in the 'Facility Status' tab of eICS.  
	 * 'Precondition : None 
	 * 'Date : 11-Nov-2014 
	 * 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description = "Update the statuses of all 6 shared status types in EMR and verify that the updated status is displayed for all the incidents under that facility in the 'Facility Status' tab of eICS. ")
	public void testHappyDay145755() throws Exception {

		gstrTCID = "145755";
		gstrTO = "Update the statuses of all 6 shared status types in EMR and verify that the updated status is displayed for all the incidents under that facility in the 'Facility Status' tab of eICS. ";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		
		ResourceType ResourceType_Page = new ResourceType(this.driver1);		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		eICSFunction objEICSFunction1 = new eICSFunction(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue="";
		String strStatusValue = "";

		UpdateStatus UpdateStatus_page = new UpdateStatus(this.driver1);
		Map objMap = new Map(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();
		
		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton()
				.clickOncustomizeResourceDetailView();
		strStatusValue = objViewsList.getSectionValue(objView_data.strSectionName);
		
		ResourceType_Page.navigateToResourceTypePage();
		
		strResourceTypeValue = ResourceType_Page.getResourceTypeValue(objEICS_Data.strExistingResourceTypeNameForEICS);
		
		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createSharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createSharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName, strResourceTypeValue)
				
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);	
		
		strstatusesValues[0] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);
		
		strstatusesValues[1] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti1);
				
				
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

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
				.selectUpdateStatusOfResource(objEICS_Data.strExistingResourceNameForEICS) 
				.clickSaveButton();
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objEICS_Data.strExistingResourceNameForEICS)
				.verResourceNameInPopupWindow(objEICS_Data.strExistingResourceNameForEICS)
				.clickUpdateStatusInPopupWindow();
				
		for(int intCount = 0; intCount<strstatusTypeValues.length; intCount++){
			UpdateStatus_page.clickOnStatusType(strstatusTypeValues[intCount]);
		}
		
		UpdateStatus_page.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate);
	    
	    UpdateStatus_page.enterNedocsUpdateValue(strstatusTypeValues[1], objView_data.strValueForNDST);
	     
	    UpdateStatus_page.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strValueForTST);
		    
	    UpdateStatus_page.selectMSTUpdateValue(strstatusTypeValues[3], strstatusesValues[0]);
	    
	    UpdateStatus_page.enterUpdateSSTValues(strstatusTypeValues[4], objView_data.strValueForSST);
	    
	    UpdateStatus_page.enterNSTAndTSTUpdateValue(strstatusTypeValues[5], objView_data.strDateUpdateValue);
	    
	    UpdateStatus_page.clickOnSaveButton();
	       
		objEICSFunction1
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
		objEICSFunction1.navigateToHomePage();
		
		objEICSFunction1.clkYesToNavigateHomePage()
			.navigateToResCreateIncident()
		.selFacility(objEICS_Data.streICSRegName)
		.selIrgAndClkNext(objEICS_Data.strIRGName)
		.provideIncidentDetails(objEICS_Data.strIncidentName2,
				objEICS_Data.strIncidentDesc)
		.clkOnAllowStateRegToViewInc()
		.activateIncident()
		.verCreatedIncidentDetails(objEICS_Data.strIncidentName2,
				objEICS_Data.strIncidentDesc)
		.clkOnFacilityStatusTab()
		.switchToFacStatusFrame();
		
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate);

		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strStatusNameInMulti);
	
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strNDSTStatusTypeName, objView_data.strNEDOCValue);
	
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strSSTStatusTypeName, objView_data.strUpdatedValForSST);
	
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strTSTStatusTypeName, objView_data.strValueForTST);
	
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strDateStatusTypeName, objView_data.strDateUpdateValue);
	
		objEICSFunction1.switchToDefaultPage();

		objEICSFunction1.navigateToHomePage();
		
		objEICSFunction1.clkYesToNavigateHomePage();
		
		objEICSFunction1.clkOnViewOfIncident(objEICS_Data.strIncidentName)
		
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc)
		.clkOnFacilityStatusTab()
		.switchToFacStatusFrame();
		
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate);

		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strStatusNameInMulti);
	
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strNDSTStatusTypeName, objView_data.strNEDOCValue);
	
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strSSTStatusTypeName, objView_data.strUpdatedValForSST);
	
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strTSTStatusTypeName, objView_data.strValueForTST);
	
		objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, objStatusTypes_data.strDateStatusTypeName, objView_data.strDateUpdateValue);
	
		objEICSFunction1.switchToDefaultPage();

		objEICSFunction1.logoutWithConfirmation();
		
		gstrResult = "PASS";
	}

	/***************************************************************************************
	 * 'Description  : Update the event related statuses of all 6 shared status types in EMR 
	 *                 and verify that the updated status is displayed for all the incidents
	 *                  under that facility in the 'Facility Status' tab of eICS.   
	 * 'Precondition : None 
	 * 'Date         : 11-Nov-2014 
	 * 'Author       : Anil
	 * '------------------------------------------------------------------------------------
	 * 'Modified Date                                                   Modified By
	 * 'Date                                                           Name
	 ***************************************************************************************/
	@Test(description = "Update the event related statuses of all 6 shared status types in EMR and"
			+ " verify that the updated status is displayed for all the incidents under that facility"
			+ " in the 'Facility Status' tab of eICS. ")
	public void testHappyDay145756() throws Exception {

		gstrTCID = "145756";
		gstrTO = "Update the event related statuses of all 6 shared status types in EMR and verify"
				+ " that the updated status is displayed for all the incidents under that facility in "
				+ "the 'Facility Status' tab of eICS. ";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();

		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		eICSFunction objEICSFunction1 = new eICSFunction(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue = "";
		String strSectionVal = "";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton().clickOncustomizeResourceDetailView();
		strSectionVal = objViewsList
				.getSectionValue(objView_data.strSectionName);

		ResourceType_Page.navigateToResourceTypePage();

		strResourceTypeValue = ResourceType_Page
				.getResourceTypeValue(objEICS_Data.strExistingResourceTypeNameForEICS);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList
				.createEventOnlySharedStatusTypeWithSectionAndRT(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.streMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName, strResourceTypeValue)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

         strstatusesValues[1] = objStatusTypeList
		.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

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
				.selectUpdateStatusOfResource(
						objEICS_Data.strExistingResourceNameForEICS)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainAdHocEventsOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

				.clickOnCreateAdHocEventButton()

				.enterAdHocEventDetails(objEvent_data.strEventName,
						objEvent_data.strEventDescription)

				.clickOnNextButton()

				.selectResource(strResourceValue)

				.clickOnNextButton()

				.selectStatusType(strstatusTypeValues[0])

				.selectStatusType(strstatusTypeValues[1])

				.selectStatusType(strstatusTypeValues[2])

				.selectStatusType(strstatusTypeValues[3])

				.selectStatusType(strstatusTypeValues[4])

				.selectStatusType(strstatusTypeValues[5])

				.clickOnNextButton()

				.clickOnYesButton();

		EventManagement_page1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objViewsList1
				.clickOnUpdateStatus(objEICS_Data.strExistingResourceNameForEICS);

		for (int intCount = 0; intCount < strstatusTypeValues.length; intCount++) {
			UpdateStatus_page1.clickOnStatusType(strstatusTypeValues[intCount]);
		}

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[0]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateValue);

		UpdateStatus_page1.clickOnSaveButton();
		
		String[] strUpdatedValues = { objView_data.strValueForUpdate,
				objView_data.strValueForTST,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strUpdatedValForSST, objView_data.strNEDOCValue,
				objView_data.strDateUpdateValue };

		objEICSFunction1
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
						objEICS_Data.strIncidentDesc)
				.clkOnFacilityStatusTab()
				.switchToFacStatusFrame();

		String[] strAllStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName};

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			System.out.println(i);
			System.out.println("StatusType Name="+strAllStatusTypeNames[i]);
			System.out.println("Updated Values="+strUpdatedValues[i]);
			objEICSFunction1.verifyupdateValueInIncidentPage(
					strSectionVal, strAllStatusTypeNames[i],
					strUpdatedValues[i]);
		}
		
		objEICSFunction1.switchToDefaultPage();
		
		//2nd incident
		objEICSFunction1.navigateToHomePageWithConfirmation()
						.navigateToResCreateIncident()
						.selFacility(objEICS_Data.streICSRegName)
						.selIrgAndClkNext(objEICS_Data.strIRGName)
						.provideIncidentDetails(objEICS_Data.strIncidentName2,
								objEICS_Data.strIncidentDesc)
						.clkOnAllowStateRegToViewInc()
						.activateIncident()
						.verCreatedIncidentDetails(objEICS_Data.strIncidentName2,
										objEICS_Data.strIncidentDesc)
						.clkOnFacilityStatusTab()
						.switchToFacStatusFrame();
		
		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			System.out.println(i);
			System.out.println("StatusType Name="+strAllStatusTypeNames[i]);
			System.out.println("Updated Values="+strUpdatedValues[i]);
			objEICSFunction1.verifyupdateValueInIncidentPage(
					strSectionVal, strAllStatusTypeNames[i],
					strUpdatedValues[i]);
		}
		
		objEICSFunction1.switchToDefaultPage();

		objEICSFunction1.logoutWithConfirmation();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description 	: Verify that the last update time is displayed in Red in the facility status view of eICS, when the status of a resource expires in EMR. 
	'Precondition	: None
	'Date 			: 10-Nov-2014 
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that the last update time is displayed in Red in the facility status view of eICS, when the status of a resource expires in EMR.")
	public void testHappyDay145758() throws Exception {

		gstrTCID = "145758";
		gstrTO = " Verify that the last update time is displayed in Red in the facility status view of eICS, when the status of a resource expires in EMR.";

		Login_data objTest_data = new Login_data();
		eICS_Data objEICS_Data = new eICS_Data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		eICSFunction objEICSFunction = new eICSFunction(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strSectionVal = "";

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton().clickOncustomizeResourceDetailView();
		strSectionVal = objViewsList
				.getSectionValue(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// Share Based statustypes
		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatuTypes_data.strStatusExpirationTime);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatuTypes_data.strStatusExpirationTime);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusTypeWithSection(
						objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createMultiStatusTypesWithExpirationTime(
						objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusExpirationTime)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createMultiStatusTypesWithExpirationTime(
				objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusExpirationTime);
	
       strStatusesValues[1] = objStatusTypeList
		.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.navigateToStatusTypeListNew();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatuTypes_data.strStatusExpirationTime);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatuTypes_data.strStatusExpirationTime);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatuTypes_data.strStatusExpirationTime);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		objResource.navigateToResourceListPage();

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objEICS_Data.strExistingResourceNameForEICS)
				.selectStatusType(strStatusTypeValues).clickOnSaveButton();

		objUsersList.navigateToUsersNew();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objEICS_Data.strExistingResourceNameForEICS)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objEICS_Data.strExistingResourceNameForEICS)
				.clickUpdateStatusInPopupWindow();

		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objUpdateStatus.selectStatusTypes(strStatusTypeValues[i]);
		}

		objUpdateStatus
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForUpdate1)
				.selectMSTUpdateValue(strStatusTypeValues[2],
						strStatusesValues[0])
				.enterUpdateSSTValues(strStatusTypeValues[3],
						objView_data.strValueForSST)
				.enterNedocsUpdateValue(strStatusTypeValues[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();
		
		String strUpdateTime = objEventManagement1.getApplicationTime();
		String updateTimeArr[] = strUpdateTime.split(" ");
		String currentYear = objDts.getCurrentDate("yyyy");
		strUpdateTime = updateTimeArr[0] + " " + updateTimeArr[1] + " " + currentYear + " " + updateTimeArr[2];
		System.out.println(strUpdateTime);

		String[] strUpdatedValues = { objView_data.strValueForUpdate,
				objView_data.strValueForUpdate1,
				objStatuTypes_data.strStatusNameInMulti,
				objView_data.strUpdatedValForSST, objView_data.strNEDOCValue,
				objView_data.strDateUpdateValue };

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
						objEICS_Data.strIncidentDesc)
						
				.navigateToHomePageWithConfirmation()
				.navigateToResCreateIncident()
				.selFacility(objEICS_Data.streICSRegName)
				.selIrgAndClkNext(objEICS_Data.strIRGName)
				.provideIncidentDetails(objEICS_Data.strIncidentName2,
						objEICS_Data.strIncidentDesc)
				.clkOnAllowStateRegToViewInc()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName2,
						objEICS_Data.strIncidentDesc)
						.clkOnFacilityStatusTab()
				.switchToFacStatusFrame();

		Thread.sleep(200000);
		
		String[] strAllStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEICSFunction.verifyupdateValueInIncidentPage(
					strSectionVal, strAllStatusTypeNames[i],
					strUpdatedValues[i]);
		}

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEICSFunction.verLastUpdateForExpiredStatusTypes(
					strSectionVal, strAllStatusTypeNames[i],
					strUpdatedValues[i], strUpdateTime);
		}

		objEICSFunction.switchToDefaultPage();
		
		objEICSFunction.navigateToHomePageWithConfirmation()
		.clkOnViewOfIncident(objEICS_Data.strIncidentName)
			.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)
						.clkOnFacilityStatusTab()
				.switchToFacStatusFrame();	

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEICSFunction.verifyupdateValueInIncidentPage(
					strSectionVal, strAllStatusTypeNames[i],
					strUpdatedValues[i]);
		}

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEICSFunction.verLastUpdateForExpiredStatusTypes(
					strSectionVal, strAllStatusTypeNames[i],
					strUpdatedValues[i], strUpdateTime);
		}

		objEICSFunction.switchToDefaultPage();

		objEICSFunction.logoutWithConfirmation();
		
		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	 * 'Description :Update the statuses of all 6 shared status types in EMR and verify that the updated status is displayed for all the incidents under that facility in the 'Facility Status' tab of eICS.  
	 * 'Precondition : None 
	 * 'Date : 11-Nov-2014 
	 * 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(enabled=false,description = "Update the statuses of all 6 shared status types in EMR and verify that the updated status is displayed for all the incidents under that facility in the 'Facility Status' tab of eICS. ")
	public void testCloseIncident() throws Exception {

		gstrTCID = "145755";
		gstrTO = "Update the statuses of all 6 shared status types in EMR and verify that the updated status is displayed for all the incidents under that facility in the 'Facility Status' tab of eICS. ";

		Login_data objTest_data = new Login_data();

		eICSFunction objEICSFunction1 = new eICSFunction(this.driver1);

	    	
		objEICSFunction1
		.launchEICSUrl()
		.loginToEICS(objTest_data.strEicsAdminUser,
				objTest_data.strEicsAdminPwd);
				
		for(int intCount1 = 0; intCount1<200; intCount1++){
			System.out.println(intCount1);
		objEICSFunction1.verHomePage()
		.clickOnViewLink("Freeman West");
		Thread.sleep(15000);
//				objEICSFunction1.verSummaryPage();

		objEICSFunction1.clickOnEndIncident();

		objEICSFunction1.deselectAndClickOK();
		
		objEICSFunction1.verIncidentIsEnded();
		
		objEICSFunction1.clkOnCloseIncident();

		objEICSFunction1.verCloseIncidentWindow();

		objEICSFunction1.clkYesOnCloseIncidentWindow();
		
		Thread.sleep(60000);
		
		objEICSFunction1.navigateToHomePage();
		
		objEICSFunction1.clkYesToNavigateHomePage();
	    }
		objEICSFunction1.logoutWithConfirmation();
	    
		gstrResult = "PASS";
	}


}