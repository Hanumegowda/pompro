package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreateEventTemplate extends TestNG_UI_EXTENSIONS{

	public NewCreateEventTemplate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*****************************************************************************************
	'Description	:Verify that event template can be created providing mandatory data.
	'Date	 		:17-June-2014
	'Author			:Anitha 
	******************************************************************************************/
	
	@Test(description = " Verify that event template can be created providing mandatory data.")
	public void testHappyDay68107() throws Exception {

		gstrTCID = "68107";
		gstrTO = " Verify that event template can be created providing mandatory data.";

		boolean blnTest = false;
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();
	    
		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton()
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verAllcheckBoxes()
				.verUsersListedInEvePrefPage(objUser_data.strNewUserName)
				.deselectSelectAllWebOption()
			    .verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verEveTemplateDescription(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition)
				.verEveTemplateIcon(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempIcon)
				.selectInactiveEventTemplateCheckBox()
				.verEveTemplateIsActive(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempActive)
				.deSelectInactiveEventTemplateCheckBox();

		EventManagement_page1.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.verifyEventTemplateIsDisplayed(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1.verEveTemplateIcon(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempIcon);
		
		EventManagement_page1.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventNameInEventBanner(objEvent_data.strEventName);

		login_page1.clickLogOut();
		
		blnTest = true;

		if (blnTest) {

			String[] strTestData1 = {
					gstrTCID,
					objTest_data.strRegionName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword, "", "", "", "",
					objEventSetUp_data.strEventTemplate,
					objEvent_data.strEventName };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "AdhocEvents");
		}

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************
	'Description	:Create an event template selecting resource types, status types and verify that the 
	                  associated resource is available while creating an event under it.
	'Date	 		:17-June-2014
	'Author			:Anitha 
	****************************************************************************************************/
	
	@Test(description = "Create an event template selecting resource types, status types and verify that the"
			+ " associated resource is available while creating an event under it.")
	public void testHappyDay68108() throws Exception {

		gstrTCID = "68108";
		gstrTO = "Create an event template selecting resource types, status types and verify that the associated "
				+ "resource is available while creating an event under it.";

		boolean blnTest = false;
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createStatusType(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

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

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();
	    
		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0]);
		
		for (int intCount = 0; intCount < strstatusTypeValues.length; intCount++) {
			objEventSetUp1.selectStatusType(strstatusTypeValues[intCount]);
		}
				
		objEventSetUp1.clickSaveButton()
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verAllcheckBoxes()
				.verUsersListedInEvePrefPage(objUser_data.strNewUserName)
				.deselectSelectAllWebOption()
			    .verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verEveTemplateDescription(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition)
				.verEveTemplateIcon(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempIcon)
				.selectInactiveEventTemplateCheckBox()
				.verEveTemplateIsActive(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempActive)
				.deSelectInactiveEventTemplateCheckBox();

		EventManagement_page1.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.verifyEventTemplateIsDisplayed(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1.verEveTemplateIcon(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempIcon);
		
		EventManagement_page1.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verifyResourceInSelectResourcePage(strResourceValue)
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventNameInEventBanner(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		login_page1.clickLogOut();
		
		blnTest = true;

		if (blnTest) {

			String[] strTestData1 = {
					gstrTCID,
					objTest_data.strRegionName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objStatusTypes_data.strNSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ","
							+ objStatusTypes_data.strNDSTStatusTypeName + ","
							+ objStatusTypes_data.strDateStatusTypeName + ","
							+ objStatusTypes_data.strSSTStatusTypeName,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "",
					objEventSetUp_data.strEventTemplate,
					objEvent_data.strEventName };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "AdhocEvents");
		}

		gstrResult = "PASS";
	}
	
	/************************************************************************************
	'Description	:Verify that event template can be created selecting 50 status types.
	'Date	 		:21-Dec-2014
	'Author			:Anitha 
	*************************************************************************************/
	
	@Test(description = " Verify that event template can be created selecting 50 status types.")
	public void testHappyDay162663() throws Exception {

		gstrTCID = "162663";
		gstrTO = " Verify that event template can be created selecting 50 status types.";

		Login_data objTest_data = new Login_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");

		Login login_page = new Login(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		Login login_page1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		int intCount = objStatusTypeList.getStatusTypeCount();

		if (intCount < 50) {

			for (int intCount1 = 0; intCount1 < (50 - intCount); intCount++) {
				String strNSTStatusTypeName = "NST" + intCount1 + strTimeText;
				objStatusTypeList.createStatusType(
						objStatuTypes_data.strNumberStatusType,
						strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription);
			}
		}

		String strStatusTypeValues1[] = new String[50];
		String strStatusTypeNames[] = objStatusTypeList.getStatusTypeNames(50);
		for (int intCount1 = 0; intCount1 < 50; intCount1++) {
			strStatusTypeValues1[intCount1] = objStatusTypeList
					.getStatusValue(strStatusTypeNames[intCount1]);
		}

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage();

		ResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0]);

		for (int intCount1 = 0; intCount1 < strStatusTypeValues1.length; intCount1++) {
			objEventSetUp1.selectStatusType(strStatusTypeValues1[intCount1]);
		}

		objEventSetUp1.clickSaveButton().deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
}
