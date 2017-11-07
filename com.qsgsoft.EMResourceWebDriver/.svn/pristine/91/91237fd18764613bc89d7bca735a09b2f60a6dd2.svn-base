package requirementGroup.SmokeTestSuite;

import java.util.Arrays;

import lib.dataObject.*;
import lib.module.NavigationToSubMenus;
import lib.page.*;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeMultiRegionFeatures extends TestNG_UI_EXTENSIONS {

	public SmokeMultiRegionFeatures() throws Exception {
		super();
	}
	
	/*************************************************************************************
	 * 'Description 	: Create a multi-region event selecting to start immediately and to end after 
	 * 						certain number of hours and verify that the multi-region event starts immediately and ends 
	 * 						after the specified number of hours.
	 * 'Precondition	: 
	 * 'Date 			: 04-Sep-2014 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Create a multi-region event selecting to start immediately and to end after "
			+ "certain number of hours and verify that the multi-region event starts immediately and "
			+ "ends after the specified number of hours.")
	public void testSmoke137589() throws Exception {

		gstrTCID = "137589";
		gstrTO = " Create a multi-region event selecting to start immediately and to end after certain "
				+ "number of hours and verify that the multi-region event starts immediately and ends "
				+ "after the specified number of hours.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();

		String strStatusTypeValues[] = new String[6];
		String strStatusTypeValuesInReg2[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String stMultiStatus = objEventSetUp_data.stMultiStatus;
		String strEventStatus = objEventSetUp_data.strEventStatus;

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		String[] strAllRegions = {objLogindata.strRegionName1, objLogindata.strRegionName2};
		Arrays.sort(strAllRegions);

		objRegionDefault.selectFrame();
		
		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName1)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName1)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName1)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strStatusTypeValuesInReg2[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strStatusTypeValuesInReg2[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition,
				strResourceTypeValueInReg2, strStatusTypeValuesInReg2);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0]).clickSaveButton();
		System.out.println(objUserdata.strNewUserName);

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objUsersList.navigateToUsers()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objEvent_data.strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm",
				"yyyy-MM-dd HH:mm");

		objEvent_data.strEventEndTime = objDts.addTimetoExistingHour(
				objEvent_data.strEventStartTime, 4, "yyyy-MM-dd HH:mm");

		String strStartTime = objDts.converDateFormat(
				objEvent_data.strEventStartTime, "yyyy-MM-dd HH:mm",
				"MM/dd/yyyy HH:mm");

		String strEndTimeInwords = objEvent_data.strEventEndTimeInHours1
				+ " hours after event start";

		objEventManagement1
				.enterEventEndTime(objEvent_data.strEventEndTimeInHours1)
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyInfoInMultiRegionEventConfirmationPage(
						objEvent_data.strEventName,
						objEvent_data.strEventDescription, strStartTime,
						strEndTimeInwords)
				.verifyRegionAndETName(strAllRegions[0],
						objEventSetUp_data.strEventTemplate)
				.verifyRegionAndETName(strAllRegions[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnYesButton()
				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, objEventSetUp_data.strEventTemplate,
						objEvent_data.strEventStartTime,
						objEvent_data.strEventEndTime, stMultiStatus);

		objSelectRegionpage1
				.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, objEventSetUp_data.strEventTemplate1,
						objEvent_data.strEventStartTime,
						objEvent_data.strEventEndTime, stMultiStatus)

				.verifyEventNameInEventBanner(objEvent_data.strEventName);

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	:  Verify that 'Select Resources' page displays the appropriate resource types corresponding to the resources 
	 * 						available in their respective regions.
	 * 'Precondition	: 
	 * 'Date 			: 05-Sep-2014 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that 'Select Resources' page displays the appropriate resource types corresponding to the "
			+ "resources available in their respective regions.")
	public void testSmoke137763() throws Exception {

		gstrTCID = "137763";
		gstrTO = " Verify that 'Select Resources' page displays the appropriate resource types corresponding to the "
				+ "resources available in their respective regions.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strStatusTypeValuesInReg2[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = {objLogindata.strRegionName1, objLogindata.strRegionName2};
		Arrays.sort(strAllRegions);

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnWebNotification(objUserdata.strFullName, true)
				.clickSaveButton();

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objUsersList.navigateToUsersNew()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objEventSetUp_data.strEventTemplate1,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate1)
				.clickOnWebNotification(objUserdata.strFullName, true)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.deselectIncludeAllResourcesOption()
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyRegionName(strAllRegions[0])
				.verifyRSAndRTName(objResource_data.strResourceName,
						objResourceType_data.strResourceTypeName)
				.clickOnNextButton()
				.verifyRegionName(strAllRegions[1])
				.verifyRSAndRTName(objResource_data.strResourceName1,
						objResourceType_data.strResourceTypeName1)
				.selectResource(strResourceValueInReg2)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that all the resources created under the selected event template 
	 *                    while creating a multi-region are added to the multi-region event when 
	 *                    'Include all resources?' checkbox is selected.
	 * 'Precondition	: 
	 * 'Date 			: 05-Sep-2014 
	 * 'Author 			: Sowmya
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that all the resources created under the selected event template while creating a "
			+ "multi-region are added to the multi-region event when 'Include all resources?' checkbox is selected.")
	public void testSmoke137590() throws Exception {

		gstrTCID = "137590";
		gstrTO = "Verify that all the resources created under the selected event template while creating "
				+ "a multi-region are added to the multi-region event when 'Include all resources?' checkbox is selected.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Roles_data objRoles_data = new Roles_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Regions objRegions = new Regions(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strstatusTypeValues1[] = new String[5];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRoleValue1[] = new String[1];
		String strRegionValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

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

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		System.out.println("ET1 " + objESetUp_data.strEventTemplate);

		// User1 creation
		String[] strRegionNames = { objTest_data.strRegionName,
				objTest_data.strRegionName2 };

		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions.getRegionValue(strRegionNames[0]);

		strRegionValue[1] = objRegions.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[0]);
		System.out.println(strRegionValue[1]);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1])
				.clickSaveButton();
				
				

		System.out.println("user1 " + objUser_data.strNewUserName);

		// Navigate to Region B
//		objRegionDefault.clickRegionLink();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName2);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName1);

		strRoleValue1[0] = objRoles.getRoleValue(objRoles_data.strRoleName1);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strstatusTypeValues1);

		System.out.println("ET2 " + objESetUp_data.strEventTemplate1);

		// User in Region B
		objUsersList
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValue1)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
						.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.verifySelectAllButton()
				.clickOnRegionName(strRegionValue[0])
				.clickOnRegionName(strRegionValue[1])
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				           .createNewMultiEventButton().verifyCreateMultiRegionEventPage();

		objEventManagement1
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyRegionAndETName(objTest_data.strRegionName,
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(objTest_data.strRegionName2,
						objESetUp_data.strEventTemplate1)
						.verifyYesButton()
				.clickOnYesButton()
				.verWebNotificationframe()
				.clickAcknowledgeAllNotifications()
				.selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objRegionDefault1.clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName2);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName1,
				objResource_data.strResourceName1);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that user is taken to 'Event status' page when clicked 
	 * on the URL available on the notifications received for a multi region event
	 * 'Precondition	: 
	 * 'Date 			: 05-Sep-2014 
	 * 'Author 			: Sinchana
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that user is taken to 'Event status' page when clicked "
			+ "on the URL available on the notifications received for a multi region event")
	public void testSmoke137762() throws Exception {

		gstrTCID = "137762";
		gstrTO = " Verify that user is taken to 'Event status' page when clicked "
				+ "on the URL available on the notifications received for a multi region event";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strStatusTypeValuesInReg2[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];
	
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = {objLogindata.strRegionName, objLogindata.strRegionName1};
		Arrays.sort(strAllRegions);

		objSelectRegionpage.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status Types in Region1
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
		
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName};
		
		String strAllStatusTypeNames1[] = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strDateStatusTypeName1};

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region1
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region1
		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objUsersList
		.navigateToUsersNew()
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUserdata.strNewUserName,
				objUserdata.strRole, objUserdata.strResourceType,
				objUserdata.strUsername, objUserdata.strsearchOption)
		.clickRegionsLinkForUser(objUserdata.strNewUserName)
		.selectRegion(strRegionValue[1]).clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		
		objEventSetUp.navigateToEventSetUp();
		
		// Create Event Template in Region2
				objEventSetUp.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues);

				System.out.println(objESetUp_data.strEventTemplate);
				
				objEventSetUp.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUserdata.strFullName, true)
				.clickOnPagerNotification(objUserdata.strFullName, true)
				.clickOnWebNotification(objUserdata.strFullName, true)
				.clickSaveButton();

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status types in Region2
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);
		
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region2
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region2
		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		
		objUsersList
		.navigateToUsersNew()
		.searchUserName(objUserdata.strNewUserName,
				objUserdata.strRole, objUserdata.strResourceType,
				objUserdata.strUsername, objUserdata.strsearchOption)
		.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
		.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
		.clickSaveButton();
	
		
		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region2
		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition,
				strResourceTypeValueInReg2, strStatusTypeValuesInReg2);

		System.out.println(objESetUp_data.strEventTemplate1);

		objEventSetUp.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate1)
				.clickOnEmailNotification(objUserdata.strFullName, true)
				.clickOnPagerNotification(objUserdata.strFullName, true)
				.clickOnWebNotification(objUserdata.strFullName, true)
				.clickSaveButton();

		objLogin.clickLogOut();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");
		

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton();
		
		objLogin1.clickLogOut();
		

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton();
		
		objLogin1.clickLogOut();
		

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
						
		objSelectRegionpage1
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications()
				.selectFrame();

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;
		
		System.out.println(strSubject);
		

		objMailVerificationFunctions.NavToInbox(strSubject);

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + strAllRegions[0]
				+ ", " + strAllRegions[1]
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
				+ strAllRegions[0]
				+ ", " + strAllRegions[1];

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		String strUrlLink = "";

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
				if (blnMsg1 == true) {
					strUrlLink = objMailVerificationFunctions
							.GetUrlLinkFromMsgBody(
									objUser_data.strPrimaryMailId, strSubject);
				}
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		objMailVerificationFunctions.launchUrl(strUrlLink);
		
		String strRegLink[] = strUrlLink.split("=");

		objRegionDefault1.selectFrame();

		objEventStatus1.verifyEventStatus();
		
		if(strRegLink[3] == strRegionValue[0]){
			objEventStatus1.verResourceTypeAndResourceName(
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName);

			for (int i = 0; i < strAllStatusTypeNames.length; i++) {

				objEventStatus1.verStatusTypes(
						objResourceType_data.strResourceTypeName,
						strAllStatusTypeNames[i]);
			}
		}else{
			objEventStatus1.verResourceTypeAndResourceName(
					objResourceType_data.strResourceTypeName1,
					objResource_data.strResourceName1);

			for (int i = 0; i < strAllStatusTypeNames1.length; i++) {

				objEventStatus1.verStatusTypes(
						objResourceType_data.strResourceTypeName1,
						strAllStatusTypeNames1[i]);
			}
		}
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :  Verify that user without "Configure Multi-Region Views" and with "Configure region view" 
					right can view/delete/demote/assigns users to a multi region view.
	'Precondition:
	'Date	 	 : 08-Aug-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(enabled = false,description = " Verify that user without Configure Multi-Region Views and with Configure region view right "
			+ "can view/delete/demote/assigns users to a multi region view")
	public void testSmoke137571() throws Exception {

		gstrTCID = "137571";
		gstrTO = " Verify that user without Configure Multi-Region Views and with Configure region view right "
				+ "can view/delete/demote/assigns users to a multi region view.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectConfigureMultiRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objResource_data.strResourceName);
		System.out.println(strStatusTypeValues[0] + " " + objStatusTypes_data.strNSTStatusTypeName);
		System.out.println(strResourceValue[0]+ " " + objResource_data.strResourceName);

		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave()
				.clickOnPromote();

		objViewsList.verRegionViewListPageIsDisplayed().verViewInList(
				objView_data.strCustomView);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToViews();

		System.out.println(objView_data.strCustomView);
		objViewsList1
				.verViewInList(objView_data.strCustomView)
				.verDeleteAssociatedWithMulRegView(objView_data.strCustomView)
				.verUsersAssociatedWithMulRegView(objView_data.strCustomView)
				.clickOnUsersAssociatedWithMulRegView(
						objView_data.strCustomView)
				.verAssgnUserToViewCustomPgeIsDisplayed(
						objView_data.strCustomView)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName1)
				.clickOnSave()
				.verViewInList(objView_data.strCustomView)
				.verDemoteLinkAssociatedWithMulRegViewIsNotDisplayed(
								objView_data.strCustomView);

		objViewsList1
				.clickOnDeleteAssociatedWithMulRegView(
						objView_data.strCustomView)
				.verDelViewConfPgeIsDisplayed()
				.verDelViewConfirmationPge()
				.clickOnDelete()
				.verViewIsNotListed(objView_data.strCustomView);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that all the resources created under the selected event template 
	 *                    while creating a multi-region are added to the multi-region event when 
	 *                    'Include all resources?' checkbox is selected.
	 * 'Precondition	: 
	 * 'Date 			: 08-Sep-2014 
	 * 'Author 			: Sowmya
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that all the resources created under the selected event template while creating a "
			+ "multi-region are added to the multi-region event when 'Include all resources?' checkbox is selected.")
	public void testSmoke137592() throws Exception {

		gstrTCID = "137592";
		gstrTO = "Verify that all the resources created under the selected event template while creating "
				+ "a multi-region are added to the multi-region event when 'Include all resources?' checkbox is selected.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Roles_data objRoles_data = new Roles_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Regions objRegions = new Regions(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strstatusTypeValues1[] = new String[6];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRoleValue1[] = new String[1];
		String strRegionValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		// User1 creation
		String[] strRegionNames = { objTest_data.strRegionName,
				objTest_data.strRegionName2 };
		Arrays.sort(strRegionNames);

		objRegionDefault.selectFrame();
		
		objSelectRegion.selectRegionAndNavigate(strRegionNames[0]);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions.getRegionValue(strRegionNames[0]);

		strRegionValue[1] = objRegions.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[0]);
		System.out.println(strRegionValue[1]);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

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

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		System.out.println("ET1 " + objESetUp_data.strEventTemplate);

		objNavigationToSubMenus.navigateToUsers();
		
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println("user1 " + objUser_data.strNewUserName);

//		// Navigate to Region B
//		objRegionDefault.clickRegionLink();

		objSelectRegion.selectRegionAndNavigate(strRegionNames[1]);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName1);

		strRoleValue1[0] = objRoles.getRoleValue(objRoles_data.strRoleName1);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strstatusTypeValues1);

		System.out.println("ET2 " + objESetUp_data.strEventTemplate1);

		// User in Region B
		objUsersList
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValue1)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1]).verifySelectAllButton()
				.clickOnRegionName(strRegionValue[0])
				.clickOnRegionName(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate1)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate1)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
						   .createNewMultiEventButton()
						   .verifyCreateMultiRegionEventPage();

		objEventManagement1
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.clickOnNextButton()
				.verifyRegionAndETName(strRegionNames[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strRegionNames[1],
						objESetUp_data.strNone).clickOnYesButton()
				.verWebNotificationframe().clickAcknowledgeAllNotifications()
				.selectFrame();

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strMultiRegionEvent);

		objRegionDefault1.clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[1]);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();

		objEventManagement1
				.verifyEventNameNotDisplayedInEventBanner(objEvent_data.strMultiRegionEvent);

		objRegionDefault1.clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[0]);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();

		objEventManagement1.navigateToEventManagement();

		objEventManagement1.verifyEventName(objEvent_data.strMultiRegionEvent)
				.clickOnEditLink(objEvent_data.strMultiRegionEvent);

		objEventManagement1
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton(); Thread.sleep(1000);
	    objEventManagement1.clickOnNextButton()
				.selectResource(strResourceValue1)
				.clickOnNextButton()
				.verifyRegionAndETName(strRegionNames[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strRegionNames[1],
						objESetUp_data.strEventTemplate1)
				.verifyYesButton()
				.clickOnYesButton()
				.verWebNotificationframe()
				.clickAcknowledgeAllNotifications()
				.selectFrame();

		String multiRegionEvent = "Update 1: "
				+ objEvent_data.strMultiRegionEvent;

		System.out.println("Up 1 " + multiRegionEvent);

		objEventManagement1.verifyEventNameInEventBanner(multiRegionEvent);

//		objRegionDefault1.clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement();

		objEventManagement1.verifyEventNameInEventBanner(multiRegionEvent);

		objEventManagement1
				.verifyEventName(objEvent_data.strMultiRegionEvent)
				.clickOnEditLink(objEvent_data.strMultiRegionEvent)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strNotParticipationg);

		objEventManagement1.clickOnNextButton();
		Thread.sleep(10000);
		objEventManagement1.clickOnNextButton();

		objEventManagement1
				.verifyRegionAndETName(strRegionNames[0],
						objESetUp_data.strNone)

				.verifyRegionAndETName(strRegionNames[1],
						objESetUp_data.strEventTemplate1).verifyYesButton()
				.clickOnYesButton().verWebNotificationframe()
				.clickAcknowledgeAllNotifications().selectFrame();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		System.out.println(strApplicationTime);

		String multiRegionEvent1 = "Update 2: "
				+ objEvent_data.strMultiRegionEvent;

		System.out.println("Up 2 " + multiRegionEvent1);

		objEventManagement1
				.verifyEventNameNotDisplayedInEventBanner(multiRegionEvent1);

		objRegionDefault1.clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[1]);

		objRegionDefault1.selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(multiRegionEvent1);

		objLogin1.clickLogOut();

		String strSubject = objEvent_data.strMultiRegionEvent;

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: "
				+ objEvent_data.strMultiRegionEventDescription + "\n\n"
				+ "From: " + objUser_data.strFullName + "\n\n" + "Regions: "
				+ strRegionNames[0]
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strMultiRegionEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
				+ strRegionNames[0];

		String strSubject1 = "Update 1: " + objEvent_data.strMultiRegionEvent;

		String strMsgBody3 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Region: " + strRegionNames[1]
				+ "Information: "
				+ objEvent_data.strMultiRegionEventDescription + "\n"
				+ "From: " + objUser_data.strFullName + "\n" + "Regions: "
				+ strRegionNames[0] + ", "
				+ strRegionNames[1]
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody4 = "Region: " + strRegionNames[1]
				+ "now participating" + "\n" + "Information: "
				+ objEvent_data.strMultiRegionEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
				+ strRegionNames[0] + ", "
				+ strRegionNames[1];

		String strSubject2 = "Update 2: " + objEvent_data.strMultiRegionEvent;

		String strMsgBody5 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Region: " + strRegionNames[0]
				+ "Information: "
				+ objEvent_data.strMultiRegionEventDescription + "\n"
				+ "From: " + objUser_data.strFullName + "\n" + "Regions: "
				+ strRegionNames[0] + ", "
				+ strRegionNames[1]
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody6 = "Region: " + strRegionNames[0]
				+ "no longer participating as of" + "\n" + "Information: "
				+ objEvent_data.strMultiRegionEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
				+ strRegionNames[0] + ", "
				+ strRegionNames[1];

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {

				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject1);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject2);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody5);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	:  Verify that ending multi-region event in a region ends the event in other regions as well.
	 * 'Precondition	: 
	 * 'Date 			: 08-Sep-2014 
	 * 'Author 			: Sinchana
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "  Verify that ending multi-region event in a region ends the event in other regions as well.")
	public void testSmoke137733() throws Exception {

		gstrTCID = "137733";
		gstrTO = "  Verify that ending multi-region event in a region ends the event in other regions as well.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
	
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		String strStatusTypeValues[] = new String[5];
		String strStatusTypeValuesInReg2[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status Types in Region1
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region1
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region1
		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		// Create User in Region1
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		// Create Event Template in Region1
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition, strResourceTypeValue,
						strStatusTypeValues);

		System.out.println(objESetUp_data.strEventTemplate);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objUsersList
				.navigateToUsers()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton().editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1]).verifySelectAllButton()
				.clickOnRegionName(strRegionValue[0])
				.clickOnRegionName(strRegionValue[1]).clickSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status types in Region2
		objStatusTypeList.createEventStatusType(
					objStatusTypes_data.strNumberStatusType,
					objStatusTypes_data.strNSTStatusTypeName1,
					objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region2
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region2
		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region2
		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition,
				strResourceTypeValueInReg2, strStatusTypeValuesInReg2);

		System.out.println(objESetUp_data.strEventTemplate1);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1
		        .selectRegionAndNavigate(objLogindata.strRegionName1);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickEventNeverEndRadioButton()
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.clickOnKeepButton()
				.verifyRegionAndETName(objLogindata.strRegionName1,
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(objLogindata.strRegionName2,
						objESetUp_data.strEventTemplate1).clickOnYesButton();
		
	    objEventManagement1
	            .verifyEventEndTimeWhenItSetToNever(
					objEvent_data.strEventName, "never")
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1
		        .clickOnEndEvent(objEvent_data.strEventName)
				.verWebNotificationframe()
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.verifyEventName(objEvent_data.strEventName)
				.verifyViewHistoryLink(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		objEventManagement1
		        .clickOnViewHistoryLink(objEvent_data.strEventName)
				.verWebNotificationframe()
				.verifyEventHistoryPopUp()
				.verifyEventEndedInViewHistoryPopUp(objEvent_data.strEventName);
				
		objEventManagement1
		        .clickOnCloseBtn()
				.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strEnded)
				.verifyEventEndTime(objEvent_data.strEventName, strEventEndTime);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Access to 2 Regions: Verify that a user with appropriate right in one region can view 
	 * 						resources and status types from another region on different view screens.
	 * 'Precondition	: 
	 * 'Date 			: 09-Sep-2014 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Access to 2 Regions: Verify that a user with appropriate right in one region can view resources and "
			+ "status types from another region on different view screens.")
	public void testSmoke117549() throws Exception {

		gstrTCID = "117549";
		gstrTO = "Access to 2 Regions: Verify that a user with appropriate right in one region can view resources and status types"
				+ " from another region on different view screens.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Views objViews = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[18];
		String strEventStatusTypeValues[] = new String[18];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[1]);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectViewcustomViewOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0]).clickSaveButton();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName).clickOnReturnToStatusTypeList();
		System.out.println(objStatusTypes_data.strMSTStatusTypeName);
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName).clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName).clickOnReturnToStatusTypeList();
		strStatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName).clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[9] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[9] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[10] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[10] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[11] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[11] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[12] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithEventSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[12] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName).clickOnReturnToStatusTypeList();
		strStatusTypeValues[13] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithEventSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName).clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[13] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[14] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithEventSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[14] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[15] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithEventSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[15] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[16] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithEventSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[16] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[17] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithEventSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[17] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName2);

		String[] strAllStatusTypes = ArrayUtils.addAll(strStatusTypeValues,
				strEventStatusTypeValues);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllStatusTypes);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		objResource
				.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
				.clickOnshareWithOtherReg().clickOnSaveButton();

		objResource.createResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);
		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strAllStatusTypes).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName1);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue).clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName)
		.verifyEventNameInEventBanner(objEvent_data.strEventName);

		objSelectRegionpage1
		.selectRegionAndNavigate(objLogindata.strRegionName2);
		
		objRegionDefault1.selectFrame();
		
		String[] strResNames = { objResource_data.strResourceName,
				objResource_data.strResourceName1 };
		String strRes = objResource_data.strResourceName.substring(2,
				objResource_data.strResourceName.length());
		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strDateStatusTypeName2,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName2,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName2 };

		String[] strEventStatusTypeNames = {
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.streDateStatusTypeName1,
				objStatusTypes_data.streDateStatusTypeName2,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.streNDSTStatusTypeName1,
				objStatusTypes_data.streNDSTStatusTypeName2,
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.streNSTStatusTypeName1,
				objStatusTypes_data.streNSTStatusTypeName2,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.streMSTStatusTypeName1,
				objStatusTypes_data.streMSTStatusTypeName2,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.streTSTStatusTypeName1,
				objStatusTypes_data.streTSTStatusTypeName2,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.streSSTStatusTypeName1,
				objStatusTypes_data.streSSTStatusTypeName2 };

		String[] strAllStatusTypeNames = ArrayUtils.addAll(strStatusTypeNames,
				strEventStatusTypeNames);

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView
				.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(strRes)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.verEditCustomViewScreenIsDisplayed()
				.verCreatedSection(objResourceType_data.strResourceTypeName)
				.verResourceNamesInList(strResNames,
						objLogindata.strRegionName1,
						objResourceType_data.strResourceTypeName)
				.clickOnOptions()
				.selectStatusTypes(strStatusTypeValues)
				.selectAllChkBoxInOptions()
				.clickOnSave()
				.verResourceAndResTypeInCustomViewTablePage(strResNames,
						objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames)
				.selResourceInCustomViewTablePage(
						objResource_data.strResourceName);

		objViews.verViewResourceDetailsPgeIsDisplayed();

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews.verStatusTypesUnderSection(strStatusTypeNames[i],
					objView_data.strSectionName);
		}

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		for (int i = 0; i < strResNames.length; i++) {
			objEventStatus1.verResourceTypeAndResourceName(
					objResourceType_data.strResourceTypeName, strResNames[i]);
		}
		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
		
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify a private multi region event can be created.
	 * 'Precondition	: 
	 * 'Date 			: 09-Sep-2014 
	 * 'Author 			: Sinchana
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify a private multi region event can be created.")
	public void testSmoke137740() throws Exception {

		gstrTCID = "137740";
		gstrTO = " Verify a private multi region event can be created";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Roles objRoles = new Roles(this.driver1);

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValuesInReg2[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strRoleValueInReg2[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = {objLogindata.strRegionName1, objLogindata.strRegionName2};
		Arrays.sort(strAllRegions);

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(strAllRegions[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(strAllRegions[1]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status Types in Region1
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region1
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region1
		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		System.out.println(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region1
		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);
		objEventSetUp.clickSaveButton();
		
		System.out.println(objESetUp_data.strEventTemplate);

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("1u " + objUser_data.strNewUserName);

		// Create user2
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName1)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("2u " + objUser_data.strNewUserName1);

		// Create user3
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName2,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName2)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("3u " + objUser_data.strNewUserName2);

		// Create user4
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName3,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName3)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("4u " + objUser_data.strNewUserName3);

		// Create user5
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName4,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectOverrideViewingRestrictionOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName4,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName4)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("5u " + objUser_data.strNewUserName4);

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status types in Region2
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region2
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region2
		objResource.createResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region2
		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition,
				strResourceTypeValueInReg2, strStatusTypeValuesInReg2);

		objEventSetUp.clickSaveButton();
		
		System.out.println(objESetUp_data.strEventTemplate1);

		// Create role in Region2
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValueInReg2[0] = objRoles
				.getRoleValue(objRoles_data.strRoleName);

		// Provide rights for users to Region2
		objUsersList
				.navigateToUsersNew()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValueInReg2)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton()
				.clickSaveButton();

		// Create user2
		objUsersList
				.searchUserName(objUser_data.strNewUserName1,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName1)
				.selectRoleCheckBox(strRoleValueInReg2)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectAssociateWithOfResource(
						objResource_data.strResourceName1).clickSaveButton();

		// Create user3
		objUsersList
				.searchUserName(objUser_data.strNewUserName2,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName2)
				.selectRoleCheckBox(strRoleValueInReg2)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.clickSaveButton();

		// Create user4
		objUsersList
				.searchUserName(objUser_data.strNewUserName3,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName3)
				.selectRoleCheckBox(strRoleValueInReg2)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectRunReportsCheckBox(objResource_data.strResourceName1)
				.clickSaveButton();

		// Create user5
		objUsersList
				.searchUserName(objUser_data.strNewUserName4,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName4)
				.selectRoleCheckBox(strRoleValueInReg2)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectOverrideViewingRestrictionOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.clickPrivateCheckBox()
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyRegionAndETName(strAllRegions[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strAllRegions[1],
						objESetUp_data.strEventTemplate1).clickOnYesButton()
				.verWebNotificationframe().clickAcknowledgeAllNotifications()
				.selectFrame();

		System.out.println("Multi Region Event"
				+ objEvent_data.strMultiRegionEvent);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceNameIsNotDisplayed(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verResourceNameInPopupWindow(
				objResource_data.strResourceName);

		String[] strStatusTypeName1 = { objStatusTypes_data.strNSTStatusTypeName };

		objMap1.verStatusTypesInPopupWindow(strStatusTypeName1);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verWebNotificationframe()
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceNameIsNotDisplayed(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verResourceNameInPopupWindow(
				objResource_data.strResourceName);

		String[] strStatusTypeValues2 = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objMap1.verStatusTypesInPopupWindow(strStatusTypeValues2);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verWebNotificationframe()
				           .clickAcknowledgeAllNotifications()
				           .selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verWebNotificationframe()
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName4,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verWebNotificationframe()
				           .clickAcknowledgeAllNotifications()
				           .selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
			   .verResourceNameInPopupWindow(objResource_data.strResourceName)
			   .verStatusTypesInPopupWindow(strAllStatusTypeNames);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	:   Verify that user with appropriate right is able to view 'Event Status' by clicking on event icon displayed corresponding to the resource on 
	 * 						tabular views (Region Views, Custom Views, Other Region Views).
	 * 'Precondition	: 
	 * 'Date 			: 07-Oct-2014 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that user with appropriate right is able to view 'Event Status' by clicking on event icon displayed corresponding to "
			+ "the resource on tabular views (Region Views, Custom Views, Other Region Views).")
	public void testSmoke147225() throws Exception {

		gstrTCID = "147225";
		gstrTO = " Verify that user with appropriate right is able to view 'Event Status' by clicking on event icon displayed corresponding to the resource on tabular views "
				+ "(Region Views, Custom Views, Other Region Views).";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Views objViews = new Views(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strArkansasReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		objResource
				.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
				.clickOnshareWithOtherReg().clickOnSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		String[] strStatusTypeNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
		
		objViewsList.clickOnEditOfRegDefault();

		objViewsList.clickOnResourcesTab()
					.selectResource(objResource_data.strResourceName)
					.clickNextButton();
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList.clickOnSaveOfCreateNewView();

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole().clickSaveButton();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strSetracReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().selectViewOtherRegView(objLogindata.strArkansasRegVal)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName1);
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		System.out.println(objEvent_data.strEventName);
		System.out.println(objResource_data.strResourceName);
		
		objViews.verEventIconWithResource(objEvent_data.strEventName,
				objResource_data.strResourceName).clickOnEventIconWithResource(
				objEvent_data.strEventName, objResource_data.strResourceName);

		objEventStatus1.verifyEventStatus().verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objViews.verEventIconWithResource(objEvent_data.strEventName,
				objResource_data.strResourceName).clickOnEventIconWithResource(
				objEvent_data.strEventName, objResource_data.strResourceName);

		objEventStatus1.verifyEventStatus().verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objNavigationToSubmenus1
				.navigateToRegUnderOtherRegions(objLogindata.strArkansasReg);

		objRegionDefault1
				.verifyParticularRegPageIsDisplayed(objLogindata.strArkansasReg);

		objViews.verEventIconWithResource(objEvent_data.strEventName,
				objResource_data.strResourceName).clickOnEventIconWithResource(
				objEvent_data.strEventName, objResource_data.strResourceName);

		objEventStatus1.verifyEventStatus().verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	:  Verify that user can access multi-region view created in the logged in 
					   region when there exists mutual agreement and region access between the two regions.
	'Precondition	: 
	'Date 			: 07-Oct-2014 
	'Author 		: Prasanna Lakshmi
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	
	@Test(description = " Verify that user can access multi-region view created in the logged in region when there exists mutual agreement and region access between the two regions.")
	public void testSmoke147226() throws Exception {

		gstrTCID = "147226";
		gstrTO = " Verify that user can access multi-region view created in the logged in region when there exists mutual agreement and region access between the two regions";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
	
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
	
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1 = new Views(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
	
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
	
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
	
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strArkansasReg);
	
		objRegionDefault.selectFrame();
	
		objNavigationToSubmenus.navigateToRegions();
	
		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strArkansasReg);
	
		System.out.println(strRegionValue[0]);
	
		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strSetracReg);
	
		System.out.println(strRegionValue[1]);
	
		objNavigationToSubmenus.navigateToStatusTypesInSetup();
	
		// Create Status Types in Arkansas
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
	
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
	
		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();
	
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
	
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
	
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
	
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
	
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
	
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
	
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
	
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);
	
		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
	
		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName };
	
		objNavigationToSubmenus.navigateToResourceTypesInSetup();
	
		// Create Resource Type in Arkansas
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);
	
		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	
		objNavigationToSubmenus.navigateToResourceInSetup();
	
		// Create Resource in Region1
		objResource.createResourceWithAddress(objResource_data.strResourceName,
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
	
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.selectConfigureMultiRegionViewsOption().clickSaveButton();
	
		System.out.println(objUserdata.strNewUserName);
	
		// User2 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
					.selectFirstRole()
				.selectViewOtherRegView(objLogindata.strSetracRegVal)
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName1,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
				.clickRegionsLinkForUser(objUserdata.strNewUserName1)
				.selectRegion(strRegionValue[1]).clickSaveButton();
		objLogin.clickLogOut();
	
		System.out.println(objUserdata.strNewUserName1);
	
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
	
		objRegionDefault.selectFrame();
	
		objNavigationToSubmenus.navigateToCustomInView();
	
		objCustomUnderView.clickOnSetupCustomViewLink()
			    .enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();
		System.out.println(objView_data.strCustomView);
	
		String strUserNames[] = { objUserdata.strNewUserName,
				objUserdata.strNewUserName1 };
	
		objLogin.clickLogOut();
	
		// 2 nd step
	
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
	
		objRegionDefault1.selectFrame();
	
		objNavigationToSubmenus1.navigateToParticularViewUnderViewMenu(objView_data.strCustom);
	
		objViews1.verCustomViewTableisDisplayed();
	
		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}
	
		objCustomUnderView1.clickOnPromote();
	
		objViewsList1
				.verRegionViewListPageIsDisplayed()
				.verViewInList(objView_data.strCustomView)
				.clickOnUsersAssociatedWithMulRegView(objView_data.strCustomView)
				.verAssgnUserToViewCustomPgeIsDisplayed(objView_data.strCustomView);
	
		for (int i = 0; i < strUserNames.length; i++) {
			objViewsList1.selUserInMulRegView(strUserNames[i]);
		}
	
		objCustomUnderView1.clickOnSave();
		
		objViewsList1.verRegionViewListPageIsDisplayed();
	
		objLogin1.clickLogOut();
	
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
	
		objRegionDefault1.selectFrame();
	
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);
	
		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
	
		}
		objLogin1.clickLogOut();
	
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strSetracReg);
		
		objRegionDefault1.selectFrame();
	
		objNavigationToSubmenus1.clickOnViewMenu();
		
		objViewsList1.verViewIsNotListed(objView_data.strCustomView);
	
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strArkansasReg);
	
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnViewMenu();
		
		objNavigationToSubmenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);
	
		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}