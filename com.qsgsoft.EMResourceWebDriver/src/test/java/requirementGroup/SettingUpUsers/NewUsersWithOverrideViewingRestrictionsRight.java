package requirementGroup.SettingUpUsers;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewUsersWithOverrideViewingRestrictionsRight extends TestNG_UI_EXTENSIONS{

	public NewUsersWithOverrideViewingRestrictionsRight() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/******************************************************************
	'Description : Verify that user with only ‘Override viewing restrictions’ right can view all the resources in a private event.
	'Precondition:
	'Date	 	 : 20-July-2015
	'Author		 : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user with only ‘Override viewing restrictions’ right can view all the resources in a private event.")
	public void testHappyDay81339() throws Exception {

		gstrTCID = "81339";
		gstrTO = "Verify that user with only ‘Override viewing restrictions’ right can view all the resources in a private event.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		
		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		boolean blnTest = false;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(
				objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);
		objEventSetUp.deselectSelectAllWebOption();
		
		objUsersList
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName1,
				objUser_data.strNewPassword, objUser_data.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();
		
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement();
		objEventManagement.clickOnCreateNewEvent();
		objEventManagement.clickOnCreateEvent(objESetUp_data.strEventTemplate);
		objEventManagement.enterAdHocEventName(
				objEvent_data.strEventName).enterAdHocEventDescription(
				objEvent_data.strEventDescription)
		.clickPrivateCheckBox()
		.selectResource(strResourceValue)
		.clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		String EventStartTime = objEventManagement.getEventStartDateAndTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement.getEventEndTime(objEvent_data.strEventName);
			
		objLogin.clickLogOut();
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objUsersList1
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName)
		.deselectAllViewResReightOption()
		.clickAdvancedOptionAndExpand()
		.selectOverrideViewingRestrictionOption()
		.clickSaveButton();
		
		objUsersList1.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strEquals);
		
		System.out.println(objUser_data.strNewUserName);

		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objTest_data.strPassword,
					objESetUp_data.strEventTemplate ,		
					objEvent_data.strEventName,		
					"Verify mobile end condition",
					
					objStatuTypes_data.strNSTStatusTypeName+", "+
					objStatuTypes_data.strMSTStatusTypeName+", "+
					objStatuTypes_data.strSSTStatusTypeName+", "+
					objStatuTypes_data.strTSTStatusTypeName+", "+
					objStatuTypes_data.strNDSTStatusTypeName+", "+
					objStatuTypes_data.strDateStatusTypeName+", ",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objTest_data.strRegionName ,
					EventStartTime,
					strEventEndTime ,
					objView_data.strSectionName};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description :  Verify that user with the only right ‘Override viewing restrictions’ can view private status types on
					1. Region View screen
					2. View Resource Detail screen
					3. Map screen
					4. Event Status screen 
	'Precondition:
	'Date	 	 : 20-July-2015
	'Author		 : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = " Verify that user with the only right ‘Override viewing restrictions’ can view private status types on"+
			"1. Region View screen"+
			"2. View Resource Detail screen"+
			"3. Map screen"+
			"4. Event Status screen ")
	public void testHappyDay81317() throws Exception {

		gstrTCID = "81317";
		gstrTO = " Verify that user with the only right ‘Override viewing restrictions’ can view private status types on"
				+ "1. Region View screen"
				+ "2. View Resource Detail screen"
				+ "3. Map screen" + "4. Event Status screen ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		boolean blnTest = false;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName)
				.createNewStatus(
			     objStatuTypes_data.strStatusNameInMulti,
			     objStatuTypes_data.strStatusColor)
			  .createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
			      objStatuTypes_data.strStatusColor)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);
		objEventSetUp.deselectSelectAllWebOption();

		objNavigationToSubMenus.navigateToViews();
		
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

	/*	objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc);
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();*/
		
		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objUsersList1
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.deselectAllViewResReightOption()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectOverrideViewingRestrictionOption().clickSaveButton();

		objUsersList1.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strEquals);

		System.out.println(objUser_data.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox().selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String EventStartTime = objEventManagement1
				.getEventStartDateAndTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		//Removed because of as designed issue of EMS-8220
		/*objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		Thread.sleep(3000);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);

		}

		objViews1.clickOnResource(objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews1.verStatusTypesUnderSection(strStatusTypeNames[i],
					objView_data.strSectionName);
		}*/

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName);
		objMap1.verStatusTypesInPopupWindow(strStatusTypeNames);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objTest_data.strPassword,
					objESetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition",

					objStatuTypes_data.strNSTStatusTypeName + ", "
							+ objStatuTypes_data.strMSTStatusTypeName + ", "
							+ objStatuTypes_data.strSSTStatusTypeName + ", "
							+ objStatuTypes_data.strTSTStatusTypeName + ", "
							+ objStatuTypes_data.strNDSTStatusTypeName + ", "
							+ objStatuTypes_data.strDateStatusTypeName + ", ",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objTest_data.strRegionName, EventStartTime,
					strEventEndTime, objView_data.strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description :   Verify that user with the only right ‘Override viewing restrictions’ right can view role based and shared status types on 
					1. Region View screen
					2. View Resource Detail screen
					3. Map screen
					4. Event Status screen 
	'Precondition:
	'Date	 	 : 27-July-2015
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = " Verify that user with the only right ‘Override viewing restrictions’ right can view role based and shared status types on "+
			"1. Region View screen"+
			"2. View Resource Detail screen"+
			"3. Map screen"+
			"4. Event Status screen ")
	public void testHappyDay81123() throws Exception {

		gstrTCID = "81123";
		gstrTO = " Verify that user with the only right ‘Override viewing restrictions’ right can view role based and shared status types on "
				+ "1. Region View screen"
				+ "2. View Resource Detail screen"
				+ "3. Map screen" + "4. Event Status screen ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strSharedStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		boolean blnTest = false;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName)
				.createNewStatus(
			     objStatuTypes_data.strStatusNameInMulti,
			     objStatuTypes_data.strStatusColor)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				      objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
				      objStatuTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
				      objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// ShareBased statustypes
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName)
				.createNewStatus(
			     objStatuTypes_data.strStatusNameInMulti,
			     objStatuTypes_data.strStatusColor)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				      objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
				      objStatuTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
				      objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strSharedStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName1);

		String[] strAllSTValues = ArrayUtils.addAll(strStatusTypeValues,
				strSharedStatusTypeValues);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strAllSTValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strAllSTValues);
		objEventSetUp.deselectSelectAllWebOption();

		objNavigationToSubMenus.navigateToViews();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strDateStatusTypeName1 };

		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc);
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();*/
		
		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);

		objLogin.clickLogOut();
		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objUsersList1
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.deselectAllViewResReightOption()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectOverrideViewingRestrictionOption().clickSaveButton();

		objUsersList1.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strEquals);

		System.out.println(objUser_data.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox().selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String EventStartTime = objEventManagement1
				.getEventStartDateAndTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		//Removed because of as designed issue of EMS-8220
		/*objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		Thread.sleep(3000);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);

		}

		objViews1.clickOnResource(objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews1.verStatusTypesUnderSection(strStatusTypeNames[i],
					objView_data.strSectionName);
		}*/

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName);
		objMap1.verStatusTypesInPopupWindow(strStatusTypeNames);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objTest_data.strPassword,
					objESetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition",

					objStatuTypes_data.strNSTStatusTypeName + ", "
							+ objStatuTypes_data.strMSTStatusTypeName + ", "
							+ objStatuTypes_data.strSSTStatusTypeName + ", "
							+ objStatuTypes_data.strTSTStatusTypeName + ", "
							+ objStatuTypes_data.strNDSTStatusTypeName + ", "
							+ objStatuTypes_data.strDateStatusTypeName + ", ",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objTest_data.strRegionName, EventStartTime,
					strEventEndTime, objView_data.strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}

		gstrResult = "PASS";
	}
}
