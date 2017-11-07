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

public class HappyDayEMResourceFacilityStatusViewInEICS extends TestNG_UI_EXTENSIONS{

	public HappyDayEMResourceFacilityStatusViewInEICS() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	 * 'Description :Update the statuses of all 4 shared status types in EMR and verify that the updated status is displayed in the 'Facility Status' tab of H-ICS.
	 * 'Precondition : None 
	 * 'Date : 125-Mar-2014 
	 * 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description = "Update the statuses of all 4 shared status types in EMR and verify that the updated status is displayed in the 'Facility Status' tab of H-ICS.")
	public void testHappyDay70487() throws Exception {

		gstrTCID = "70487";
		gstrTO = "Update the statuses of all 4 shared status types in EMR and verify that the updated status is displayed in the 'Facility Status' tab of H-ICS.";

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
		eICSFunction objEICSFunction = new eICSFunction(this.driver1);
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue="";
		String strStatusValue = "";

		UpdateStatus UpdateStatus_page = new UpdateStatus(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		
		Map objMap = new Map(this.driver1);

//		objEICSFunction
//		.launchEICSUrl()
//		.loginToEICS(objTest_data.strEicsAdminUser,
//				objTest_data.strEicsAdminPwd)
//		.navigateToResCreateIncident()
//		.selFacility(objEICS_Data.streICSRegName)
//		.selIrgAndClkNext(objEICS_Data.strIRGName)
//		.provideIncidentDetails(objEICS_Data.strIncidentName,
//				objEICS_Data.strIncidentDesc)
//		.clkOnAllowStateRegToViewInc()
//		.activateIncident()
//		.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
//				objEICS_Data.strIncidentDesc);
//
//		objEICSFunction.logoutWithConfirmation();
//		
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
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);	
		
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

		UpdateStatus_page.enterComments(strstatusTypeValues[0], objView_data.strComment);
		
	    UpdateStatus_page.enterNedocsUpdateValue(strstatusTypeValues[1], objView_data.strValueForNDST);
	    
		UpdateStatus_page.enterComments(strstatusTypeValues[1], objView_data.strComment1);

	    UpdateStatus_page.enterNSTAndTSTUpdateValue(strstatusTypeValues[2], objView_data.strValueForTST);
	    
	    UpdateStatus_page.enterComments(strstatusTypeValues[2], objView_data.strComment2);  
	    
	    UpdateStatus_page.selectMSTUpdateValue(strstatusTypeValues[3], strstatusesValues[0]);
	    
	    UpdateStatus_page.enterComments(strstatusTypeValues[3], objView_data.strComment3);
	    
	    UpdateStatus_page.enterUpdateSSTValues(strstatusTypeValues[4], objView_data.strValueForSST);
	    
	    UpdateStatus_page.enterComments(strstatusTypeValues[4], objView_data.strComment4);
	    
	    UpdateStatus_page.enterNSTAndTSTUpdateValue(strstatusTypeValues[5], objView_data.strDateUpdateValue);
	    
	    UpdateStatus_page.enterComments(strstatusTypeValues[5], objView_data.strComment5);
	    
	    UpdateStatus_page.clickOnSaveButton();
	       
	    String strApplicationDate = objEventManagement.getApplicationTime();
	    
		objEICSFunction1
		.launchEICSUrl()
		.loginToEICS(objTest_data.strEicsAdminUser,
				objTest_data.strEicsAdminPwd)
		.clkOnViewOfIncident("Inc05/09/2016-061234"/*objEICS_Data.strIncidentName*/)
		.verCreatedIncidentDetails("Inc05/09/2016-061234"/*objEICS_Data.strIncidentName*/,
				objEICS_Data.strIncidentDesc)
		.clkOnFacilityStatusTab()
		.switchToFacStatusFrame();
		
	
		String[] strAllStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName};
		

		String[] strUpdatedValues = { objView_data.strValueForUpdate,
				objView_data.strValueForTST,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strUpdatedValForSST, objView_data.strNEDOCValue,
				objView_data.strDateUpdateValue };
		
		String[] strComments = { objView_data.strComment, objView_data.strComment2,
		         objView_data.strComment3, objView_data.strComment4,  objView_data.strComment1,  objView_data.strComment5 };
		
		for(int intCount=0; intCount<=strAllStatusTypeNames.length-1; intCount++){
			objEICSFunction1.verifyupdateValueInIncidentPage(strStatusValue, strAllStatusTypeNames[intCount], strUpdatedValues[intCount], strComments[intCount], strApplicationDate);
		}
		objEICSFunction1.switchToDefaultPage();

		objEICSFunction1.logoutWithConfirmation();
		
		gstrResult = "PASS";
	}

	
	/*************************************************************************************
	 * 'Description		: Update the status of event related status type in EMR and verify that 
	 * 					  the status is updated in the facility status view of HICS.
	 * 'Precondition	: None 
	 * 'Date 			: 25-Mar-2015 
	 * 'Author 			: Pallavi
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description = "Update the status of event related status type in EMR and verify that the status is updated in the "
			+ "	facility status view of HICS.")
	public void testHappyDay70493() throws Exception {

		gstrTCID = "70493";
		gstrTO = "Update the status of event related status type in EMR and verify that the status is updated in the facility "
				+ "status view of HICS.";

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
		EventManagement EventManagement_page = new EventManagement(
				this.driver1);
		
		eICSFunction objEICSFunction1 = new eICSFunction(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Date_Time_settings onjDts = new Date_Time_settings();
		
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[4];
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
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName);

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

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strstatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();
//		objResource.navigateToResourceListPage();
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
											objView_data.strValueForUpdate)
						  .enterComments(strstatusTypeValues[0],
											objView_data.strComment)
						  .selectMSTUpdateValue(strstatusTypeValues[1],
								  			strstatusesValues[0])
						  .enterComments(strstatusTypeValues[1],
											objView_data.strComment1)
						  .enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
								  			objView_data.strValueForTST)
						  .enterComments(strstatusTypeValues[2],
											objView_data.strComment2)
						  .enterUpdateSSTValues(strstatusTypeValues[3],
								  			objView_data.strValueForSST)
				  		  .enterComments(strstatusTypeValues[3],
											objView_data.strComment3)
						  .clickOnSaveButton();
		
		String strApplicationDate = objEventManagement1.getApplicationTime();
		String strTime[]  = strApplicationDate.split(" ");
		String strYear = onjDts.getCurrentDate("yyyy");
		strApplicationDate = strTime[0]+" "+strTime[1]+" "+strYear+" "+strTime[2]+" "+objTest_data.timeZone;
		String[] strUpdatedValues = { objView_data.strValueForUpdate,
				objView_data.strValueForTST,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strUpdatedValForSST };
		
		String[] strComments = { objView_data.strComment, objView_data.strComment2,
								 objView_data.strComment1, objView_data.strComment3 };

		objEICSFunction1
				.launchEICSUrl()
				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
//				.navigateToResCreateIncident()
//				.selFacility(objEICS_Data.streICSRegName)
//				.selIrgAndClkNext(objEICS_Data.strIRGName)
//				.provideIncidentDetails(objEICS_Data.strIncidentName,
//						objEICS_Data.strIncidentDesc)
//				.clkOnAllowStateRegToViewInc()
//				.activateIncident()
//				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
//						objEICS_Data.strIncidentDesc)
				.clkOnViewOfIncident("Inc205/26/2016-043316"/*objEICS_Data.strIncidentName*/)
				.verCreatedIncidentDetails("Inc205/26/2016-043316"/*objEICS_Data.strIncidentName*/,
				objEICS_Data.strIncidentDesc)
				.clkOnFacilityStatusTab()
				.switchToFacStatusFrame();

		System.out.println(objEICS_Data.strIncidentName);
		String[] strAllStatusTypeNames = {
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.streSSTStatusTypeName };

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			System.out.println(i);
			System.out.println("update Value="+strUpdatedValues[i]);
			System.out.println("StatusType Names="+strAllStatusTypeNames[i]);
			System.out.println("Application Time="+strApplicationDate);
			objEICSFunction1.verifyupdateValueInIncidentPage(
					strSectionVal, strAllStatusTypeNames[i],
					strUpdatedValues[i], strComments[i],strApplicationDate);
		}
		
		objEICSFunction1.switchToDefaultPage();

		objEICSFunction1.logoutWithConfirmation();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that the last update time is displayed in Red in the facility status view of eICS, when the status of a resource expires in EMR. 
	'Precondition	: None
	'Date 			: 27-Mar-2014 
	'Author 		: Anil 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that the last update time is displayed in Red in the facility status view of HICS, when the status of a resource expires in EMR.")
	public void testHappyDay70495() throws Exception {

		gstrTCID = "70495";
		gstrTO = "Verify that the last update time is displayed in Red in the facility status view of HICS, when the status of a resource expires in EMR.";

		Login_data objTest_data = new Login_data();
		eICS_Data objEICS_Data = new eICS_Data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();

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

		Map objMap = new Map(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

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
		
		objStatusTypeList
		.createMultiStatusTypesWithExpirationTime(
				objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusExpirationTime)
				
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti1);

		
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

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
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
		
		String strUpdateTime = objEventManagement.getApplicationTime();
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
//				.navigateToResCreateIncident()
//				.selFacility(objEICS_Data.streICSRegName)
//				.selIrgAndClkNext(objEICS_Data.strIRGName)
//				.provideIncidentDetails(objEICS_Data.strIncidentName,
//						objEICS_Data.strIncidentDesc)
//				.clkOnAllowStateRegToViewInc()
//				.activateIncident()
//				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
//						objEICS_Data.strIncidentDesc)
				.clkOnViewOfIncident("Inc205/26/2016-043316"/*objEICS_Data.strIncidentName*/)
				.verCreatedIncidentDetails("Inc205/26/2016-043316"/*objEICS_Data.strIncidentName*/,
				objEICS_Data.strIncidentDesc)
				.clkOnFacilityStatusTab()
				.switchToFacStatusFrame();

		String[] strAllStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};

		Thread.sleep(300000);
		
		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEICSFunction.verifyupdateValueInIncidentPage(
					strSectionVal, strAllStatusTypeNames[i],
					strUpdatedValues[i]);
		}
		
		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEICSFunction.verLastUpdateForExpiredStatusTypes(
					strSectionVal, strAllStatusTypeNames[i], strUpdatedValues[i],strUpdateTime);
		}

		objEICSFunction.switchToDefaultPage();

		objEICSFunction.logoutWithConfirmation();
		
		objLogin.clickLogOut();
		
		gstrResult = "PASS";
	}
}